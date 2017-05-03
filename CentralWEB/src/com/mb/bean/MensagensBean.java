package com.mb.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


 

@ManagedBean(name="mensagensBean")
public class MensagensBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer msg = 0;

	@PostConstruct
	public void carregarMsg(){
		msg = (Integer)	FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("MSG");
	}
	
	public Integer getMsg() {
		return msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}	
	
	
}
