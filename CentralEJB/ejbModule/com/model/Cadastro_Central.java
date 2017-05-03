package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the cadastro database table.
 * 
 */
@Entity
@Table(name="cadastro")
@NamedQueries({
	@NamedQuery(name="Cadastro_Central.findAll", query="SELECT c FROM Cadastro_Central c where c.status = :status"),
	@NamedQuery(name="Cadastro_Central.findData", query="SELECT c FROM Cadastro_Central c where c.data >= :data"),
	@NamedQuery(name="Cadastro_Central.findStatus", query="SELECT c FROM Cadastro_Central c where c.statusItem.id = :status and c.catalogoEnvio is null"),
	@NamedQuery(name="Cadastro_Central.findStatusNotNull", query="SELECT c FROM Cadastro_Central c where c.statusItem.id = :status and c.catalogoEnvio is not null"),
	@NamedQuery(name="Cadastro_Central.findCpf", query="SELECT c FROM Cadastro_Central c where c.cpf = :cpf and c.statusItem.id = :status"),
	@NamedQuery(name="Cadastro_Central.findCpf2", query="SELECT c FROM Cadastro_Central c where c.cpf = :cpf"),
	@NamedQuery(name="Cadastro_Central.Nome", query="SELECT c FROM Cadastro_Central c where c.nome like :nome"),
	@NamedQuery(name="Cadastro_Central.Email", query="SELECT c FROM Cadastro_Central c where c.email = :email"),
})

public class Cadastro_Central implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public static final String fIND_ALL = "Cadastro_Central.findAll";
	public static final String fIND_DATA = "Cadastro_Central.findData";
	public static final String fIND_STATUS = "Cadastro_Central.findStatus";
	public static final String fIND_STATUS_NOT_NULL = "Cadastro_Central.findStatusNotNull";
	public static final String fIND_CPF = "Cadastro_Central.findCpf";
	public static final String fIND_CPF2 = "Cadastro_Central.findCpf2";
	public static final String fIND_NOME = "Cadastro_Central.Nome";
	public static final String fIND_EMAIL = "Cadastro_Central.Email";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	
	/*Data de cadastro no sistema*/
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data;
	
	@Column(  length=120)
	private String nome;
	
	@Column(  length=1)
	private String sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date nascimento;
	
	@Column(  length=12)
	private String rg;
	
	@Column(unique=true,  length=14)
	private String cpf;
	
	@Column(name="fone_cel",   length=14)
	private String foneCel;

	@Column(name="fone_com",   length=13)
	private String foneCom;

	@Column(name="fone_res",   length=13)
	private String foneRes;
	
	@Column(  length=120)
	private String email;
	
	

	
	
	@Column(  length=9)
	private String cep;
	
	@Column(  length=120)
	private String rua;
	
	@Column(  length=60)
	private String numero;
	
	@Column( length=60)
	private String bairro;

	@Column(  length=60)
	private String cidade;
	
	@Column(  length=2)
	private String estado;
	
	@Column(  length=120)
	private String complemento;
	
	@Column(  length=120)
	private String referencia;

	
	@Column(  length=60)
	private String conheceu;
	
	@Column(  length=1)
	private String newsletter;

	@Column (name = "ML_DIRETA")
	private boolean malaDireta = false;
	
	@Column (name = "DOCUMENTO_ENVIO")
	private boolean documentoEnvio;
	
	@OneToOne
	private Status statusItem;
	
	@OneToOne 
	private Status andamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="catalogo_envio")
	private Date catalogoEnvio;

	
	
	
	
	 /* Não vejo utilidades */
	
		@Temporal(TemporalType.DATE)
		@Column(name="catalogo_pedido")
		private Date catalogoPedido;
	
		@Column(  length=1)
		private String status;
		
		@Column(  length=60)
		private String tipo;
		
		@Column(name="pedido_realizado")
		private Boolean pedidoRealizado;
		
		private String observacao;
		
		@Column(name="cod_executiva",   length=6)
		private String codExecutiva;

		@Column(name="cod_executiva_x",   length=6)
		private String codExecutivaX;
		
		@Column(name="limite_credito")
		private Double limiteCredito;
		
		@Column(name="catalogo_envio_status",   length=1)
		private boolean catalogoEnvioStatus;

		@Column(name="catalogo_pedido_status",   length=1)
		private String catalogoPedidoStatus;
	
	/* -----------FIM-------------- */
		
		
	
	

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cadastro",targetEntity = Pedido.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Pedido> pedidos = new HashSet<Pedido>();
	
	@OneToMany(mappedBy="cadastro",targetEntity = HistoricoAtendimento.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<HistoricoAtendimento> historico = new HashSet<HistoricoAtendimento>();
	
	@OneToMany(mappedBy="cadastro",targetEntity = Documentos.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Documentos> documentos = new HashSet<Documentos>();
	
	
	@Transient
	private List<Documentos> listDocumentos = new ArrayList<Documentos>();
	
	@Transient
	private List<HistoricoAtendimento> listHistorico = new ArrayList<HistoricoAtendimento>();
	
	@Transient
	private List<Pedido> listPedidos  = new ArrayList<Pedido>();
	
	
	
	public List<Pedido> getListPedidos() {
		return new ArrayList<Pedido>(getPedidos());
	}

	public void setListPedidos(List<Pedido> listPedidos) {
		this.listPedidos = listPedidos;
	}

	public List<Documentos> getListDocumentos() {
		return new ArrayList<Documentos>(getDocumentos());
	}

	public void setListDocumentos(List<Documentos> listDocumentos) {
		this.listDocumentos = listDocumentos;
	}
	
	public List<HistoricoAtendimento> getListHistorico() {
		return new ArrayList<HistoricoAtendimento>(getHistorico());
	}

	public void setListHistorico(List<HistoricoAtendimento> listHistorico) {
		this.listHistorico = listHistorico;
	}
	
	public Cadastro_Central() {
	}
	
	public boolean isDocumentoEnvio() {
		return documentoEnvio;
	}

	public void setDocumentoEnvio(boolean documentoEnvio) {
		this.documentoEnvio = documentoEnvio;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Date getCatalogoEnvio() {
		return this.catalogoEnvio;
	}

	public void setCatalogoEnvio(Date catalogoEnvio) {
		this.catalogoEnvio = catalogoEnvio;
	}

	public boolean getCatalogoEnvioStatus() {
		return this.catalogoEnvioStatus;
	}

	public void setCatalogoEnvioStatus(boolean catalogoEnvioStatus) {
		this.catalogoEnvioStatus = catalogoEnvioStatus;
	}

	public Date getCatalogoPedido() {
		return this.catalogoPedido;
	}

	public void setCatalogoPedido(Date catalogoPedido) {
		this.catalogoPedido = catalogoPedido;
	}

	public String getCatalogoPedidoStatus() {
		return this.catalogoPedidoStatus;
	}

	public void setCatalogoPedidoStatus(String catalogoPedidoStatus) {
		this.catalogoPedidoStatus = catalogoPedidoStatus;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCodExecutiva() {
		return this.codExecutiva;
	}

	public void setCodExecutiva(String codExecutiva) {
		this.codExecutiva = codExecutiva;
	}

	public String getCodExecutivaX() {
		return this.codExecutivaX;
	}

	public void setCodExecutivaX(String codExecutivaX) {
		this.codExecutivaX = codExecutivaX;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getConheceu() {
		return this.conheceu;
	}

	public void setConheceu(String conheceu) {
		this.conheceu = conheceu;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFoneCel() {
		return this.foneCel;
	}

	public void setFoneCel(String foneCel) {
		this.foneCel = foneCel;
	}

	public String getFoneCom() {
		return this.foneCom;
	}

	public void setFoneCom(String foneCom) {
		this.foneCom = foneCom;
	}

	public String getFoneRes() {
		return this.foneRes;
	}

	public void setFoneRes(String foneRes) {
		this.foneRes = foneRes;
	}

	public Double getLimiteCredito() {
		return this.limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Date getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNewsletter() {
		return this.newsletter;
	}

	public void setNewsletter(String newsletter) {
		this.newsletter = newsletter;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getPedidoRealizado() {
		return this.pedidoRealizado;
	}

	public void setPedidoRealizado(Boolean pedidoRealizado) {
		this.pedidoRealizado = pedidoRealizado;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

	

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<HistoricoAtendimento> getHistorico() {
		return historico;
	}

	public void setHistorico(Set<HistoricoAtendimento> historico) {
		this.historico = historico;
	}

	public Set<Documentos> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<Documentos> documentos) {
		this.documentos = documentos;
	}

	public Status getStatusItem() {
		return statusItem;
	}

	public void setStatusItem(Status statusItem) {
		this.statusItem = statusItem;
	}

	public boolean isMalaDireta() {
		return malaDireta;
	}

	public void setMalaDireta(boolean malaDireta) {
		this.malaDireta = malaDireta;
	}

	
	
	
	public Status getAndamento() {
		return andamento;
	}

	public void setAndamento(Status andamento) {
		this.andamento = andamento;
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
		Cadastro_Central other = (Cadastro_Central) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}