package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Status;

public class FiltroPesquisa {
	
	private Date dateInicio;
	
	private Date dateFim;
	
	private Status status;
	
	private List<String> tipoCadastro;
	
	private List<String> documento;
	
	private List<String> statusSelecionado;
	
	private String tipoCadastroSelecionado;
	
	private List<String> documentoSelecionado;
	
	private String nome;
	
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
	
	public List<String> getTipoCadastro() {
		if(tipoCadastro == null){
			tipoCadastro = new ArrayList<String>();
			tipoCadastro.add("catalogo");
			tipoCadastro.add("revendedora");
		}
		return tipoCadastro;
	}

	public void setTipoCadastro(List<String> tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
	
	public List<String> getDocumento() {
		if(documento == null){
			documento = new ArrayList<String>();
			documento.add("NÃO ENVIADO");
			documento.add("EM ANÁLISE");
			documento.add("APROVADO");
        }
		return documento;
	}

	public void setDocumento(List<String> documento) {
		this.documento = documento;
	}
	
	public List<String> getStatusSelecionado() {
		return statusSelecionado;
	}

	public void setStatusSelecionado(List<String> statusSelecionado) {
		this.statusSelecionado = statusSelecionado;
	}

	

	public String getTipoCadastroSelecionado() {
		return tipoCadastroSelecionado;
	}

	public void setTipoCadastroSelecionado(String tipoCadastroSelecionado) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
