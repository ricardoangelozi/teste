package com.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.EstadoDataDAO;
import com.facade.EstadoDataFacede;
import com.model.EstadoData;

@Stateless
public class EstadoDataFacedeImpl implements EstadoDataFacede {

	@EJB
	private EstadoDataDAO daoEstado;
	
	
	public List<EstadoData>  buscarDataFechamento(){
		
		List<EstadoData> listaDatas = new ArrayList<EstadoData>();
		try {
			listaDatas = daoEstado.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return listaDatas;
	}
	
	public void cadastrarDatasEntrega(EstadoData entity){
		try {
			daoEstado.update(entity);
		} catch (Exception e) {
			
		} finally {
			
		}
		
		
	}

	

}
