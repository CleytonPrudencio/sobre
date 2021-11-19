package br.edu.unicid.web;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;


import br.edu.unicid.dao.BrinquedoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletImagem")
public class ServletImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static FileInputStream fileInputStream;
    public ServletImagem() {
        // TODO Auto-generated constructor stub
    }
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	

        BrinquedoDAO dao = new BrinquedoDAO();
        response.setContentType("image/png");
    
		File f = new File("E:/WellImg/" + request.getParameter("nome"));
		BufferedImage bi = ImageIO.read(f);
		OutputStream out = response.getOutputStream(); 
		ImageIO.write(bi, "png", out);
		out.close();
        
        
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
