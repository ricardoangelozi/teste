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
 * The persistent class for the indique_ganhe database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQueries({
	@NamedQuery(name="Status.all", query="SELECT s FROM Status s where s.tpCadastro = :tp ")
})


public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public static final String BUSCA_STATUS = "Status.all";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="descricao", nullable=false)
	private String descricao;
	
	
	@Column(name="tp_cadastro",nullable=false)
	private Long tpCadastro;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTpCadastro() {
		return tpCadastro;
	}

	public void setTpCadastro(Long tpCadastro) {
		this.tpCadastro = tpCadastro;
	}

	

}