package br.edu.unicid.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Enumeration;
import java.util.List;

import br.edu.unicid.bean.Brinquedo;
import br.edu.unicid.bean.Categoria;
import br.edu.unicid.dao.BrinquedoDAO;
import br.edu.unicid.dao.CategoriaDAO;
import br.edu.unicid.dao.GenericoDaoTipo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/ServletBrinquedo")
@MultipartConfig

public class ServletBrinquedo extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		// a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
		String cmd = request.getParameter("cmd");
		
		// cria um objeto dao - CRUD
		BrinquedoDAO dao;
		// cria um objeto do tipo categoria
		Brinquedo brinquedo = new Brinquedo();
		if (cmd != null) {
			try {
				// inicializa os atributos da classe categorias
				
				
				brinquedo.setCod_brinquedo(Integer.parseInt(request.getParameter("txtCod")));
				brinquedo.setNomeBrinquedo(request.getParameter("txtNome"));
				brinquedo.setPrecoBrinquedo(Double.parseDouble(request.getParameter("txtPreco")));
				brinquedo.setCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
				brinquedo.setDescricaoBrinquedo(request.getParameter("txtDesc"));
				
				Part filePart = request.getPart("file");
				Timestamp ts = Timestamp.from(Instant.now());
				String nome = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				String fileName = nome.split("\\.")[0] +  System.currentTimeMillis() / 1000L + "." + nome.split("\\.")[1]  ;
				System.out.println(fileName);
				InputStream imagemBrinquedo = filePart.getInputStream();
				filePart.write("E:\\WellImg\\"+fileName) ;
				brinquedo.setImagemBrinquedo(fileName);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		try {

			// cria a instancia do objeto dao
			dao = new BrinquedoDAO();
			RequestDispatcher rd = null;

			if (cmd.equalsIgnoreCase("listar")) {	
				// listar
				List brinquedoList = dao.todasCategorias();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("brinquedoList", brinquedoList);
				// redireciona para a JSP mostracategoriasCads
				rd = request.getRequestDispatcher("/mostrarBrinquedo.jsp");

				// incluir categoria
			} else if (cmd.equalsIgnoreCase("incluir")) {
				
				dao.salvar(brinquedo);
				rd = request.getRequestDispatcher("ServletBrinquedo?cmd=listar");

				// consulta categoria para exclusão
			} else if (cmd.equalsIgnoreCase("exc")) {

				brinquedo = dao.procurarBrinquedo(brinquedo.getCod_brinquedo());
				HttpSession session = request.getSession(true);
				session.setAttribute("brinquedo", brinquedo);
				rd = request.getRequestDispatcher("/formExcBrinquedo.jsp");
				
				// exclui categoria
			} else if (cmd.equalsIgnoreCase("excluir")) {
				dao.excluir(brinquedo);
				rd = request.getRequestDispatcher("ServletBrinquedo?cmd=listar");
				
				// consulta categoria para alteração
			} else if (cmd.equalsIgnoreCase("atu")) {
				brinquedo = dao.procurarBrinquedo(brinquedo.getCod_brinquedo());
				HttpSession session = request.getSession(true);
				session.setAttribute("brinquedo", brinquedo);
				rd = request.getRequestDispatcher("/formAtuBrinquedo.jsp");
				
				// consulta categoria
            } else if (cmd.equalsIgnoreCase("con")) {
            	brinquedo = dao.procurarBrinquedo(brinquedo.getCod_brinquedo());
                HttpSession session = request.getSession(true);
                session.setAttribute("brinquedo", brinquedo);
                rd = request.getRequestDispatcher("/formConBrinquedo.jsp");
            
             // altera categoria    
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(brinquedo);
				rd = request.getRequestDispatcher("ServletBrinquedo?cmd=listar");
			}

			// executa a ação de direcionar para a página JSP
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
