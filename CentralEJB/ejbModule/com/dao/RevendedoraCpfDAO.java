package com.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.RevendedoraCpf;

@Stateless
public class RevendedoraCpfDAO extends GenericDAO<RevendedoraCpf>{
	
	public RevendedoraCpfDAO(){
		super(RevendedoraCpf.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<RevendedoraCpf>  buscarCpf (Map<String, Object> parametros){
		List<RevendedoraCpf> revende = super.findAllResults(RevendedoraCpf.fIND_CPF2,parametros);
		return revende;
	}
	
	
}
