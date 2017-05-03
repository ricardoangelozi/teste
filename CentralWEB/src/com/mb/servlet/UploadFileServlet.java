package com.mb.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Utils;
import com.facade.CadastroCentralFacede;
import com.facade.DocumentoFacede;
import com.model.Documentos;

public class UploadFileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5561936016848637143L;

	@EJB
	private DocumentoFacede dao;
	
	@EJB
	private CadastroCentralFacede daoCadastro;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DiskFileItemFactory dfif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		
		String nomeArquivo = "";
		String appCPF = (String) req.getSession().getAttribute("cpf");
		nomeArquivo = (String) req.getSession().getAttribute("cpf");
		
		if(appCPF.length() == 11){
		
			List items = null;
			
			try {
				items = sfu.parseRequest(req);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			for (Integer i = 0; i < items.size(); i++) {
				
				FileItem descFI = (FileItem) items.get(i);
				if(descFI.getSize() > 0){
					nomeArquivo = appCPF;
					nomeArquivo += "_" + (1 + (Math.random()*10));
					try {
						gravarArquivo(Utils.CAMINHO_ARQ, descFI, nomeArquivo);	
						Documentos doc = new Documentos();
						doc.setDataEnvio(new Date());
						doc.setCadastro(daoCadastro.buscarCpf(appCPF));
						doc.setNmArquivo(nomeArquivo);
						dao.gravar(doc);	
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
				}
				
			}
			resp.sendRedirect("mensagens.faces");
		} else {
			resp.sendRedirect("uploader.jsp");
		}
	}

	
	
	private void gravarArquivo(String appPath, FileItem descFI, String appCpf)
			throws IOException {

		File diretorio = new File(appPath + "/uploaders");

		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		
		String fileName = descFI.getName();
		String arq[] = fileName.split("\\\\");

		for (int y = 0; y < arq.length; y++) {
			fileName = arq[y];
		}
		
		if("application/pdf".equals(descFI.getContentType())){
			appCpf += ".pdf"; 
		} else {
			appCpf += ".jpg";
		}

		File file = new File(diretorio, appCpf);
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in = descFI.getInputStream();

		// Imagens de até 2 megas !!
		byte[] buffer = new byte[1024 * 2];
		int nLidos;
		while ((nLidos = in.read(buffer)) >= 0) {
			out.write(buffer, 0, nLidos);
		}

		if(out != null){
			out.flush();
			out.close();
		}

	}

}