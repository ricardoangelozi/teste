package com.mb.bean;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.facade.CatalogoFacede;
import com.model.Catalogo;

@ManagedBean(name = "cadastroCatalogoVirtualBean")
@ViewScoped
public class CadastroCatalogoVirtualBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Catalogo catalogo = new Catalogo();
	
	private Catalogo selCatalogo = new Catalogo();

	private List<Catalogo> listaCatalogo;

	@EJB
	private CatalogoFacede daoCatalogo;
	
	
	@PostConstruct
	public void init(){
		
		listaCatalogo = daoCatalogo.buscarCatalogo();
		
		
    }
	
	public void handleFileUpload(FileUploadEvent event) throws IOException {
	    //get uploaded file from the event
		
	    UploadedFile uploadedFile = (UploadedFile) event.getFile();
	    //create an InputStream from the uploaded file
	    InputStream inputStr = null;
	    
	        inputStr = uploadedFile.getInputstream();
	    

//	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//	    String directory = externalContext.getInitParameter("uploadDirectory");
	    
	    String directory =  System.getProperty("user.home") + "/catalogo.centraldarevendedora.com.br/catalogo";
	    String filename = FilenameUtils.getName(uploadedFile.getFileName());
	    File destFile = new File(directory, filename);

	    //use org.apache.commons.io.FileUtils to copy the File
	    
	        FileUtils.copyInputStreamToFile(inputStr, destFile);
	        catalogo.setCatPhoto(destFile.toString());
	    FacesMessage msg = new FacesMessage(event.getFile().getFileName() + " UPLOADER EFETUADO COM SUCESSO.");
	    FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void cadastrar(Catalogo data) {
		try {

			if (validarCampos(data)) {
				daoCatalogo.inserir(data);
				listaCatalogo.add(data);
				FileWriter arq = new FileWriter(System.getProperty("user.home")+ "/catalogo.centraldarevendedora.com.br/catalogo/catalogo.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				
				for (Catalogo catalogo : daoCatalogo.buscarCatalogo()) {
					gravarArq.printf(catalogo.getCatNome() + ";"
							+ catalogo.getCatNomeCatalogo() + ";"
							+ "http://"+catalogo.getCatPhoto() + ";"
							+ catalogo.getCatUrl() + "%n");
				}
				arq.close();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Alteração Efetuada com sucesso !!!"));
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Todos os campos são obrigatorios !!!"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public boolean validarCampos(Catalogo data) {

		boolean validacao = true;

		if ("".equals(data.getCatNome())) {
			validacao = false;
		}

		if ("".equals(data.getCatNomeCatalogo())) {
			validacao = false;
		}

		if ("".equals(data.getCatPhoto())) {
			validacao = false;
		}

		if ("".equals(data.getCatUrl())) {
			validacao = false;
		}

		return validacao;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public List<Catalogo> getListaCatalogo() {
		return listaCatalogo;
	}

	public void setListaCatalogo(List<Catalogo> listaCatalogo) {
		this.listaCatalogo = listaCatalogo;
	}

	public Catalogo getSelCatalogo() {
		return selCatalogo;
	}

	public void setSelCatalogo(Catalogo selCatalogo) {
		this.selCatalogo = selCatalogo;
	}
}
