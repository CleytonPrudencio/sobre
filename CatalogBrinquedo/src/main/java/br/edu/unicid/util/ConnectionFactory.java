package br.edu.unicid.util;
import java.sql.*;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		
		try {
			//Tentativa de conectar ao banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			
			//retorna com sucesso
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbcatalogbrinquedo","root","123456");
					
		}catch(Exception erro){
			
			throw new Exception(erro.getMessage());
		}
	}
	
	private static void close(Connection conn, Statement stmt, ResultSet rs ) throws Exception {
		try {
			
			if(rs != null) 
				rs.close();
			
			if(stmt != null) 
				stmt.close();
			
			if(conn != null) 
				conn.close();
			
		
		}catch(Exception erro){
			throw new Exception(erro.getMessage());
		}
	}
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs ) throws Exception {
		close(conn,stmt, rs);
	}
	
	public static void closeConnection(Connection conn, Statement stmt ) throws Exception {
		close(conn,stmt, null);
	}
}

