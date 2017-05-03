package com.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the mega_oferta database table.
 * 
 */
@Entity
@Table(name="mega_oferta")
@NamedQuery(name="MegaOferta.findAll", query="SELECT m FROM MegaOferta m")
public class MegaOferta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slide_id", unique=true, nullable=false)
	private String slideId;

	@Column(name="slide_data", nullable=false)
	private Timestamp slideData;

	@Column(name="slide_photo", nullable=false, length=120)
	private String slidePhoto;

	@Column(name="slide_url", nullable=false, length=120)
	private String slideUrl;

	public MegaOferta() {
	}

	public String getSlideId() {
		return this.slideId;
	}

	public void setSlideId(String slideId) {
		this.slideId = slideId;
	}

	public Timestamp getSlideData() {
		return this.slideData;
	}

	public void setSlideData(Timestamp slideData) {
		this.slideData = slideData;
	}

	public String getSlidePhoto() {
		return this.slidePhoto;
	}

	public void setSlidePhoto(String slidePhoto) {
		this.slidePhoto = slidePhoto;
	}

	public String getSlideUrl() {
		return this.slideUrl;
	}

	public void setSlideUrl(String slideUrl) {
		this.slideUrl = slideUrl;
	}

}