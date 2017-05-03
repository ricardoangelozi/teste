package com.dao;

import javax.ejb.Stateless;

import com.model.EstadoData;

@Stateless
public class EstadoDataDAO extends GenericDAO<EstadoData> {

	public EstadoDataDAO() {
		super(EstadoData.class);
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrarDatasEntrega(EstadoData entity){
		try {
			
			update(entity);
				
		} catch (Exception e) {
			
		} finally {
			
		}
		
		
	}

	

}
