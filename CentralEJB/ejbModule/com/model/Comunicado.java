package com.model;

import java.io.Serializable;
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
 * The persistent class for the comunicado database table.
 * 
 */
@Entity
@Table(name="comunicado")
@NamedQuery(name="Comunicado.findAll", query="SELECT c FROM Comunicado c")
public class Comunicado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="com_id", unique=true, nullable=false)
	private String comId;

	@Temporal(TemporalType.DATE)
	@Column(name="com_data", nullable=false)
	private Date comData;

	@Lob
	@Column(name="com_texto", nullable=false)
	private String comTexto;

	@Column(nullable=false, length=1)
	private String destinatario;

	public Comunicado() {
	}

	public String getComId() {
		return this.comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public Date getComData() {
		return this.comData;
	}

	public void setComData(Date comData) {
		this.comData = comData;
	}

	public String getComTexto() {
		return this.comTexto;
	}

	public void setComTexto(String comTexto) {
		this.comTexto = comTexto;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

}