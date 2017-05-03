package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.User;

@Stateless
public class UsuarioDAO extends GenericDAO<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioDAO() {
		super(User.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listar() {
		List<User> lista = null;
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("flagPrimeiroAcesso", true);
			parametros.put("flagSolicitaAcesso", true);
			lista = findAllResults(User.FIND_LIBERAR_ACESSO, parametros);
		return lista;
		}
		
		public void excluir(User objeto) {
			delete(objeto.getId(),User.class);
		}
		
		public void liberarAcesso(User user){
			update(user);
		}
		
		public void AlterarSenha(User user){
			update(user);
		}
		}
	
