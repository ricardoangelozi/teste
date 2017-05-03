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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pedido_id", unique=true, nullable=false)
	private Long pedidoId;

	@Column(name="data_hora", nullable=false)
	private Date dataHora;

	@Column(name="status_pedido", length=15)
	private String statusPedido;

	//bi-directional many-to-one association to Cadastro_Central
	@ManyToOne
	@JoinColumn(name="cadastro_id")
	private Cadastro_Central cadastro = new Cadastro_Central();

	//bi-directional many-to-one association to PedidoProduto
	@OneToMany(mappedBy="pedido", targetEntity = PedidoProduto.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<PedidoProduto> pedidoProdutos = new HashSet<PedidoProduto>();
	
	@Transient
	private List<PedidoProduto> listPedidoProdutos = new ArrayList<PedidoProduto>();
	
	
	
	
	public List<PedidoProduto> getListPedidoProdutos() {
		return new ArrayList<PedidoProduto>(getPedidoProdutos());
	}

	
	public Set<PedidoProduto> getPedidoProdutos() {
		return pedidoProdutos;
	}


	public void setListPedidoProdutos(List<PedidoProduto> listPedidoProdutos) {
		this.listPedidoProdutos = listPedidoProdutos;
	}

	public void setPedidoProdutos(Set<PedidoProduto> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
	}

	public Pedido() {
	}

	public Long getPedidoId() {
		return this.pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Date getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getStatusPedido() {
		return this.statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Cadastro_Central getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro_Central cadastro) {
		this.cadastro = cadastro;
	}
}