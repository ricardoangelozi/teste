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
 * The persistent class for the estado database table.
 * 
 */
@Entity
@Table(name="estado")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="est_id", unique=true, nullable=false)
	private String estId;

	@Column(name="est_nome", nullable=false, length=120)
	private String estNome;

	@Column(name="est_status", nullable=false, length=1)
	private String estStatus;

	public Estado() {
	}

	public String getEstId() {
		return this.estId;
	}

	public void setEstId(String estId) {
		this.estId = estId;
	}

	public String getEstNome() {
		return this.estNome;
	}

	public void setEstNome(String estNome) {
		this.estNome = estNome;
	}

	public String getEstStatus() {
		return this.estStatus;
	}

	public void setEstStatus(String estStatus) {
		this.estStatus = estStatus;
	}

}