package com.facade.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.Utils;
import com.dao.UserDAO;
import com.facade.UserFacede;
import com.model.TpUsuario;
import com.model.User;
import com.model.Usuarios;

@Stateless
public class UserFacedaImpl implements UserFacede {
	
	@EJB
	private UserDAO daoUser;

	@Override
	public User findUsuarioSenha(User objeto) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("dsLogin", objeto.getDsLogin());
		parametros.put("dsSenha", Utils.convertStringToMd5(objeto.getDsSenha()));
		User user = null;
		try {
			user = daoUser.findUsuarioSenha( parametros);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

		return user;
	}
	
	@Override
	public User findEmailExiste(User objeto) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		User user = null;
		try {
			parametros.put("dsLogin", objeto.getDsLogin());
			
			user = daoUser.findEmailExiste(parametros);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

		return user;
	}

	@Override
	public TpUsuario findTpUsuario(Long id) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("id", id);
		TpUsuario tpUser = null;
		try {
			tpUser = daoUser.findTpUsuario( parametros);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return tpUser;
	}

	@Override
	public Usuarios findUsuario(Long id) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("id", id);
		Usuarios usuario = null;
		try {
			usuario = daoUser.findUsuario(parametros);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

		return usuario;
	}
	
	@Override
	public User consultarUser(Long id) {
		User user = new User();
		try {
			
			user = daoUser.consultarUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

		return user;
	}

	@Override
	public void atualizar(User user) {
		daoUser.atualizar(user);
		
	}
}
