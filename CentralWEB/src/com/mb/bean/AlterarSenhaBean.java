package com.mb.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dao.UsuarioDAO;
import com.mb.util.Utils;
import com.model.User;

@ManagedBean(name = "alterarSenha")
@ViewScoped
public class AlterarSenhaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5463521151148029094L;
	
	
	private User   usuario;
	private UsuarioDAO daoUsuario = new UsuarioDAO();
	
	private String senhaAtual;
	private String novaSenha;
	private String novaSenhaConfirma;
	
	@PostConstruct
	public void init(){
		this.usuario = (User) SessionContext.getInstance().getUsuarioLogado();
	}
	
	public void alterarSenha(){
		String senhaAtual = Utils.convertStringToMd5(getSenhaAtual());
		
		if(usuario.getDsSenha().equals(senhaAtual)){
			
			if(getNovaSenha().equals(getNovaSenhaConfirma())){
				
				usuario.setDsSenha(Utils.convertStringToMd5(getNovaSenha()));
				daoUsuario.AlterarSenha(usuario);
				Utils.mensagens("Senha Alterada Com sucesso !!!");
			
			} else {
				Utils.mensagens("Campos Nova Senha n�o conferem");
			}
		} else {
			Utils.mensagens("Senha Atual Errada");
		}
	}




	public User getUsuario() {
		return usuario;
	}




	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}




	public String getSenhaAtual() {
		return senhaAtual;
	}




	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}




	public String getNovaSenha() {
		return novaSenha;
	}




	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}




	public String getNovaSenhaConfirma() {
		return novaSenhaConfirma;
	}




	public void setNovaSenhaConfirma(String novaSenhaConfirma) {
		this.novaSenhaConfirma = novaSenhaConfirma;
	}


}