package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.User;

@Local
public interface UsuarioFacede {

		public abstract List<User> listar(); 
		
		public abstract void excluir(User objeto) ;
		
		public abstract void liberarAcesso(User user);
		
		public abstract void AlterarSenha(User user);
	}
