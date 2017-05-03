package com.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.PedidoItemCentralDAO;
import com.facade.PedidoItemCentralFacede;
import com.model.TbProcad;

@Stateless
public class PedidoItemCentralFacadeImpl implements PedidoItemCentralFacede {

	@EJB
	PedidoItemCentralDAO daoPedido;
	
	public List<TbProcad>  buscarItem(Integer id){
		short ano = 2016;
		short procampan = 11;
		List<TbProcad> item = null;
		
		try {
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("id", id);
			parametros.put("ano", ano);
			parametros.put("procampan", procampan);
			
			item = daoPedido.findAllResults(TbProcad.fIND_ID, parametros);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		return item;
	}

	

}
