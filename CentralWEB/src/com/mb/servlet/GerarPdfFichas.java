package com.mb.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class GerarPdfFichas extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {
		        response.setContentType("application/pdf");
		        try {
		            // step 1
		            Document document = new Document();
		            // step 2
		            PdfWriter.getInstance(document, response.getOutputStream());
		            // step 3
		            document.open();
		            // step 4
		            
		            document.add(new Paragraph(request.getParameter("nome")));
		            document.add(new Paragraph(new Date().toString()));
		            // step 5
		            document.close();
		        } catch (DocumentException de) {
		            throw new IOException(de.getMessage());
		        }
		    }

}
