package com.facade.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.HistoricoAtendimentoDAO;
import com.dao.UserDAO;
import com.facade.HistoricoAtendimentoFacede;
import com.model.HistoricoAtendimento;

@Stateless
public class HistoricoAtendimentoFacedeImpl implements HistoricoAtendimentoFacede {

	@EJB
	UserDAO daoUser;
	
	@EJB
	HistoricoAtendimentoDAO daoHistorico;
	
	public void cadastrar(HistoricoAtendimento entity)  {
		
		try {
			//entity.setUsuario(daoUser.consultarUser(entity.getUsuario().getId()));
			daoHistorico.save(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
		
	}
}
