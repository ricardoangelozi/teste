package com.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.StatusDAO;
import com.facade.StatusFacede;
import com.model.Status;

@Stateless
public class StatusFacedeImpl implements StatusFacede {

	@EJB
	private StatusDAO dao;

	@Override
	public List<Status> buscarStatus(Long tipoStatus) {
		List<Status> lista = null;
		try {
			lista = dao.buscarStatus(tipoStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
