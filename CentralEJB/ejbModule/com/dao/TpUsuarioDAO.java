package com.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.model.TpUsuario;

@Stateless
public class TpUsuarioDAO extends GenericDAO<TpUsuario> {

	public TpUsuarioDAO() {
		super(TpUsuario.class);
	}
	
	
	public List<TpUsuario> listar() {
		List<TpUsuario> lista = null;
		try {
			
			lista = super.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}
		
		return lista;
	}
	
	public TpUsuario buscarUsuario(Long id){
		TpUsuario tp = null;
		try {
			
			tp = find(id);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return  tp;
	}


}
