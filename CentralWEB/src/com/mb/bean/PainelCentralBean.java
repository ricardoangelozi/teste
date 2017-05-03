package com.mb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.CadastroCentralFacede;
import com.model.Cadastro_Central;
import com.model.Status;

@ManagedBean(name = "PainelCentralBean")
@ViewScoped
public class PainelCentralBean implements Serializable {

	private static final long serialVersionUID = 4993049019194073795L;
	
	@EJB
	private CadastroCentralFacede daoCadastro;
	
	private List<Cadastro_Central> listaCadastro = new ArrayList<Cadastro_Central>();
	
	private Integer qtdSiteCatalogo = 0;
	
	private Integer qtdSitePedido = 0;
	
	private Integer qtdCatalogoEnviados = 0;
	
	
	
	
	public Integer getQtdCatalogoEnviados() {
		return qtdCatalogoEnviados;
	}



	public void setQtdCatalogoEnviados(Integer qtdCatalogoEnviados) {
		this.qtdCatalogoEnviados = qtdCatalogoEnviados;
	}



	@PostConstruct
	public void init(){
		
		Status  status = new Status();
		status.setId(1L);
		this.setQtdSiteCatalogo(daoCadastro.listarStatus(status).size());
		this.setQtdCatalogoEnviados(daoCadastro.listarStatusNotNull(status).size());
		status.setId(2L);
		this.setQtdSitePedido(daoCadastro.listarStatus(status).size());
		
		
		
	}

	public List<Cadastro_Central> getListaCadastro() {
		return listaCadastro;
	}


	public void setListaCadastro(List<Cadastro_Central> listaCadastro) {
		this.listaCadastro = listaCadastro;
	}


	public Integer getQtdSiteCatalogo() {
		return qtdSiteCatalogo;
	}


	public void setQtdSiteCatalogo(Integer qtdSiteCatalogo) {
		this.qtdSiteCatalogo = qtdSiteCatalogo;
	}


	public Integer getQtdSitePedido() {
		return qtdSitePedido;
	}


	public void setQtdSitePedido(Integer qtdSitePedido) {
		this.qtdSitePedido = qtdSitePedido;
	}

	
}
