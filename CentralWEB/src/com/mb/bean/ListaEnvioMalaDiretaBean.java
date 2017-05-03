package com.mb.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.Utils;
import com.facade.CadastroCentralFacede;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Cadastro_Central;
import com.model.Status;

@ManagedBean(name = "listaEnvioMalaDiretaBean")
@ViewScoped
public class ListaEnvioMalaDiretaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private static Font negritoPequena = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
	
	private static Font fontFormulario = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
	
	private StreamedContent file;

	private List<Cadastro_Central> listaCadastro = new ArrayList<Cadastro_Central>();
	
	
	
	@EJB
	private CadastroCentralFacede daoCadastro;
	
	 
	@PostConstruct
	public void init(){
		Status  status = new Status();
		status.setId(1L);
		listaCadastro = daoCadastro.listarStatus(status);
	}

	
	public void impressao() {
		String appPath = Utils.CAMINHO_ARQ + "/impressao/maladireta/mala.pdf";
		
		try {
			
 
			Document documento = new Document();
	
			PdfWriter.getInstance(documento, new FileOutputStream(appPath));

			documento.open();
			
			for (Cadastro_Central cad : listaCadastro) {
				
				Image modCarta = Image.getInstance(Utils.CAMINHO_ARQ + "/imagens/modCarta.jpg");
				modCarta.setAlignment(Element.ALIGN_MIDDLE);
				modCarta.scaleToFit(250, 100);
				
				documento.addTitle("Arquivo para impressão");
				documento.addSubject("Pedidos usuário");
				documento.addAuthor("Central Revendedora");
				documento.addCreator("Central Revendedora");
	 
				Paragraph conteudo = new Paragraph();
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				/*NOME*/
				conteudo.add(new Paragraph(cad.getNome().toUpperCase().trim() , negritoPequena));
				/*Endereço */
				conteudo.add(new Paragraph(cad.getRua().toUpperCase().trim() + " Nº " + cad.getNumero(), fontFormulario));
				conteudo.add(new Paragraph(cad.getBairro().toUpperCase().trim(), fontFormulario));
				conteudo.add(new Paragraph(cad.getCidade().toUpperCase().trim() + " / " + cad.getEstado().toUpperCase().trim() , fontFormulario));
				conteudo.add(new Paragraph("CEP: " + cad.getCep().trim(), fontFormulario));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				conteudo.add(new Paragraph(" "));
				
				
				
				
				documento.add(conteudo);
				documento.add(modCarta);	
			}
			
			documento.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		
		InputStream stream;
		try {
			stream = new FileInputStream(appPath);
			file = new DefaultStreamedContent(stream, "application/pdf", "mala_impressao.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	public List<Cadastro_Central> getListaCadastro() {
		return listaCadastro;
	}


	public void setListaCadastro(List<Cadastro_Central> listaCadastro) {
		this.listaCadastro = listaCadastro;
	}


	public CadastroCentralFacede getDaoCadastro() {
		return daoCadastro;
	}


	public void setDaoCadastro(CadastroCentralFacede daoCadastro) {
		this.daoCadastro = daoCadastro;
	}
	
	public StreamedContent getFile() {
		impressao();
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}
	
}
