package br.edu.unicid.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.a.ValueEncoder;


import br.edu.unicid.annotation.DBTable;
import br.edu.unicid.annotation.DBField;
import br.edu.unicid.bean.Categoria;
import br.edu.unicid.util.ConnectionFactory;

public class GenericoDaoTipo<T> {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private  Class<T> genericType;
	
	
	
	public GenericoDaoTipo(T genericType) throws Exception {
		
		// chama a Classe ConnectionFacotry
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception(erro.getMessage());
		}
	}

	//Metodo Salvar
	public void salvar(T objeto) throws Exception {
		if (objeto == null) {
			throw new Exception("Preencha as informações do " + objeto.getClass().getSimpleName());
		}
		DBTable classAnnotation = objeto.getClass().getAnnotation(DBTable.class);

		ArrayList<String> columns = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();

		Field[] fields = objeto.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			columns.add(field.getAnnotation(DBField.class).colummn());
			values.add(field.get(objeto).toString());
		}
		
		try {

			String SQL = "INSERT INTO " + classAnnotation.table() + "(" + String.join(", ", columns) + ") values ('"
					+ String.join("', '", values) + "')";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
			
		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	
	//Metodo Atualizar
	public void atualizar(T objeto) throws Exception  {
		if (objeto == null) {
			throw new Exception("Preencha as informações do " + objeto.getClass().getSimpleName());
		}
		
		DBTable  classAnnotation = objeto.getClass().getAnnotation(DBTable.class);
		
		ArrayList<String> columns = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		
		Field []  fields = objeto.getClass().getDeclaredFields();

		for(int i=0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			columns.add(field.getAnnotation(DBField.class).colummn());
			values.add(field.get(objeto).toString());
		}
		//Variável auxiliar para criar QUERY
		ArrayList<String> aux = new  ArrayList<String>();
		
		for(int i=0; i<columns.size(); i++) {
			aux.add(columns.get(i)+ "='" + values.get(i)+"'");
		}
		try {
			String SQL = "UPDATE " + classAnnotation.table() + " SET "+ String.join(",",aux) +" WHERE " + columns.get(0) + " = "+ values.get(0);
			System.out.println(SQL);
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
		}catch(SQLException sql) {
			throw new Exception("Erro ao atualizar os dados. " + sql);
		}finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
		
	}
	
	//metodo excluir
	public void excluir(T objeto) throws Exception {
		if (objeto == null) {
			throw new Exception("Preencha as informações do " + objeto.getClass().getSimpleName());
		}
		DBTable  classAnnotation = objeto.getClass().getAnnotation(DBTable.class);
		
		ArrayList<String> columns = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		
		Field []  fields = objeto.getClass().getDeclaredFields();

		for(int i=0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			columns.add(field.getAnnotation(DBField.class).colummn());
			values.add(field.get(objeto).toString());
		}
		
		try {
			String SQL = "DELETE FROM " + classAnnotation.table() + " WHERE "+ columns.get(0)+" = " + values.get(0);
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	/* método buscar
		public Class<T> prcurar(int codigo) throws Exception {
			final Class<T> typeParameterClass;
			 
			
			DBTable  classAnnotation = typeParameterClass.getClass().getAnnotation(DBTable.class);
			
			ArrayList<String> columns = new ArrayList<String>();
			ArrayList<String> values = new ArrayList<String>();
			
			Field []  fields = typeParameterClass.getClass().getDeclaredFields();

			for(int i=0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);
				columns.add(field.getAnnotation(DBField.class).colummn());
				values.add(field.get(typeParameterClass).toString());
			}
			System.out.println(classAnnotation.table());
			try {
				String SQL = "SELECT  * FROM " +  classAnnotation.table() + " WHERE "+ columns.get(0)+" = " + values.get(0);
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, codigo);			
				rs = ps.executeQuery();
				if (rs.next()) {
					int codcategoria = rs.getInt(1);
					String nome = rs.getString(2);
					String linha = rs.getString(3);
					String faixa = rs.getString(4);
					
					
		
				}
				 Class<T> teste = null;
				return (Class<T>) teste;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}*/

}
