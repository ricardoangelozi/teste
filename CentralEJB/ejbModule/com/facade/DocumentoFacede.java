package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Documentos;

@Local
public interface DocumentoFacede {

	abstract void gravar(Documentos entity) ;
	
	abstract List<Documentos>  buscarDocumentos (Long id);
	
	abstract void ataulizar(Documentos entity);
	
	abstract void deletar(Long id);
}
