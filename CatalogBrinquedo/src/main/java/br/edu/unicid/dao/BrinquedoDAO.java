package br.edu.unicid.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Brinquedo;
import br.edu.unicid.bean.Categoria;
import br.edu.unicid.util.ConnectionFactory;

public class BrinquedoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Brinquedo brinquedo;

	public BrinquedoDAO() throws Exception {
		// chama a Classe ConnectionFacotry
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception(erro.getMessage());
		}
	}

	public void salvar(Brinquedo brinquedo) throws Exception {
		if (brinquedo == null) {
			throw new Exception("Preencha as informações da categoria");
		}
		try {
			String SQL = "INSERT INTO brinquedo(cod_brinquedo, nomeBrinquedo, precoBrinquedo,cod_categoria,descricaoBrinquedo,imagemBrinquedo ) values (?,?,?,?,?,?)";
			ps = this.conn.prepareStatement(SQL);
			ps.setInt(1, brinquedo.getCod_brinquedo());
			ps.setString(2, brinquedo.getNomeBrinquedo());
			ps.setDouble(3, brinquedo.getPrecoBrinquedo());
			ps.setInt(4, brinquedo.getCategoria());
			ps.setString(5, brinquedo.getDescricaoBrinquedo());
			ps.setString(6, brinquedo.getImagemBrinquedo());
			ps.executeUpdate();

		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// método atualizar
	public void atualizar(Brinquedo brinquedo) throws Exception {
		if (brinquedo == null) {
			throw new Exception("Preencha as informações do categoria");
		}
		try {
			String SQL = "UPDATE brinquedo set nomeBrinquedo=?, precoBrinquedo=?, cod_categoria=?, descricaoBrinquedo=?  WHERE cod_brinquedo=?";
			conn = this.conn;
			ps = this.conn.prepareStatement(SQL);
			ps.setString(1, brinquedo.getNomeBrinquedo());
			ps.setDouble(2, brinquedo.getPrecoBrinquedo());
			ps.setInt(3, brinquedo.getCategoria());
			ps.setString(4, brinquedo.getDescricaoBrinquedo());
			ps.setInt(5, brinquedo.getCod_brinquedo());
			ps.executeUpdate();

			System.out.println(brinquedo.getCategoria());
		} catch (SQLException sql) {

			throw new Exception("Erro ao inserir os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// método excluir
	public void excluir(Brinquedo brinquedo) throws Exception {
		if (brinquedo == null) {
			throw new Exception("Preencha as informações do categoria");
		}
		try {
			String SQL = "DELETE FROM brinquedo WHERE cod_brinquedo=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, brinquedo.getCod_brinquedo());
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
			String SQL = "SELECT br.*, ctg.nomeCategoria as nomeCategoria FROM brinquedo br inner join categorias ctg on br.cod_categoria = ctg.cod_categoria ";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();

			List<Brinquedo> list = new ArrayList<Brinquedo>();

			while (rs.next()) {
				int codbrinquedo = rs.getInt(1);
				String nomeBrinquedo = rs.getString(2);
				Double precoBrinquedo = rs.getDouble(3);
				int categoria = rs.getInt(4);
				String descricao = rs.getString(5);
				String imagem = rs.getString(6);
				String nomeCategoria = rs.getString(7);

				list.add(new Brinquedo(codbrinquedo, nomeBrinquedo, precoBrinquedo, categoria, descricao, imagem,nomeCategoria));
			}

			return list;

		} catch (SQLException sql) {

			throw new Exception("Erro ao mostrar os dados. " + sql);

		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	public Brinquedo procurarBrinquedo(int cod_brinquedo) throws Exception {

		try {
			String SQL = "SELECT  * FROM brinquedo WHERE cod_brinquedo=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cod_brinquedo);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codBrinquedo = rs.getInt(1);
				String nomeBrinquedo = rs.getString(2);
				Double precoBrinquedo = rs.getDouble(3);
				int categoria = rs.getInt(4);
				String descricao = rs.getString(5);
				String imagem = rs.getString(6);

				brinquedo = new Brinquedo(codBrinquedo, nomeBrinquedo, precoBrinquedo, categoria, descricao, imagem);
			}
			return brinquedo;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}


	// método listar
		public List CategoriaEsp(String idCategoria) throws Exception {
			try {
				String SQL = "SELECT br.*, ctg.nomeCategoria as nomeCategoria FROM brinquedo br inner join categorias ctg on br.cod_categoria = ctg.cod_categoria where br.cod_categoria = ?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setString(1, idCategoria);
				rs = ps.executeQuery();

				List<Brinquedo> list = new ArrayList<Brinquedo>();

				while (rs.next()) {
					int codbrinquedo = rs.getInt(1);
					String nomeBrinquedo = rs.getString(2);
					Double precoBrinquedo = rs.getDouble(3);
					int categoria = rs.getInt(4);
					String descricao = rs.getString(5);
					String imagem = rs.getString(6);
					String nomeCategoria = rs.getString(7);

					list.add(new Brinquedo(codbrinquedo, nomeBrinquedo, precoBrinquedo, categoria, descricao, imagem,nomeCategoria));
				}

				return list;

			} catch (SQLException sql) {

				throw new Exception("Erro ao mostrar os dados. " + sql);

			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		

}
