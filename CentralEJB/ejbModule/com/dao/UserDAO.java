package com.dao;

import java.util.Map;

import javax.ejb.Stateless;

import com.model.TpUsuario;
import com.model.User;
import com.model.Usuarios;

@Stateless
public class UserDAO extends GenericDAO<User> {
	
	public UserDAO() {
		super(User.class);
	}

	public User findUsuarioSenha(Map<String, Object> parametros) {
			User user = null;
			user = super.findOneResult(User.FIND_USUARIO_SENHA, parametros);
		return user;
	}

	public User findEmailExiste(Map<String, Object> parametros) {
		User user = null;
		user = super.findOneResult(User.FIND_EMAIL_EXISTE, parametros);
		return user;
	}

	public TpUsuario findTpUsuario(Map<String, Object> parametros) {
		TpUsuario tpUser = null;
		tpUser = super.findOneResult(TpUsuario.class,TpUsuario.FIND_TP_USUARIO, parametros);
		return tpUser;
	}

	public Usuarios findUsuario(Map<String, Object> parametros) {
		Usuarios usuario = null;
		usuario = super.findOneResult(Usuarios.class,
		Usuarios.FIND_USUARIO, parametros);
		return usuario;
	}

	public User consultarUser(Long id) {
		User user = new User();
		user = find(id);
		return user;
	}
	
	public void atualizar(User user) {
		super.update(user);
		
	}
}
