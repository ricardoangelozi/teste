package com.mb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.CadastroCentralFacede;
import com.facade.RevendedoraCpfFacede;
import com.model.Cadastro_Central;

@ManagedBean(name = "validarRevendedora")
@ViewScoped
public class ValidarRevendedora implements Serializable {

	private static final long serialVersionUID = 4993049019194073795L;

	private Cadastro_Central cadastro;

	@EJB
	private CadastroCentralFacede daoCadastro;
	@EJB
	private RevendedoraCpfFacede daoRevende;
	
	private String nrCpf = "";
	
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
						executaFind = Boolean.TRUE;
						liberarCampos = Boolean.FALSE;
						pagina = "/form_pedido_cadastro.xhtml";
					} else {
						habilitarSite = Boolean.TRUE;
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

	public Cadastro_Central getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro_Central cadastro) {
		this.cadastro = cadastro;
	}

	public CadastroCentralFacede getDaoCadastro() {
		return daoCadastro;
	}

	public void setDaoCadastro(CadastroCentralFacede daoCadastro) {
		this.daoCadastro = daoCadastro;
	}

	public RevendedoraCpfFacede getDaoRevende() {
		return daoRevende;
	}

	public void setDaoRevende(RevendedoraCpfFacede daoRevende) {
		this.daoRevende = daoRevende;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
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
}
