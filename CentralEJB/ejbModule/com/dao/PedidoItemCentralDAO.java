package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.TbProcad;

@Stateless
public class PedidoItemCentralDAO extends GenericDAO<TbProcad> {

	public PedidoItemCentralDAO() {
		super(TbProcad.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<TbProcad>  buscarItem(Integer id){
		short ano = 2016;
		short procampan = 9;
		List<TbProcad> item = null;
		
		try {
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("id", id);
			parametros.put("ano", ano);
			parametros.put("procampan", procampan);
			
			item = super.findAllResults(TbProcad.fIND_ID, parametros);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		return item;
	}

	

}
