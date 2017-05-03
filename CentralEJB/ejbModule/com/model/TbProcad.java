package com.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the tb_procad database table.
 * 
 */
@Entity
@Table(name="tb_procad")

@NamedQueries({
		@NamedQuery(name="TbProcad.findAll", query="SELECT t FROM TbProcad t where t.proref = :id and t.proano = :ano and t.procampan = :procampan")
})

public class TbProcad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String fIND_ID = "TbProcad.findAll";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Long id;

	@Transient
	private Integer qtdItens = 1;
	
	@Transient
	private Double valorTotalItens;
	
	@Column(nullable=false)
	private short proano;

	@Column(nullable=false)
	private short procampan;

	@Column(nullable=false, length=8)
	private String procor;

	@Column(nullable=false, length=40)
	private String prodescri;

	@Column(nullable=false)
	private short profam;

	@Column(nullable=false)
	private short propag;

	@Column(nullable=false, precision=10, scale=4)
	private BigDecimal propreuni;

	@Column(nullable=false, length=8)
	private String propreuni1;

	@Column(nullable=false)
	private Integer proref;

	@Column(nullable=false)
	private int prorefde;

	@Column(nullable=false, length=1)
	private String prosta;

	@Column(nullable=false, length=2)
	private String protam;
	
	@Column(nullable=false, length=1)
	private String procatped;
	
	@Column(nullable=false)
	private short protamcod;

	public String getProcatped() {
		return procatped;
	}

	public void setProcatped(String procatped) {
		this.procatped = procatped;
	}

	public TbProcad() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getProano() {
		return this.proano;
	}

	public void setProano(short proano) {
		this.proano = proano;
	}

	public short getProcampan() {
		return this.procampan;
	}

	public void setProcampan(short procampan) {
		this.procampan = procampan;
	}

	public String getProcor() {
		return this.procor;
	}

	public void setProcor(String procor) {
		this.procor = procor;
	}

	public String getProdescri() {
		return this.prodescri;
	}

	public void setProdescri(String prodescri) {
		this.prodescri = prodescri;
	}

	public short getProfam() {
		return this.profam;
	}

	public void setProfam(short profam) {
		this.profam = profam;
	}

	public short getPropag() {
		return this.propag;
	}

	public void setPropag(short propag) {
		this.propag = propag;
	}

	public BigDecimal getPropreuni() {
		return this.propreuni;
	}

	public void setPropreuni(BigDecimal propreuni) {
		this.propreuni = propreuni;
	}

	public String getPropreuni1() {
		return this.propreuni1;
	}

	public void setPropreuni1(String propreuni1) {
		this.propreuni1 = propreuni1;
	}

	public Integer getProref() {
		return this.proref;
	}

	public void setProref(Integer proref) {
		this.proref = proref;
	}

	public int getProrefde() {
		return this.prorefde;
	}

	public void setProrefde(int prorefde) {
		this.prorefde = prorefde;
	}

	public String getProsta() {
		return this.prosta;
	}

	public void setProsta(String prosta) {
		this.prosta = prosta;
	}

	public String getProtam() {
		return this.protam;
	}

	public void setProtam(String protam) {
		this.protam = protam;
	}

	public short getProtamcod() {
		return this.protamcod;
	}

	public void setProtamcod(short protamcod) {
		this.protamcod = protamcod;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Double getValorTotalItens() {
		return valorTotalItens;
	}

	public void setValorTotalItens(Double valorTotalItens) {
		this.valorTotalItens = valorTotalItens;
	}

	

}