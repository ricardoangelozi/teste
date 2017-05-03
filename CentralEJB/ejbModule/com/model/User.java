package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "TB_USER")
@NamedQueries({
	@NamedQuery(name = User.FIND_USUARIO_SENHA, query = "select u from User u where u.dsLogin = :dsLogin and u.dsSenha = :dsSenha"),
	@NamedQuery(name = User.FIND_EMAIL_EXISTE, query = "select u from User u where u.dsLogin = :dsLogin"),
	@NamedQuery(name = User.FIND_USUARIO_PORTARIA, query = "select u from User u where u.tpUsuario.id = :tipoUsuario"),
})

public class User implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_USUARIO_SENHA = "findUsuarioSenha";
	public static final String FIND_EMAIL_EXISTE = "findEmailExiste";
	public static final String FIND_LIBERAR_ACESSO = "findLiberarAcesso";
	public static final String FIND_USUARIO_PORTARIA = "findUsuarioPortaria";
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USER")
	private Long id;
	
	@Column(name = "DS_LOGIN", unique=true)
	private String dsLogin;
	
	@Column(name = "DS_SENHA")
	private String dsSenha;
	
	@OneToOne (fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_TP_USUARIO")
	private TpUsuario tpUsuario;
	
	public TpUsuario getTpUsuario() {
		return tpUsuario;
	}

	public void setTpUsuario(TpUsuario tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDsSenha() {
		return dsSenha;
	}

	public String getDsLogin() {
		return dsLogin;
	}

	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
