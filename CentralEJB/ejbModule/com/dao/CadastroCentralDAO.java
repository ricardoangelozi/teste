package com.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Cadastro_Central;

@Stateless
public class CadastroCentralDAO extends GenericDAO<Cadastro_Central>{

	public CadastroCentralDAO(){
		super(Cadastro_Central.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cadastro_Central>  listarCadastroStatus(Map<String, Object> parametros){
		List <Cadastro_Central> listaCadastro = null;
		listaCadastro = super.findAllResults(Cadastro_Central.fIND_DATA, parametros);
		return listaCadastro;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cadastro_Central>  listarStatus(Map<String, Object> parametros){
		List <Cadastro_Central> listaCadastro = null;
		listaCadastro = super.findAllResults(Cadastro_Central.fIND_STATUS, parametros);
		return listaCadastro;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cadastro_Central>  listarStatusNotNull(Map<String, Object> parametros){
		List <Cadastro_Central> listaCadastro = null;
		listaCadastro = super.findAllResults(Cadastro_Central.fIND_STATUS_NOT_NULL, parametros);
		return listaCadastro;
	}
	
	public Cadastro_Central  buscarCpfStatus (Map<String, Object> parametros){
		Cadastro_Central cadastro = super.findOneResult(Cadastro_Central.fIND_CPF, parametros);
		return cadastro;
	}
	
	public Cadastro_Central  buscarCpf (Map<String, Object> parametros){
		
		Cadastro_Central cadastro = null;
		cadastro = super.findOneResult(Cadastro_Central.fIND_CPF2, parametros);
		return cadastro;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Cadastro_Central>  buscarCpfs (Map<String, Object> parametros){
		List<Cadastro_Central> cadastro = null;
		cadastro = super.findAllResults(Cadastro_Central.fIND_CPF2, parametros);
		return cadastro;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cadastro_Central>  buscarNome (Map<String, Object> parametros){
		List<Cadastro_Central> cadastro = null;
		cadastro = super.findAllResults(Cadastro_Central.fIND_NOME, parametros);
		return cadastro;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cadastro_Central>  buscarEmail (Map<String, Object> parametros){
		List<Cadastro_Central> cadastro = null;
		cadastro = super.findAllResults(Cadastro_Central.fIND_EMAIL, parametros);
		return cadastro;
	}
	
	
}
