package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.TbProcad;

@Local
public interface PedidoItemCentralFacede{
	
	public abstract List<TbProcad>  buscarItem(Integer id);

	

}
