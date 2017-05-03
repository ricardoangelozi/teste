package com.facade.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import com.dao.CadastroCentralDAO;
import com.facade.CadastroCentralFacede;
import com.model.Cadastro_Central;
import com.model.Status;

@Stateless
public class CadastroCentralFacedeImpl implements CadastroCentralFacede{
	
	@EJB
	private CadastroCentralDAO dao;
	
	@Override
	public void cadastrar(Cadastro_Central entity) {
		entity.setNome(entity.getNome().toUpperCase());
		entity.setEmail(entity.getEmail().toLowerCase());
		
		/*Data de cadastro do usuario */
		entity.setData(new Date());
		entity.setObservacao("");
		try {
			dao.update(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}
		
	}
	
	@Override
	public void cadastrarCatalogo(Cadastro_Central entity){
			
			entity.setNome(entity.getNome().toUpperCase());
			entity.setEmail(entity.getEmail().toLowerCase());
			
			entity.setCatalogoEnvio(null);
			entity.setCatalogoPedido(new Date());
			
			entity.setCatalogoEnvioStatus(false);
			entity.setCatalogoPedidoStatus("N");
			
			/*Data de cadastro do usuario */
			
			entity.setData(new Date());
			entity.setLimiteCredito(0.0);
			
			entity.setObservacao("");
			
			entity.setCodExecutiva("");
			entity.setCodExecutivaX("");
			entity.setNewsletter("");
			try {
				dao.save(entity);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
			
		}
	
	@Override
	public List<Cadastro_Central>  listarCadastroStatus(Date query){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("data", query);
		List <Cadastro_Central> listaCadastro = null;
		try {
			
			listaCadastro = dao.listarCadastroStatus(parametros);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		return listaCadastro;
	}
	
	@Override
	public List<Cadastro_Central>  listarStatus(Status item){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("status", item.getId());
		List <Cadastro_Central> listaCadastro = null;
		try {
			
			listaCadastro = dao.listarStatus(parametros);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		return listaCadastro;
	}
	
	@Override	
	public List<Cadastro_Central>  listarStatusNotNull(Status item){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("status", item.getId());
		List <Cadastro_Central> listaCadastro = null;
		try {
			
			listaCadastro = dao.listarStatusNotNull(parametros);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return listaCadastro;
	}
	
	@Override
	public Cadastro_Central  buscarCpfStatus (String cpf, Long status){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("cpf", cpf);
		parametros.put("status", status);
		Cadastro_Central cadastro = null;
		try {
			cadastro = dao.buscarCpfStatus(parametros);
		} catch (NoResultException e) {

		} finally{
			
		}
		
		return cadastro;
	}
	
	@Override
	public Cadastro_Central  buscarCpf (String cpf){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("cpf", cpf);
		Cadastro_Central cadastro = null;
		try {
			cadastro = dao.buscarCpf(parametros);
		} catch (Exception e) {
		  e.printStackTrace(); 
		} finally{
			
		}
		
		return cadastro;
	}
	
	@Override
	public List<Cadastro_Central>  buscarCpfs (String cpf){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("cpf", cpf);
		List<Cadastro_Central> cadastro = null;
		
		try {
			cadastro = dao.buscarCpfs(parametros);
		} catch (Exception e) {
		  e.printStackTrace(); 
		} finally{
			
		}
		
		return cadastro;
	}

	@Override
	public Cadastro_Central find(Long entityID) {
		return dao.find(entityID);
	}

	@Override
	public void update(Cadastro_Central entity) {
		dao.update(entity);
	}

	@Override
	public List<Cadastro_Central> buscarFiltro(Date dateInicio, Date dateFim, Status status,String tipoCadastro, boolean documento ) {
		List<Cadastro_Central> lista = 	dao.buscaFiltro(dateInicio, dateFim, status, tipoCadastro, documento );
		return lista;
	}

	@Override
	public List<Cadastro_Central> buscarNome(String nome) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome", nome);
		List<Cadastro_Central> cadastro = null;
		
		try {
			cadastro = dao.buscarNome(parametros);
		} catch (Exception e) {
		  e.printStackTrace(); 
		} finally{
			
		}
		
		return cadastro;
	}

	@Override
	public List<Cadastro_Central> buscarEmail(String email) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("email", email);
		List<Cadastro_Central> cadastro = null;
		
		try {
			cadastro = dao.buscarEmail(parametros);
		} catch (Exception e) {
		  e.printStackTrace(); 
		} finally{
			
		}
		
		return cadastro;
	}
	
	
}
