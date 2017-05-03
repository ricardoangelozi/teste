package com.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import com.dao.RevendedoraCpfDAO;
import com.facade.RevendedoraCpfFacede;
import com.model.RevendedoraCpf;

@Stateless
public class RevendedoraCpfFacadeImpl implements RevendedoraCpfFacede {

	@EJB
	private RevendedoraCpfDAO daoRevendedora;


	public List<RevendedoraCpf> buscarListaCpf (String cpf){
		
		
		List<RevendedoraCpf> lista = null;
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("cpf", cpf);
		try {
			lista = daoRevendedora.buscarCpf(parametros);
		} catch (NoResultException e) {
		
		} finally{
			
		}
		return lista;
	}
	
	@Override
	public Boolean buscarCpf (String cpf){
		
		Boolean retorno = false;
		try {
			List<RevendedoraCpf> revende = buscarListaCpf(cpf);
			
			if( revende.size() > 0){
				retorno = Boolean.TRUE;	
			} else {
				retorno = Boolean.FALSE;
			}
			
		} catch (NoResultException e) {
			retorno = Boolean.FALSE;
		} finally{
			
		}
		return retorno;
	}
	
	
	
}
