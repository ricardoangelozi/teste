package com.mb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.Utils;
import com.facade.CadastroCentralFacede;
import com.facade.PedidoItemCentralFacede;
import com.facade.RevendedoraCpfFacede;
import com.mb.util.Constantes;
import com.model.Cadastro_Central;
import com.model.Pedido;
import com.model.PedidoProduto;
import com.model.Status;
import com.model.TbProcad;

@ManagedBean(name = "cadastroPedidoBean")
@ApplicationScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 4993049019194073795L;

	private Cadastro_Central cadastro;

	private List<TbProcad> listaPedidos = new ArrayList<TbProcad>();

	private List<TbProcad> listaPedidosHiro = new ArrayList<TbProcad>();

	private List<TbProcad> listaPedidosPravc = new ArrayList<TbProcad>();

	private TbProcad pedido = new TbProcad();

	private List<String> tamanho;
	
	private String dataNascimento = "";

	
	@EJB
	private PedidoItemCentralFacede pedidoItemCentralDAO;
	@EJB
	private CadastroCentralFacede daoCadastro;
	@EJB
	private RevendedoraCpfFacede daoRevende;
	
	private String nrCpf = "";

	private Integer qtdTotalItens = 0;

	private Double valorTotal = 0.0;

	private Integer qtdItems = 1;
	
	private Boolean exibirTamanho = Boolean.FALSE;

	private Boolean liberarCampos = Boolean.TRUE;

	private Boolean habilitarSite = Boolean.FALSE;

	private Boolean executaFind = Boolean.FALSE;

	@PostConstruct
	public void init() {
		System.out.println("ENTRO"); 
	}

	public String buscaCpf() {
		String pagina = "";
		try {
			this.setLiberarCampos(Boolean.TRUE);
			habilitarSite = Boolean.FALSE;
			Boolean cpfRevend = Boolean.FALSE;
			String cpfTela = nrCpf.replace(".", "").replace("-", "");
			executaFind = Boolean.FALSE;
			
			listaPedidos = new ArrayList<TbProcad>();

			listaPedidosHiro = new ArrayList<TbProcad>();

			listaPedidosPravc = new ArrayList<TbProcad>();

			
			if (cpfTela != null && !"".equals(cpfTela)) {
				cpfRevend = daoRevende.buscarCpf(cpfTela);

				if (!cpfRevend) {
					List<Cadastro_Central> listCad = daoCadastro.buscarCpfs(cpfTela);

					if (listCad.size() == 0) {
						cadastro = new Cadastro_Central();
						cadastro.setCpf(cpfTela);
						executaFind = Boolean.FALSE;
						liberarCampos = Boolean.FALSE;
						pagina = "/form_pedido_cadastro.xhtml";
					} else if (listCad.size() == 1 && listCad.get(0).getStatusItem().getId() == 1) {
						listCad.get(0).setCpf(nrCpf);
						setCadastro(listCad.get(0));
						dataNascimento = Utils.converteData(getCadastro().getNascimento());
						executaFind = Boolean.TRUE;
						liberarCampos = Boolean.FALSE;
						pagina = "/form_pedido_cadastro.xhtml";
					} else {
						habilitarSite = Boolean.TRUE;
						FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
						pagina = "/form_hiroshima_pedido.xhtml";
					}
				} else {
					habilitarSite = Boolean.TRUE;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pagina;
	}

	public void buscaIten(ActionEvent actionEvent) {
		if (pedido.getProref() != null
				&& pedido.getProref().toString().length() >= 4) {

			List<TbProcad> lista = pedidoItemCentralDAO.buscarItem(pedido
					.getProref());

			exibirTamanho = false;

			if (lista.size() == 0) {
				pedido = new TbProcad();
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Codigo Referencia não existente"));

			} else if (lista.size() == 1) {
				pedido = lista.get(0);

			} else if (lista.size() > 1) {
				pedido = lista.get(0);
				tamanho = new ArrayList<String>();
				exibirTamanho = true;

				for (TbProcad tbProcad : lista) {
					tamanho.add(tbProcad.getProtam());
				}
			}
		} else {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "",
									"Quantidade de numeros menor que permitido campo referencia !"));
		}
	}

	public void adicionarItemLista(ActionEvent actionEvent) {

		if (pedido.getProref().toString().length() >= 4
				&& (pedido.getPropreuni1() != null && !"".equals(pedido
						.getPropreuni1()))) {
			pedido.setValorTotalItens(pedido.getQtdItens()
					* Double.parseDouble(pedido.getPropreuni1()));
			setQtdTotalItens(qtdTotalItens + pedido.getQtdItens());
			if ("H".equals(pedido.getProcatped())) {
				getListaPedidosHiro().add(pedido);
			} else {
				getListaPedidosPravc().add(pedido);
			}
			setValorTotal(valorTotal + pedido.getValorTotalItens());
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Consulte campo referencia  !"));
		}
		setPedido(new TbProcad());
		tamanho = new ArrayList<String>();
		exibirTamanho = Boolean.FALSE;
	}

	public void removerItemListaHiro(TbProcad remover) {
		getListaPedidosHiro().remove(remover);
		setValorTotal(valorTotal - remover.getValorTotalItens());
		setQtdTotalItens(qtdTotalItens - remover.getQtdItens());
		pedido = new TbProcad();
	}

	public void removerItemListaPra(TbProcad remover) {
		getListaPedidosPravc().remove(remover);
		setValorTotal(valorTotal - remover.getValorTotalItens());
		setQtdTotalItens(qtdTotalItens - remover.getQtdItens());
		pedido = new TbProcad();
	}

	public String enviarDados(Cadastro_Central cadas) {

		if (getListaPedidosHiro().size() > 0
				|| getListaPedidosPravc().size() > 0) {
			getListaPedidos().addAll(this.getListaPedidosHiro());
			getListaPedidos().addAll(this.getListaPedidosPravc());
		}

		if (getListaPedidos() != null && getListaPedidos().size() > 0) {

			try {
				if (executaFind) {

					Cadastro_Central cadastroEntity = new Cadastro_Central();
					cadastroEntity = daoCadastro.find(cadas.getId());
					cadastroEntity.setTipo("revendedora");
					cadastroEntity.setDocumentoEnvio(false);
					
					//cadastroEntity.setStatus("");

					Status status = new Status();
						status.setId(2L);
						cadastroEntity.setStatusItem(status);
						
					Status statusAndamento = new Status();
					statusAndamento.setId(7L);
					cadastroEntity.setAndamento(statusAndamento);

					Pedido pedido = new Pedido();
						pedido.setCadastro(cadastroEntity);
						pedido.setDataHora(new Date());
						pedido.setStatusPedido("EM ABERTO");
						pedido.getPedidoProdutos().addAll(addPedidos(pedido, getListaPedidos()));

					cadastroEntity.getPedidos().add(pedido);
					cadastroEntity.setFoneCel(cadastroEntity.getFoneCel().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
					cadastroEntity.setFoneCom(cadastroEntity.getFoneCom().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
					cadastroEntity.setFoneRes(cadastroEntity.getFoneRes().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
					cadastroEntity.setCpf(cadastroEntity.getCpf().replace(".", "").replace("-", ""));
					daoCadastro.cadastrar(cadastroEntity);
					dataNascimento = "";
				} else {
					cadas.setFoneCel(cadas.getFoneCel().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
					cadas.setFoneCom(cadas.getFoneCom().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
					cadas.setFoneRes(cadas.getFoneRes().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
					cadastro.setCpf(cadastro.getCpf().replace(".", "").replace("-", ""));

					cadas.setTipo("revendedora");
					cadas.setDocumentoEnvio(true);
					cadas.setNascimento(Utils.converteDataString(dataNascimento));
					//cadas.setStatus("");
					
					Status status = new Status();
						status.setId(2L);
						cadas.setStatusItem(status);
						
						Status statusAndamento = new Status();
						statusAndamento.setId(7L);
						cadas.setAndamento(statusAndamento);
					
					Pedido pedido = new Pedido();
						pedido.setCadastro(cadas);
						pedido.setDataHora(new Date());
						pedido.setStatusPedido("EM ABERTO");
						pedido.getPedidoProdutos().addAll(addPedidos(pedido, getListaPedidos()));
					
					cadas.getPedidos().add(pedido);
					daoCadastro.cadastrarCatalogo(cadas);
					
				}
				cadastro = new Cadastro_Central();
				setNrCpf("");
				FacesContext.getCurrentInstance().getExternalContext()
						.getApplicationMap()
						.put("MSG", Constantes.MSG_PEDIDO_SUCESSO);
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().getExternalContext()
						.getApplicationMap()
						.put("MSG", Constantes.MSG_PEDIDO_ERRO);
			}
		} else {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"CADASTRE UM ITEN NA LISTA DE PEDIDOS !"));
			return "";
		}
		return "/mensagens.faces?faces-redirect=true";
	}

	public List<PedidoProduto> addPedidos(Pedido pedido, List<TbProcad> procad) {
		List<PedidoProduto> retornoLista = new ArrayList<PedidoProduto>();

		for (TbProcad tbProcad : procad) {

			PedidoProduto produto = new PedidoProduto();
			produto.setPedido(pedido);
			produto.setQtde(tbProcad.getQtdItens());
			produto.setTbProcad(tbProcad);
			retornoLista.add(produto);
		}

		return retornoLista;
	}

	public Cadastro_Central getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro_Central cadastro) {
		this.cadastro = cadastro;
	}

	public List<TbProcad> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<TbProcad> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<TbProcad> getListaPedidosHiro() {
		return listaPedidosHiro;
	}

	public void setListaPedidosHiro(List<TbProcad> listaPedidosHiro) {
		this.listaPedidosHiro = listaPedidosHiro;
	}

	public List<TbProcad> getListaPedidosPravc() {
		return listaPedidosPravc;
	}

	public void setListaPedidosPravc(List<TbProcad> listaPedidosPravc) {
		this.listaPedidosPravc = listaPedidosPravc;
	}

	public TbProcad getPedido() {
		return pedido;
	}

	public void setPedido(TbProcad pedido) {
		this.pedido = pedido;
	}

	public List<String> getTamanho() {
		return tamanho;
	}

	public void setTamanho(List<String> tamanho) {
		this.tamanho = tamanho;
	}

	public Boolean getExibirTamanho() {
		return exibirTamanho;
	}

	public void setExibirTamanho(Boolean exibirTamanho) {
		this.exibirTamanho = exibirTamanho;
	}

	public Integer getQtdTotalItens() {
		return qtdTotalItens;
	}

	public void setQtdTotalItens(Integer qtdTotalItens) {
		this.qtdTotalItens = qtdTotalItens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQtdItems() {
		return qtdItems;
	}

	public void setQtdItems(Integer qtdItems) {
		this.qtdItems = qtdItems;
	}

	public Boolean getLiberarCampos() {
		return liberarCampos;
	}

	public void setLiberarCampos(Boolean liberarCampos) {
		this.liberarCampos = liberarCampos;
	}

	public Boolean getHabilitarSite() {
		return habilitarSite;
	}

	public void setHabilitarSite(Boolean habilitarSite) {
		this.habilitarSite = habilitarSite;
	}

	public Boolean getExecutaFind() {
		return executaFind;
	}

	public void setExecutaFind(Boolean executaFind) {
		this.executaFind = executaFind;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
