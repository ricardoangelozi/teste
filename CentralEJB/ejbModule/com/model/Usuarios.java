package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * cadastro de funcionarios do condominio e se tem acesso ao sistema
 * */

@Entity
@Table(name = "TB_USUARIO")
@NamedQueries({
	@NamedQuery(name = Usuarios.FIND_USUARIO, query = "select u from Usuarios u where u.id = :id"),
})
public class Usuarios  implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String FIND_USUARIO = "findUsuario";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_USUARIO")
	private Long id;
	
	@Column(name = "DS_NOME")
	private String dsNome;
	
	@Column(name = "DS_SOBRE_NOME")
	private String dsSobreNome;
	
	@Column(name = "NR_RG")
	private String nrRg;
	
	@Column(name = "NR_CPF")
	private String nrCpf;
	
	@Column(name = "DS_CARGO")
	private String cargo;
	
	@Column(name = "DT_NASCIMENTO")
	private Date dtNascimento;
	
	@Column(name = "TEL_CONTATO_RES")
	private String telContatoRes;
	
	@Column(name = "TEL_CONTATO_CEL")
	private String telContatoCel;
	
	@Column(name = "DT_CADASTRO")
	private Date dtCadastro;
	
	@Column(name = "FL_EXCLUIDO")
	private Boolean flagExcluido = false;
	
	@Column(name = "DT_EXCLUSAO_CADASTRO")
	private Date dtExclusaoCadastro;
	
	@Column(name="FL_SEXO")
	private Integer sexo = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}

	public String getNrRg() {
		return nrRg;
	}

	public void setNrRg(String nrRg) {
		this.nrRg = nrRg;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelContatoRes() {
		return telContatoRes;
	}

	public void setTelContatoRes(String telContatoRes) {
		this.telContatoRes = telContatoRes;
	}

	public String getTelContatoCel() {
		return telContatoCel;
	}

	public void setTelContatoCel(String telContatoCel) {
		this.telContatoCel = telContatoCel;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public String getDsSobreNome() {
		return dsSobreNome;
	}

	public void setDsSobreNome(String dsSobreNome) {
		this.dsSobreNome = dsSobreNome;
	}

	public Boolean getFlagExcluido() {
		return flagExcluido;
	}

	public void setFlagExcluido(Boolean flagExcluido) {
		this.flagExcluido = flagExcluido;
	}

	public Date getDtExclusaoCadastro() {
		return dtExclusaoCadastro;
	}

	public void setDtExclusaoCadastro(Date dtExclusaoCadastro) {
		this.dtExclusaoCadastro = dtExclusaoCadastro;
	}
}
