package com.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.model.Catalogo;

@Stateless
public class CatalogoDAO extends GenericDAO<Catalogo> {

	public CatalogoDAO() {
		super(Catalogo.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Catalogo> buscarCatalogo(){
		List<Catalogo> lista = null;
		try {
			lista = findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
}
