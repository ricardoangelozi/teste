package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.EstadoData;

@Local
public interface EstadoDataFacede {
	public  List<EstadoData>  buscarDataFechamento();
	public  void cadastrarDatasEntrega(EstadoData entity);
}
