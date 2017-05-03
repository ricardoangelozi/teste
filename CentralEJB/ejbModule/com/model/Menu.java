package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MENU")

@NamedQueries({
	@NamedQuery (name = Menu.MONTAR_MENU, query = "select u from Menu u where u.tpUsuario.id = :id"),
})
public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_MENU")
	private Long id;
	
	public static final String MONTAR_MENU = "montarMenu";
	
	@Column(name = "LK_PAGINA")
	private String linkPagina;
	
	@Column(name = "DS_MENU")
	private String dsMenu;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_TP_USUARIO")
	private TpUsuario tpUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLinkPagina() {
		return linkPagina;
	}

	public void setLinkPagina(String linkPagina) {
		this.linkPagina = linkPagina;
	}

	public String getDsMenu() {
		return dsMenu;
	}

	public void setDsMenu(String dsMenu) {
		this.dsMenu = dsMenu;
	}

	public TpUsuario getTpUsuario() {
		return tpUsuario;
	}

	public void setTpUsuario(TpUsuario tpUsuario) {
		this.tpUsuario = tpUsuario;
	}
	
	
}
