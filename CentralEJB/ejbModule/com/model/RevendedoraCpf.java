package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the cadastro database table.
 * 
 */
@Entity
@Table(name="TB_REVENDEDORA_CPF")
@NamedQueries({
	@NamedQuery(name="RevendedoraCpf.findCpf2", query="SELECT c FROM RevendedoraCpf c where c.cpf = :cpf"),
})

public class RevendedoraCpf implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String fIND_CPF2 = "RevendedoraCpf.findCpf2";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cpf", unique=true, nullable=false)
	private Long id_cpf;

	@Column(name="cpf")
	private String cpf;
	
	@Column(name="STATUS")
	private String status;
	
	

	public Long getId_cpf() {
		return id_cpf;
	}

	public void setId_cpf(Long id_cpf) {
		this.id_cpf = id_cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}