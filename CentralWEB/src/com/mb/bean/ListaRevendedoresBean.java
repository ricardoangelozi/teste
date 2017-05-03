package com.mb.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.Utils;
import com.dao.StatusDAO;
import com.facade.CadastroCentralFacede;
import com.facade.DocumentoFacede;
import com.facade.HistoricoAtendimentoFacede;
import com.facade.UserFacede;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Cadastro_Central;
import com.model.Documentos;
import com.model.HistoricoAtendimento;
import com.model.PedidoProduto;
import com.model.Status;
import com.model.User;

@ManagedBean(name = "ListaRevendedoresBean")
@ViewScoped
public class ListaRevendedoresBean implements Serializable {

	private static final long serialVersionUID = 4993049019194073795L;

	private static Font negritoPequena = new Font(Font.FontFamily.TIMES_ROMAN,
			10, Font.BOLD);

	private List<Cadastro_Central> listaCadastro;

	private Cadastro_Central cadastroSel;

	private List<PedidoProduto> listaPedidoProduto = new ArrayList<PedidoProduto>();

	private List<Cadastro_Central> filterlistaCadastro;
	
	private List<Status> listaStatusCatalogo = new ArrayList<Status>();
	
	private List<Status> listaStatusRevendedora = new ArrayList<Status>();
	
	private List<Status> listaStatus = new ArrayList<Status>();
	
	private String tipoCadastroSelecionado;
	
	@EJB
	private StatusDAO daoStatus;

	@EJB
	private CadastroCentralFacede daoCadastro;

	@EJB
	private HistoricoAtendimentoFacede daoHistorico;

	@EJB
	private DocumentoFacede daoDocumentos;

	@EJB
	private UserFacede daoUser;

	private String dsObservacao = "";

	private FiltroPesquisa filtro = new FiltroPesquisa();

	private StreamedContent file;

	@PostConstruct
	public void init() {
		listaStatusCatalogo.addAll(daoStatus.buscarStatus(1L));
		listaStatusRevendedora.addAll(daoStatus.buscarStatus(2L));
	}
	
	public void carregarStatus(){
		
		listaStatus.clear();
		if("CATALOGO".equals(tipoCadastroSelecionado)){
			listaStatus.addAll(listaStatusCatalogo);	
		} else {
			listaStatus.addAll(listaStatusRevendedora);
		}
		
	}

	public void buscarData() {
		this.setListaCadastro(new ArrayList<Cadastro_Central>());
		cadastroSel = null;
		
		if (filtro.getDateInicio() != null && filtro.getDateFim() != null) {
			this.listaCadastro = daoCadastro.buscarFiltro(
					filtro.getDateInicio(), filtro.getDateFim(),
					filtro.getStatusSelecionado(), getTipoCadastroSelecionado(),filtro.isDocumento());

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Preencha os campos de datas !"));
		}

	}

	public void buscaCpf(String cpf) {
		this.setListaCadastro(new ArrayList<Cadastro_Central>());
		cpf = cpf.replace(".", "").replace("-", "");
		cadastroSel = null;
		
		if (!"".equals(getFiltro().getNome())){
			if(getFiltro().getNome().length() < 6){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Digite mais de 6 caracteres para a busca de nome"));
			} else {
				this.listaCadastro =  daoCadastro.buscarNome("%"+getFiltro().getNome().replace(" ", "%")+"%");	
			}
			
		
		} else if (!"".equals(getFiltro().getEmail())) {
			this.listaCadastro =  daoCadastro.buscarEmail(getFiltro().getEmail());
		
		}else if (!"".equals(cpf)) {
			
			this.listaCadastro = daoCadastro.buscarCpfs(cpf);
		
		} else {
		
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Algum dos campos obrigatorio !"));
		}

	}

	public void impressao() {
		String appPath = Utils.CAMINHO_ARQ + "/impressao/"+ cadastroSel.getNome() + ".pdf";
		
		try {
			Document documento = new Document();
			PdfWriter.getInstance(documento, new FileOutputStream(appPath));
			documento.open();

			Image img = Image.getInstance(Utils.CAMINHO_ARQ + "/imagens/logo.png");
			img.setAlignment(Element.ALIGN_MIDDLE);
			img.scaleToFit(170, 170);

			documento.addTitle("Arquivo para impressão");
			documento.addSubject("Pedidos usuário");
			documento.addAuthor("Central Revendedora");
			documento.addCreator("Central Revendedora");

			Paragraph conteudo = new Paragraph();

			conteudo.add(new Paragraph("Nome : " + cadastroSel.getNome().toUpperCase(),negritoPequena));
			conteudo.add(new Paragraph("Email : "+ cadastroSel.getEmail().toString(), negritoPequena));
			conteudo.add(new Paragraph("CPF : " + cadastroSel.getCpf(),negritoPequena));
			conteudo.add(new Paragraph("RG : " + cadastroSel.getRg(),negritoPequena));
			conteudo.add(new Paragraph("SEXO : " + cadastroSel.getSexo(),negritoPequena));
			conteudo.add(new Paragraph("Data de Nascimento : "+ Utils.converteData(cadastroSel.getNascimento()), negritoPequena));
			conteudo.add(new Paragraph("Tel cel : " + cadastroSel.getFoneCel(),negritoPequena));
			conteudo.add(new Paragraph("Tel comercial : "+ cadastroSel.getFoneCom(), negritoPequena));
			conteudo.add(new Paragraph("Tel residencial : "+ cadastroSel.getFoneRes(), negritoPequena));
			conteudo.add(new Paragraph(" "));
			conteudo.add(new Paragraph("                                ENDEREÇO                                  "));
			conteudo.add(new Paragraph("CEP : " + cadastroSel.getCep(), negritoPequena));
			conteudo.add(new Paragraph("Endereço : " + cadastroSel.getRua() + " N° " + cadastroSel.getNumero(), negritoPequena));
			conteudo.add(new Paragraph("Complemento : " + cadastroSel.getComplemento(), negritoPequena));
			conteudo.add(new Paragraph("Cidade : "+ cadastroSel.getCidade(), negritoPequena));
			conteudo.add(new Paragraph("Estado : " + cadastroSel.getEstado(), negritoPequena));
			conteudo.add(new Paragraph("Bairro : " + cadastroSel.getBairro(), negritoPequena));
			conteudo.add(new Paragraph("Referencia : " + cadastroSel.getReferencia(), negritoPequena));
			conteudo.add(new Paragraph(" "));
			 
			PdfPTable table = new PdfPTable(7);
			table.setWidthPercentage(100);
			table.setWidths(new int[] { 10, 25, 12, 12, 10, 15, 16 });
			

			PdfPCell c1 = new PdfPCell(new Phrase("QTD"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Descrição"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Referencia"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Tamanho"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Pagina"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Preco UNI."));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Qtde X Preço"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			table.setHeaderRows(1);
			documento.add(img);
			documento.add(conteudo);
			
			for (int i = 0; i < cadastroSel.getListPedidos().get(0).getPedidoProdutos().size(); i++) {

				table.addCell(cadastroSel.getListPedidos().get(0).getListPedidoProdutos().get(i).getTbProcad().getQtdItens().toString());
				table.addCell(cadastroSel.getListPedidos().get(0).getListPedidoProdutos().get(i).getTbProcad().getProdescri());
				table.addCell(cadastroSel.getListPedidos().get(0).getListPedidoProdutos().get(i).getTbProcad().getProref().toString());
				table.addCell(cadastroSel.getListPedidos().get(0).getListPedidoProdutos().get(i).getTbProcad().getProtam().toString());
				table.addCell(String.valueOf(cadastroSel.getListPedidos().get(0).getListPedidoProdutos().get(i).getTbProcad().getPropag()));
				table.addCell(cadastroSel.getListPedidos().get(0).getListPedidoProdutos().get(i).getTbProcad().getPropreuni1().toString());
				table.addCell(" ");
				
			}
			documento.add(table);
			documento.close();
			
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		InputStream stream;
		try {
			stream = new FileInputStream(appPath);
			file = new DefaultStreamedContent(stream, "application/pdf",
					cadastroSel.getNome() + ".pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cadastroSel = null;
	}

	public void carregarPedidos() {

		setListaPedidoProduto(new ArrayList<PedidoProduto>());
		if (getCadastroSel().getPedidos() != null && getCadastroSel().getPedidos().size() > 0) {
			getListaPedidoProduto().addAll(getCadastroSel().getListPedidos().get(0).getListPedidoProdutos());
		}
		this.getCadastroSel().getPedidos();
	}

	public void salvar(Cadastro_Central sel) throws Exception {

		try {

			if (getDsObservacao() != "") {
				User user = new User();
				user = (User) SessionContext.getInstance().getUsuarioLogado();
				HistoricoAtendimento historico = new HistoricoAtendimento();
				historico.setUsuario(user);
				historico.setCadastro(daoCadastro.find(sel.getId()));
				historico.setDataAlteracao(new Date());
				historico.setDsObservacao(this.dsObservacao);

				sel.setFoneCel(sel.getFoneCel().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
				sel.setFoneCom(sel.getFoneCom().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
				sel.setFoneRes(sel.getFoneRes().replace(".", "").replace("-", "").replace("(", "").replace("", "").replace(")", "").trim());
				sel.setCpf(sel.getCpf().replace(".", "").replace("-", ""));

				daoCadastro.update(sel);
				daoHistorico.cadastrar(historico);
				sel.getHistorico().add(historico);
				this.setDsObservacao("");
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "","ATUALIZAÇÃO EFETUADA COM SUCESSO !!!"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "","Campo Descrição Obrigatorio !!!"));
			}
		} catch (Exception e) {

		} finally {

		}

	}

	public void salvarDocumentos(List<Documentos> listaDoc) {
		if (listaDoc != null && listaDoc.size() > 0) {
			for (Documentos docs : listaDoc) {
				daoDocumentos.ataulizar(docs);
			}
		}
	}

	public void excluirDocumentos(Documentos doc) throws IOException {
		try {
			daoDocumentos.deletar(doc.getId());
			File diretorio = new File(Utils.CAMINHO_ARQ + "/uploaders/" + doc.getNmArquivo());
			cadastroSel.getDocumentos().remove(doc);
			
			diretorio.deleteOnExit();
		} catch (Exception e) {

		} finally {

		}

	}

	public void downloadDocumentos(Documentos doc) throws IOException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		
		File arquivo = new File(Utils.CAMINHO_ARQ + "/uploaders/" + doc.getNmArquivo() + ".jpg");

		response.reset(); // Algum filtro pode ter configurado alguns cabeçalhos
							// no buffer de antemão. Queremos livrar-se deles,
							// senão ele pode colidir.
		// response.setHeader("Content-Type", "application/pdf"); // Define
		// apenas o tipo de conteúdo, Utilize se necessário
		// ServletContext#getMimeType() para detecção automática com base em
		// nome de arquivo.
		response.setHeader("Content-Disposition", "attachment; filename=" + arquivo.getName() + ";");
		OutputStream responseOutputStream = response.getOutputStream();

		// Lê o conteúdo do PDF
		URL url = arquivo.toURI().toURL();
		InputStream pdfInputStream = url.openStream();

		// Lê o conteúdo do PDF e grava para saída
		byte[] bytesBuffer = new byte[2048];
		int bytesRead;
		while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
			responseOutputStream.write(bytesBuffer, 0, bytesRead);
		}
		responseOutputStream.flush();

		// Fecha os streams
		pdfInputStream.close();
		responseOutputStream.close();
		facesContext.responseComplete();
	}

	public String getDsObservacao() {
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	public List<Cadastro_Central> getListaCadastro() {
		return listaCadastro;
	}

	public void setListaCadastro(List<Cadastro_Central> listaCadastro) {
		this.listaCadastro = listaCadastro;
	}

	public List<PedidoProduto> getListaPedidoProduto() {
		return listaPedidoProduto;
	}

	public void setListaPedidoProduto(List<PedidoProduto> listaPedidoProduto) {
		this.listaPedidoProduto = listaPedidoProduto;
	}

	public Cadastro_Central getCadastroSel() {
		return cadastroSel;
	}

	public void setCadastroSel(Cadastro_Central cadastroSel) {
		this.cadastroSel = cadastroSel;
	}

	public List<Cadastro_Central> getFilterlistaCadastro() {
		return filterlistaCadastro;
	}

	public void setFilterlistaCadastro(
			List<Cadastro_Central> filterlistaCadastro) {
		this.filterlistaCadastro = filterlistaCadastro;
	}

	public FiltroPesquisa getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroPesquisa filtro) {
		this.filtro = filtro;
	}

	public StreamedContent getFile() {
		impressao();
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public List<Status> getListaStatus() {
		return listaStatus;
	}

	public void setListaStatus(List<Status> listaStatus) {
		this.listaStatus = listaStatus;
	}

	public String getTipoCadastroSelecionado() {
		return tipoCadastroSelecionado;
	}

	public void setTipoCadastroSelecionado(String tipoCadastroSelecionado) {
		this.tipoCadastroSelecionado = tipoCadastroSelecionado;
	}

	public List<Status> getListaStatusCatalogo() {
		return listaStatusCatalogo;
	}

	public void setListaStatusCatalogo(List<Status> listaStatusCatalogo) {
		this.listaStatusCatalogo = listaStatusCatalogo;
	}

	public List<Status> getListaStatusRevendedora() {
		return listaStatusRevendedora;
	}

	public void setListaStatusRevendedora(List<Status> listaStatusRevendedora) {
		this.listaStatusRevendedora = listaStatusRevendedora;
	}
}
