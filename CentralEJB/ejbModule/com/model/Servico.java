package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the servicos database table.
 * 
 */
@Entity
@Table(name="servicos")
@NamedQuery(name="Servico.findAll", query="SELECT s FROM Servico s")

public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="servicos_id", unique=true, nullable=false)
	private String servicosId;

	@Column(name="servicos_nome", nullable=false, length=120)
	private String servicosNome;

	@Column(name="servicos_url", nullable=false, length=120)
	private String servicosUrl;

	public Servico() {
	}

	public String getServicosId() {
		return this.servicosId;
	}

	public void setServicosId(String servicosId) {
		this.servicosId = servicosId;
	}

	public String getServicosNome() {
		return this.servicosNome;
	}

	public void setServicosNome(String servicosNome) {
		this.servicosNome = servicosNome;
	}

	public String getServicosUrl() {
		return this.servicosUrl;
	}

	public void setServicosUrl(String servicosUrl) {
		this.servicosUrl = servicosUrl;
	}

}