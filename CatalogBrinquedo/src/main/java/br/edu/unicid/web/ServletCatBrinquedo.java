package br.edu.unicid.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.unicid.bean.Categoria;
import br.edu.unicid.dao.CategoriaDAO;
import br.edu.unicid.dao.GenericoDaoTipo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletCatBrinquedo")
public class ServletCatBrinquedo extends HttpServlet {

	 private Date strToDate(String data) throws Exception {
	        if (data == null) {
	            return null;
	        }

	        Date dataF = null;
	        try {
	            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	            long timestamp = dateFormat.parse(data).getTime();
	            dataF = new Date(timestamp);
	        } catch (ParseException pe) {
	            throw pe;
	        }
	        return dataF;
	    }
	 	
	 	
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        // a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
	        String cmd = request.getParameter("cmd");
	        // cria um objeto dao - CRUD
	        CategoriaDAO dao;
	        GenericoDaoTipo daoge;
	        // cria um objeto do tipo categoria
	        Categoria categoria = new Categoria();
	        if (cmd != null) {
	            try {
	                // inicializa os atributos da classe categorias
	            	categoria.setCod_categoria(Integer.parseInt(request.getParameter("txtCod")));  
	            	categoria.setNomeCategoria(request.getParameter("txtNome"));
	            	categoria.setLinhaCategoria(request.getParameter("txtLinha"));
	            	categoria.setFaixaCategoria(request.getParameter("txtFaixa"));
                } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	        try {
	        	// cria a instancia do objeto dao
	            dao = new CategoriaDAO();
	            RequestDispatcher rd = null;
	            
	            // lista todos os categorias
	            if (cmd.equalsIgnoreCase("listar")) {
	                List categoriasList = dao.todasCategorias();
	                // cria uma sessão para encaminhar a lista para uma JSP
	                request.setAttribute("categoriasList", categoriasList);
	                // redireciona para a JSP mostracategoriasCads
	                rd = request.getRequestDispatcher("/mostrarCategorias.jsp");
	            }
	            
	            // incluir categoria
	            else if (cmd.equalsIgnoreCase("incluir")) {
	                dao.salvar(categoria);
	                rd = request.getRequestDispatcher("ServletCatBrinquedo?cmd=listar");
	                
	                
	            // consulta categoria para exclusão    
	            } else if (cmd.equalsIgnoreCase("exc")) {
	            	categoria = dao.procurarcategoria(categoria.getCod_categoria());
	                HttpSession session = request.getSession(true);
	                session.setAttribute("categoria", categoria);
	                rd = request.getRequestDispatcher("/formExcCategoria.jsp");
	             
	            // exclui categoria
	            } else if (cmd.equalsIgnoreCase("excluir")) {
	                dao.excluir(categoria);
	                rd = request.getRequestDispatcher("ServletCatBrinquedo?cmd=listar");
	            
	            // consulta categoria para alteração
	            }  else if (cmd.equalsIgnoreCase("atu")) {
	            	categoria = dao.procurarcategoria(categoria.getCod_categoria());
	                HttpSession session = request.getSession(true);
	                session.setAttribute("categoria", categoria);
	                rd = request.getRequestDispatcher("/formAtuCategoria.jsp");
	             
	            // consulta categoria
	            } else if (cmd.equalsIgnoreCase("con")) {
	            	categoria = dao.procurarcategoria(categoria.getCod_categoria());
	                HttpSession session = request.getSession(true);
	                session.setAttribute("categoria", categoria);
	                rd = request.getRequestDispatcher("/formConCategoria.jsp");
	            
	             // altera categoria    
	            } else if (cmd.equalsIgnoreCase("atualizar")) {
	                dao.atualizar(categoria);
	                rd = request.getRequestDispatcher("ServletCatBrinquedo?cmd=listar");
	            
	            // direciona para a página principal
	            } else if (cmd.equalsIgnoreCase("principal")) {
	                rd = request.getRequestDispatcher("/index.jsp");
	            }else if (cmd.equalsIgnoreCase("listarDrop")) {
	                List categoriasList = dao.todasCategorias();
	                // cria uma sessão para encaminhar a lista para uma JSP
	                request.setAttribute("categoriasList", categoriasList);
	                // redireciona para a JSP mostracategoriasCads
	                rd = request.getRequestDispatcher("/IncluirBrinquedo.jsp");
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
	        processRequest(request, response);
	    } 

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        processRequest(request, response);
	    }
}
