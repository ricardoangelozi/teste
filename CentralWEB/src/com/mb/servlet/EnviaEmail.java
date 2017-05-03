package com.mb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnviaEmail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String tel = request.getParameter("phone");
		String duvidas = request.getParameter("assuntoID");
		String observa = request.getParameter("message");
		
		Thread thEnviaEmail = new Thread(new DisparaEmails(nome, email, tel, duvidas, observa));
		
		thEnviaEmail.start();
		
		response.sendRedirect("/SITE/index.jsp");
//		PrintWriter out = response.getWriter();
//		out.println(nome);
//		out.println(email);
//		out.println(tel);
//		out.println(duvidas);
//		out.println(observa);
//		out.close();
		
    }

}
