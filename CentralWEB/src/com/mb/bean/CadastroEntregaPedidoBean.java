package com.mb.bean;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.facade.EstadoDataFacede;
import com.model.EstadoData;

@ManagedBean(name = "cadastroEntregaPedidoBean")
@ViewScoped
public class CadastroEntregaPedidoBean implements Serializable {

	private static final long serialVersionUID = 4993049019194073795L;
	
	@EJB
	private EstadoDataFacede daoEstado;
	
	private List<EstadoData> listaEstadoData = new ArrayList<EstadoData>();
	
	private EstadoData selEstadoData = new EstadoData();
	
	private EstadoData estadoData = new EstadoData();
	
	@PostConstruct
	public void init(){
		
		listaEstadoData = daoEstado.buscarDataFechamento();
		
		
    }
	
	
	public void cadastrar(EstadoData data){
		try {
			
			if(validarCampos(data)){
				daoEstado.cadastrarDatasEntrega(data);
				
				
				FileWriter arq = new FileWriter(System.getProperty("user.home") + "/datas/datas.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				for (EstadoData estado : daoEstado.buscarDataFechamento()) {
						gravarArq.printf(estado.getDsCidade()+":"+estado.getEntradaPedido()+":"+estado.getEntregaCaixa()+":"+estado.getBoletoPagamento() + "%n");
				}
				arq.close();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "","Alteração Efetuada com sucesso !!!"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "","Todos os campos são obrigatorios !!!"));
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean validarCampos(EstadoData data){
		
		boolean validacao = true;
		
		if("".equals(data.getDsCidade())){
			validacao = false;	
		}
		
		if("".equals(data.getBoletoPagamento())){
			validacao = false;	
		}
		
		if("".equals(data.getEntradaPedido())){
			validacao = false;	
		}
		
		if("".equals(data.getEntregaCaixa())){
			validacao = false;	
		}
		
		
		
		return validacao;
	}
	
	public EstadoData getEstadoData() {
		return estadoData;
	}


	public void setEstadoData(EstadoData estadoData) {
		this.estadoData = estadoData;
	}


	public List<EstadoData> getListaEstadoData() {
		return listaEstadoData;
	}


	public void setListaEstadoData(List<EstadoData> listaEstadoData) {
		this.listaEstadoData = listaEstadoData;
	}


	public EstadoData getSelEstadoData() {
		return selEstadoData;
	}


	public void setSelEstadoData(EstadoData selEstadoData) {
		this.selEstadoData = selEstadoData;
	}

}
