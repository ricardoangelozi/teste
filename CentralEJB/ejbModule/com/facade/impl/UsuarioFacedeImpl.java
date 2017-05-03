package com.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.UsuarioDAO;
import com.facade.UsuarioFacede;
import com.model.User;

@Stateless
public class UsuarioFacedeImpl implements UsuarioFacede {

	@EJB
	UsuarioDAO daoUsuario;
	
		public List<User> listar() {
			List<User> lista = null;
			try {
				lista = daoUsuario.listar();
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				
			}
			return lista;
		}
		
		public void excluir(User objeto) {
			try {
				daoUsuario.excluir(objeto);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
			
		}
		
		public void liberarAcesso(User user){
			try{
				
				daoUsuario.update(user);
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				
			}
		}
		
		public void AlterarSenha(User user){
			try{
				daoUsuario.update(user);
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				
			}
		}
	}
