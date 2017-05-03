package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the estado_data database table.
 * 
 */
@Entity
@Table(name="TB_ESTADO_DATA")
@NamedQuery(name="EstadoData.findAll", query="SELECT e FROM EstadoData e")
public class EstadoData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Long id;

	
	@Column(name="DS_CIDADE", nullable=false)
	private String dsCidade;
	
	@Column(name="ENTRADA_PEDIDO", nullable=false)
	private String entradaPedido;
	
	
	@Column(name="ENTREGA_CAIXA", nullable=false)
	private String entregaCaixa;

	
	@Column(name="BOLETO_PAGAMENTO", nullable=false)
	private String boletoPagamento;

	public EstadoData() {
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDsCidade() {
		return dsCidade;
	}



	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getEntradaPedido() {
		return entradaPedido;
	}

	public void setEntradaPedido(String entradaPedido) {
		this.entradaPedido = entradaPedido;
	}

	public String getEntregaCaixa() {
		return entregaCaixa;
	}

	public void setEntregaCaixa(String entregaCaixa) {
		this.entregaCaixa = entregaCaixa;
	}

	public String getBoletoPagamento() {
		return boletoPagamento;
	}

	public void setBoletoPagamento(String boletoPagamento) {
		this.boletoPagamento = boletoPagamento;
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
		EstadoData other = (EstadoData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}