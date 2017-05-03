package com.dao;

import javax.ejb.Stateless;

import com.model.HistoricoAtendimento;

@Stateless
public class HistoricoAtendimentoDAO extends GenericDAO<HistoricoAtendimento>{

	public HistoricoAtendimentoDAO(){
		super(HistoricoAtendimento.class);
	}
	
	public void cadastrar(HistoricoAtendimento entity)  {
		
		try {
			
//			UserDAO dao = new UserDAO();
//			entity.setUsuario(dao.consultarUser(entity.getUsuario().getId()));
			save(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
		
	}
}
