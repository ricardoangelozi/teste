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

/*
 * Define os tipo  de usuarios Cadastro, Portaria, Sindico
 * **/

@Entity
@Table(name = "TB_TP_USUARIO")
@NamedQueries({
	@NamedQuery(name = TpUsuario.FIND_TP_USUARIO, query = "select u from TpUsuario u where u.id = :id")
})

public class TpUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_TP_USUARIO = "findTpUsuario";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_TP_USUARIO")
	private Long id;
	
	@Column(name = "TP_USUARIO")
	private String usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
