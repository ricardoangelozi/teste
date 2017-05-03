package com.mb.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.model.Status;

public class FiltroPesquisa {
	
	private Date dateInicio;
	
	private Date dateFim;
	
	private List<SelectItem> status;
	
	private boolean documento;
	
	public boolean isDocumento() {
		return documento;
	}

	public void setDocumento(boolean documento) {
		this.documento = documento;
	}

	private Status statusSelecionado;
	
	private Long tipoCadastroSelecionado;
	
	private List<String> documentoSelecionado;
	
	private String nome;
	
	private String email;
	
	private Date dataNascimento;
	
	private String nrCpf;
	
	
	
	public Date getDateInicio() {
		return dateInicio;
	}

	public void setDateInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
	}

	public Date getDateFim() {
		return dateFim;
	}

	public void setDateFim(Date dateFim) {
		this.dateFim = dateFim;
	}
	public List<SelectItem> getStatus() {
		if(this.status == null ){
			this.status = new ArrayList<SelectItem>();

			this.status.add(new SelectItem("G", "GERAL"));
			this.status.add(new SelectItem("N" ,"PENDENTE"));
			this.status.add(new SelectItem("L" ,"EM ANALISE"));
			this.status.add(new SelectItem("B", "REPROVADO"));
			this.status.add(new SelectItem("A", "APROVADO"));
			this.status.add(new SelectItem("F", "FINALIZADO"));
			
        }
		
		return this.status;
	}

	public void setStatus(List<SelectItem> status) {
		this.status = status;
	}
	
	public Status getStatusSelecionado() {
		return statusSelecionado;
	}

	public void setStatusSelecionado(Status statusSelecionado) {
		this.statusSelecionado = statusSelecionado;
	}

	

	public Long getTipoCadastroSelecionado() {
		return tipoCadastroSelecionado;
	}

	public void setTipoCadastroSelecionado(Long tipoCadastroSelecionado) {
		this.tipoCadastroSelecionado = tipoCadastroSelecionado;
	}

	
	public List<String> getDocumentoSelecionado() {
		return documentoSelecionado;
	}

	public void setDocumentoSelecionado(List<String> documentoSelecionado) {
		this.documentoSelecionado = documentoSelecionado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
