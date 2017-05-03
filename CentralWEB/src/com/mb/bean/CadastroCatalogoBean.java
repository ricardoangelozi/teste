package com.mb.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.Utils;
import com.facade.CadastroCentralFacede;
import com.mb.util.Constantes;
import com.model.Cadastro_Central;
import com.model.Status;

@ManagedBean(name = "cadastroCatalogoBean")
@ViewScoped
public class CadastroCatalogoBean implements Serializable {

	private static final long serialVersionUID = 4993049019194073795L;
	
	
	private Cadastro_Central cadastro = new Cadastro_Central();
	private String dataNascimento = "";
	
	@EJB
	private CadastroCentralFacede daoCadastro;
	
	@PostConstruct
	public void init(){
		
    }

	public String enviarDados(Cadastro_Central cadas) throws Exception {
		
		cadas.setFoneCel(cadas.getFoneCel().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
		cadas.setFoneCom(cadas.getFoneCom().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
		cadas.setFoneRes(cadas.getFoneRes().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
		cadas.setCpf(cadas.getCpf().replace(".","").replace("-",""));
		
		
		Cadastro_Central busCadastro = daoCadastro.buscarCpf(cadas.getCpf());
		
		if(busCadastro == null) {
				Status status = new Status();
					status.setId(1L);
					cadas.setStatusItem(status);
					cadas.setCatalogoPedido(new Date());
				
				Status statusAndamento = new Status();
				statusAndamento.setId(3L);
				cadas.setAndamento(statusAndamento);
					
					
			
			cadas.setTipo("catalogo");
			cadas.setNascimento(Utils.converteDataString(dataNascimento));
			daoCadastro.cadastrarCatalogo(cadas);
			cadastro = new Cadastro_Central();
			dataNascimento = "";
			
			FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("MSG", Constantes.MSG_CATALOGO_SUCESSO);
		} else {
			FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("MSG", Constantes.MSG_CATALOGO_ERRO);
		}
		
		return "/mensagens.faces?faces-redirect=true";
	}
	
	public Cadastro_Central getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro_Central cadastro) {
		this.cadastro = cadastro;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
