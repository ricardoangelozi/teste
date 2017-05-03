package com.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.model.Cadastro_Central;
import com.model.Status;

@Local
public interface CadastroCentralFacede{
	
	abstract void cadastrar(Cadastro_Central entity);
	
	abstract void cadastrarCatalogo(Cadastro_Central entity);
	
	abstract  List<Cadastro_Central>  listarCadastroStatus(Date query);
	
	abstract List<Cadastro_Central>  listarStatus(Status item);

	abstract List<Cadastro_Central>  listarStatusNotNull(Status item);
	
	abstract Cadastro_Central  buscarCpfStatus (String cpf, Long status);
	
	abstract Cadastro_Central  buscarCpf (String cpf);
	
	abstract List<Cadastro_Central>  buscarCpfs (String cpf);
	
	abstract List<Cadastro_Central>  buscarFiltro (Date dateInicio, Date dateFim, Status status, String tipoCadastro, boolean documento );
	
	abstract Cadastro_Central  find (Long id);
	
	abstract void  update (Cadastro_Central entity);
	
	abstract List<Cadastro_Central>  buscarNome (String nome);
	
	abstract List<Cadastro_Central>  buscarEmail (String email);
	
}
