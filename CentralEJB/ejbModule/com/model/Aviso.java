package com.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the avisos database table.
 * 
 */
@Entity
@Table(name="avisos")
@NamedQuery(name="Aviso.findAll", query="SELECT a FROM Aviso a")
public class Aviso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data;

	@Column(nullable=false)
	private BigInteger idrevenda;

	@Lob
	@Column(nullable=false)
	private String mensagem;

	public Aviso() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigInteger getIdrevenda() {
		return this.idrevenda;
	}

	public void setIdrevenda(BigInteger idrevenda) {
		this.idrevenda = idrevenda;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}