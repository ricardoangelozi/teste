package com.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.DocumentosDAO;
import com.facade.DocumentoFacede;
import com.model.Documentos;

@Stateless
public class DocumentoFacadeImpl implements DocumentoFacede{

	@EJB
	private DocumentosDAO daoDocumento;
	
	@Override
	public void gravar(Documentos entity) {
		try {
			daoDocumento.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	@Override
	public List<Documentos>  buscarDocumentos (Long id){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("id", id);
		List<Documentos> docs = null;
		try {
			docs = daoDocumento.buscarDocumentos(parametros);
		} catch (Exception e) {
		  e.printStackTrace(); 
		} finally{
			
		}
		return docs;
	}
	
	@Override
	public void ataulizar(Documentos entity){
		try {
			daoDocumento.update(entity);
		} catch (Exception e) {
			
		} finally {
			
		}
	}


	@Override
	public void deletar(Long id) {
		daoDocumento.excluirDocumentos(id);
		
	}
}
