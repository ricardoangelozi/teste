package com.facade;

import javax.ejb.Local;

import com.model.TpUsuario;
import com.model.User;
import com.model.Usuarios;
@Local
public interface UserFacede {
	
	public abstract User findUsuarioSenha(User objeto) ;
	
	public abstract User findEmailExiste(User objeto);

	public abstract TpUsuario findTpUsuario(Long id) ;

	public abstract Usuarios findUsuario(Long id);

	public abstract User consultarUser(Long id); 
	
	public abstract void atualizar(User user);
}
