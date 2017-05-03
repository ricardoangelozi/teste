package com.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.TpUsuarioDAO;
import com.facade.TpUsuarioFacede;
import com.model.TpUsuario;

@Stateless
public class TpUsuarioFacedeImpl implements TpUsuarioFacede {

	@EJB
	TpUsuarioDAO daoTpUsuario;
	
	public List<TpUsuario> listar() {
		List<TpUsuario> lista = null;
		try {
			
			lista = daoTpUsuario.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}
		
		return lista;
	}
	
	public TpUsuario buscarUsuario(Long id){
		TpUsuario tp = null;
		try {
			
			tp = daoTpUsuario.find(id);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return  tp;
	}


}
