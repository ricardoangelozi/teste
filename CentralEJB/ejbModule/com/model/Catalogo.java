package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the catalogos database table.
 * 
 */
@Entity
@Table(name="catalogos")
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_id", unique=true, nullable=false)
	private String catId;

	@Column(name="cat_data", nullable=false)
	private Date catData;

	@Column(name="cat_nome", nullable=false, length=120)
	private String catNome;
	
	@Column(name="cat_nome_catalogo", nullable=false, length=120)
	private String catNomeCatalogo;
	
	@Column(name="cat_photo", nullable=false, length=120)
	private String catPhoto;

	@Column(name="cat_url", nullable=false, length=120)
	private String catUrl;

	public Catalogo() {
	}

	public String getCatNomeCatalogo() {
		return catNomeCatalogo;
	}

	public void setCatNomeCatalogo(String catNomeCatalogo) {
		this.catNomeCatalogo = catNomeCatalogo;
	}
	
	public String getCatId() {
		return this.catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public Date getCatData() {
		return this.catData;
	}

	public void setCatData(Date catData) {
		this.catData = catData;
	}

	public String getCatNome() {
		return this.catNome;
	}

	public void setCatNome(String catNome) {
		this.catNome = catNome;
	}

	public String getCatPhoto() {
		return this.catPhoto;
	}

	public void setCatPhoto(String catPhoto) {
		this.catPhoto = catPhoto;
	}

	public String getCatUrl() {
		return this.catUrl;
	}

	public void setCatUrl(String catUrl) {
		this.catUrl = catUrl;
	}

}