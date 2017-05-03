package com.mb.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.facade.CadastroCentralFacede;
import com.mb.util.Constantes;
import com.model.Cadastro_Central;

@ManagedBean(name = "uploderArquivosBean")
@SessionScoped
public class UploderArquivosBean implements Serializable {

	private static final long serialVersionUID = 4993049019194073795L;
	
	@EJB
	private CadastroCentralFacede daoFacede;
	
	private String numeroCpf = ""; 
	
	@PostConstruct
	public void init(){
		
    }

	
	
	
	public String buscaCpf(){
		String pagina = "";
		numeroCpf = numeroCpf.replace(".","").replace("-","");
		if(!"".equals(numeroCpf)){
			Cadastro_Central cadas = daoFacede.buscarCpfStatus(numeroCpf, 2L);
			if(cadas != null){
				if(cadas.isDocumentoEnvio()){
					FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("MSG", Constantes.MSG_UPLOADER_CONCLUIDO);
					pagina = "mensagens.faces";
					return pagina;
				} else {
					SessionContext.getInstance().setAttribute("cpf", numeroCpf);
					FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("MSG", Constantes.MSG_SUCESSO_UPLOADER);
					pagina =  "/uploader.jsp";
				}
			} else {
				FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("MSG", Constantes.MSG_NAO_ENCONTRADO_UPLOADER);
				pagina = "mensagens.faces";
			}
		} 
		return  pagina;
	}

	public String getNumeroCpf() {
		return numeroCpf;
	}




	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}
	
	
	
}
