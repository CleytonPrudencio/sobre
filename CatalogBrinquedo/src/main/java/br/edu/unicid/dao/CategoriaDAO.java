package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Categoria;
import br.edu.unicid.util.ConnectionFactory;

public class CategoriaDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Categoria categoria;

	public CategoriaDAO() throws Exception {
		// chama a Classe ConnectionFacotry
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception(erro.getMessage());
		}
	}

	// método salvar
	public void salvar(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception("Preencha as informações da categoria");
		}
		try {
			String SQL = "INSERT INTO categorias(cod_categoria, nomeCategoria, linhaCategoria, faixaCategoria) values (?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, categoria.getCod_categoria());
			ps.setString(2, categoria.getNomeCategoria());
			ps.setString(3, categoria.getLinhaCategoria());
			ps.setString(4, categoria.getFaixaCategoria());
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	 //método atualizar
	public void atualizar(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception("Preencha as informações do categoria");
		}
		try {
			String SQL = "UPDATE categorias set nomeCategoria=?, linhaCategoria=?, faixaCategoria=? WHERE cod_categoria=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, categoria.getNomeCategoria());
			ps.setString(2, categoria.getLinhaCategoria());
			ps.setString(3, categoria.getFaixaCategoria());
			ps.setInt(4, categoria.getCod_categoria());
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// método excluir
	public void excluir(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception("Preencha as informações do categoria");
		}
		try {
			String SQL = "DELETE FROM categorias WHERE cod_categoria=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, categoria.getCod_categoria());
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	 // método listar
	public List todasCategorias() throws Exception {
		try {
			String SQL = "SELECT * FROM categorias";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();

			List<Categoria> list = new ArrayList<Categoria>();

			while (rs.next()) {
				int codcategoria = rs.getInt(1);
				String nome = rs.getString(2);
				String linha = rs.getString(3);
				String faixa = rs.getString(4);
				

				list.add(new Categoria(codcategoria, nome,linha,faixa ));
			}

			return list;

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	
	// método buscar
	public Categoria procurarcategoria(int cod_categoria) throws Exception {

		try {
			String SQL = "SELECT  * FROM categorias WHERE cod_categoria=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cod_categoria);			
			rs = ps.executeQuery();
			if (rs.next()) {
				int codcategoria = rs.getInt(1);
				String nome = rs.getString(2);
				String linha = rs.getString(3);
				String faixa = rs.getString(4);
				
				categoria = new Categoria(codcategoria, nome, linha, faixa);
			}
			return categoria;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public Categoria procurarcategoriastr(int cod_categoria) throws Exception {

		try {
			String SQL = "SELECT  * FROM categorias WHERE cod_categoria=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cod_categoria);			
			rs = ps.executeQuery();
			if (rs.next()) {
				int codcategoria = rs.getInt(1);
				String nome = rs.getString(2);
				String linha = rs.getString(3);
				String faixa = rs.getString(4);
				
				categoria = new Categoria(codcategoria, nome, linha, faixa);
			}
			return categoria;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}
