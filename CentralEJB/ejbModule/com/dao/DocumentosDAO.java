package com.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Documentos;

@Stateless
public class DocumentosDAO extends GenericDAO<Documentos>{

	
	public DocumentosDAO(){
		super(Documentos.class);
	}
	
	public List<Documentos>  buscarDocumentos (Map<String, Object> parametros){
		List<Documentos> docs = null;
		docs = super.findAllResults(Documentos.DOCUMENTO_ENVIADO, parametros);
		return docs;
	}
	
	public void  excluirDocumentos (Long id){
		delete(id, Documentos.class);
	}
	
	
}
