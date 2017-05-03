package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Catalogo;

@Local
public interface CatalogoFacede{
	
	abstract List<Catalogo>  buscarCatalogo ();
	
	abstract void  inserir(Catalogo entity);
	
}
