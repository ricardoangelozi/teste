package com.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the pedido_produto database table.
 * 
 */
@Entity
@Table(name="pedido_produto")
@NamedQuery(name="PedidoProduto.findAll", query="SELECT p FROM PedidoProduto p")
public class PedidoProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pedido_produto_id", unique=true, nullable=false)
	private Long pedidoProdutoId;

	@Column(nullable=false)
	private int qtde;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;

	//bi-directional many-to-one association to TbProcad
	@ManyToOne
	@JoinColumn(name="produto_id")
	private TbProcad tbProcad;

	public PedidoProduto() {
	}

	public Long getPedidoProdutoId() {
		return this.pedidoProdutoId;
	}

	public void setPedidoProdutoId(Long pedidoProdutoId) {
		this.pedidoProdutoId = pedidoProdutoId;
	}

	public int getQtde() {
		return this.qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public TbProcad getTbProcad() {
		return this.tbProcad;
	}

	public void setTbProcad(TbProcad tbProcad) {
		this.tbProcad = tbProcad;
	}

}