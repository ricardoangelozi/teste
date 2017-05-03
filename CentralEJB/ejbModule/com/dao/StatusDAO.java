package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Status;

@Stateless
public class StatusDAO extends GenericDAO<Status> {

	public StatusDAO() {
		super(Status.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Status>  buscarStatus(Long tipoStatus){
		
		List<Status> status = null;
		
		try {
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("tp", tipoStatus);
			status = super.findAllResults(Status.BUSCA_STATUS, parametros);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		return status;
	}

	

}
