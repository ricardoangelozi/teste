package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.TpUsuario;

@Local
public interface TpUsuarioFacede{

	public abstract List<TpUsuario> listar(); 
	
	public abstract TpUsuario buscarUsuario(Long id);
	
}
