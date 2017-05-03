package com.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;


/**
 * The persistent class for the servicos_sub database table.
 * 
 */
@Entity
@Table(name="servicos_sub")
@NamedQuery(name="ServicosSub.findAll", query="SELECT s FROM ServicosSub s")
public class ServicosSub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="servicos_sub_id", unique=true, nullable=false)
	private String servicosSubId;

	@Column(name="servicos_id", nullable=false)
	private BigInteger servicosId;

	@Column(name="servicos_sub_nome", nullable=false, length=120)
	private String servicosSubNome;

	@Column(name="servicos_sub_url", nullable=false, length=120)
	private String servicosSubUrl;

	public ServicosSub() {
	}

	public String getServicosSubId() {
		return this.servicosSubId;
	}

	public void setServicosSubId(String servicosSubId) {
		this.servicosSubId = servicosSubId;
	}

	public BigInteger getServicosId() {
		return this.servicosId;
	}

	public void setServicosId(BigInteger servicosId) {
		this.servicosId = servicosId;
	}

	public String getServicosSubNome() {
		return this.servicosSubNome;
	}

	public void setServicosSubNome(String servicosSubNome) {
		this.servicosSubNome = servicosSubNome;
	}

	public String getServicosSubUrl() {
		return this.servicosSubUrl;
	}

	public void setServicosSubUrl(String servicosSubUrl) {
		this.servicosSubUrl = servicosSubUrl;
	}

}