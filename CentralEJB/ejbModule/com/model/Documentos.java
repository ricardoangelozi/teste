package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TB_DOCUMENTO_ENVIO")

@NamedQueries({
	@NamedQuery(name="enviado", query="SELECT c FROM Documentos c where c.cadastro.id = :id ")
})
public class Documentos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String DOCUMENTO_ENVIADO = "enviado";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Cadastro_Central
	@ManyToOne
	@JoinColumn(name="cadastro_id", nullable=false)
	private Cadastro_Central cadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataEnvio;
	
	@Column(name="nm_arquivo")
	private String nmArquivo;
	
	@Column(name="doc_cad")
	private String docCad;
	
	@Column(name="fl_aprovado")
	private boolean aprovado = false;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cadastro_Central getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro_Central cadastro) {
		this.cadastro = cadastro;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	public String getDocCad() {
		return this.docCad;
	}

	public void setDocCad(String docCad) {
		this.docCad = docCad;
	}
	
	public String getNmArquivo() {
		return nmArquivo;
	}

	public void setNmArquivo(String nmArquivo) {
		this.nmArquivo = nmArquivo;
	}
	
	public boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

}
