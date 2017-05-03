package com.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.CatalogoDAO;
import com.facade.CatalogoFacede;
import com.model.Catalogo;

@Stateless
public class CatalogoFacedeImpl implements CatalogoFacede {

	@EJB
	private CatalogoDAO dao;

	@Override
	public List<Catalogo> buscarCatalogo() {
		List<Catalogo> lista = null;
		try {
			lista = dao.buscarCatalogo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void inserir(Catalogo entity) {
		try {
			entity.setCatData(new Date());
			dao.save(entity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
