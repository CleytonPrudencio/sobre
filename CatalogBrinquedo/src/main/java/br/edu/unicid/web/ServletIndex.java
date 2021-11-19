package br.edu.unicid.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
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

@WebServlet("/Index")
@MultipartConfig

public class ServletIndex extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		// a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
		String cmd = request.getParameter("cmd");
		// cria um objeto dao - CRUD
		BrinquedoDAO dao;
		CategoriaDAO daoc;
		// cria um objeto do tipo categoria
		Categoria categoria = new Categoria();
		Brinquedo brinquedo = new Brinquedo();
		if (cmd != null) {
			try {
				// inicializa os atributos da classe categorias
				if (cmd.equalsIgnoreCase("incluir")) {
					Part filePart = request.getPart("file");
					String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
					InputStream imagemBrinquedo = filePart.getInputStream();
					brinquedo.setImagemBrinquedo(fileName);
				}

				brinquedo.setCod_brinquedo(Integer.parseInt(request.getParameter("txtCod")));
				brinquedo.setNomeBrinquedo(request.getParameter("txtNome"));
				brinquedo.setPrecoBrinquedo(Double.parseDouble(request.getParameter("txtPreco")));
				brinquedo.setCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
				brinquedo.setDescricaoBrinquedo(request.getParameter("txtDesc"));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		try {

			// cria a instancia do objeto dao
			dao = new BrinquedoDAO();
			daoc = new CategoriaDAO();
			RequestDispatcher rd = null;
			String nomecategoria = request.getParameter("categoria");
			
			 if (nomecategoria == null) {
			// listar Brinquedo
			List brinquedoList = dao.todasCategorias();
			// cria uma sessão para encaminhar a lista para uma JSP
			request.setAttribute("brinquedoList", brinquedoList);
			// redireciona para a JSP mostracategoriasCads
			rd = request.getRequestDispatcher("/index.jsp");
			}else {
				// listar Brinquedo
				List brinquedoList = dao.CategoriaEsp(nomecategoria);
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("brinquedoList", brinquedoList);
				// redireciona para a JSP mostracategoriasCads
				rd = request.getRequestDispatcher("/index.jsp");
			}
			 
			 
			// Listar Categorias
			List categoriasList = daoc.todasCategorias();
			// cria uma sessão para encaminhar a lista para uma JSP
			request.setAttribute("categoriasList", categoriasList);
			// redireciona para a JSP mostracategoriasCads
			rd = request.getRequestDispatcher("/index.jsp");
			
			
			 

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
