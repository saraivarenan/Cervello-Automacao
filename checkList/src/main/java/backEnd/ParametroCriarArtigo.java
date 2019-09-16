package backEnd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ParametroCriarArtigo {
	ParametroCriarTopico valoresTopico = new ParametroCriarTopico();
	String tematopico = valoresTopico.getDescricao();
	//	String idioma="Português";
	String nome = "AutoMatico script";
	String descricao ="Teste criação";
	//	String palavraChave ="automação";
	//	String sequencia = "1";
	String conteudo = " Teste Arquivo Qualidade. Automação de teste";
	String caminhoArquivo= "C:\\Users\\10044\\Desktop\\imagens teste\\400x300.png" ;
	String projetoRel = "Aplicativos";
	String tipoRel = "Adobe Acrobat - Professional";
	String assuntoRel = "Configurar";


	@FindBy(xpath="//a[contains(text(),'Novo artigo')]")	
	private WebElement articulosArtigos; //

	@FindBy(xpath="//a[@href='#close-modal']")
	private WebElement closeImagem;//

	@FindBy(xpath="//iframe[contains(@class, 'col-xs-12')]")
	private WebElement camposArtigos;//

	@FindBy(id="ddlTopico")
	private WebElement topicoTema;//

	@FindBy(id="ddlLingua")
	private WebElement idioma;//

	@FindBy(id="txtTitulo")
	private WebElement nomeArtigo;//

	@FindBy(id="txtDescricao")
	private WebElement descripcion;//

	@FindBy(id="txtPalavraChave")
	private WebElement palavraChave;//

	@FindBy(xpath="//a[@href='#modalImagem']")
	//*[@id='spanImagemNoticia']/div/span/label
	private WebElement btnAnexo;//

	//Selecionar imagem de uma pasta

	@FindBy(id="flImgIco")
	private WebElement selecionarImagem;//

	@FindBy(id="txtSequencia")
	private WebElement sequencia;//

	@FindBy(xpath="//a[@href='#editorArtigo']")
	private WebElement editarConteudo;//


	@FindBy(id="btnSalvar")
	private WebElement btnSalvar;//

	@FindBy(id="lnkPublicarArtigo")
	private WebElement btnPublicarArtigo;//

	@FindBy(xpath="/html/body/div[2]/span[3]")
	private WebElement mensagemSucesso;//


	//Modo Edição -- Base de Conhecimento

	@FindBy(xpath="//a[contains(.,'Meus artigos')]")	
	private WebElement meuArtigos;//

	@FindBy(xpath="//p[contains(.,'AutoMatico script')]")	
	private WebElement artigoCriado;//

	@FindBy(xpath="//i[contains(@class,'fas fa-edit')]")
	private WebElement editaArtigo;//

	@FindBy(xpath="//a[contains(@class,'acao--simples')]")
	private WebElement aprovarArtigo;//

	@FindBy(xpath="//h2[contains(.,'AutoMatico script')]")
	private WebElement verificarArtigoEditado;//

	@FindBy(id="buscaPortal")
	private WebElement pesquisaGlobal;	//

	@FindBy(xpath="//a[contains(text(),'AutoMatico script')]")
	private WebElement pesquisarArtigos;//

	//Aprovar Artigo pendente como aprovador da base de conhecimento	
	@FindBy(xpath="//a[contains(text(),'Artigos pendentes: ')]")	
	private WebElement artigosPendentes;//

	@FindBy(xpath= "//p[contains(.,'AutoMatico script')]")
	private WebElement artigoAprovar;//


	@FindBy(xpath= "//a[contains(@class,'acao--cancela')]")
	private WebElement btnCancelarPendentes;//

	//Comentar Artigo
	@FindBy(id= "txtComentario")
	private WebElement txtComentario;//

	@FindBy(id="btnComentar")
	private WebElement btnComentar;//

	@FindBy(xpath="//a[contains(@class, 'acao--simples lnkAprovarComentario')]")
	private WebElement btnAprovarComentado;//

	@FindBy(xpath="//a[contains(@class, 'acao--cancela lnkreprovacomentario')]")
	private WebElement btnReprovarComentado;//

	@FindBy(xpath="//a[contains(@class,'acao--simples lnkAprovarComentario')]")
	private WebElement aprovarComentario;//

	@FindBy(xpath="//a[contains(@class,'fas fa-times vermelho lnkDesativarComentario')]")
	private WebElement excluirComentario;//

	@FindBy(id="txtMotivo")
	private WebElement motivoReprovacaocomentario;//

	@FindBy(id="btnEnviarMensagemReprovacao")
	private WebElement btnEnviarReprovacaoComentario;//

	//Relacionar Categorização	
	@FindBy(xpath="//span[contains(.,'Relacionamentos')]")
	private WebElement abaRelacionnamento;

	@FindBy(id="ddlProjeto")
	private WebElement relacionamentoProjeto;//

	@FindBy(id="ddlTipo")
	private WebElement relacionnamentoTipo;//

	@FindBy(id="ddlAssunto")
	private WebElement relacionnamentoAssunto;

	@FindBy(id="lnkAddAssunto")
	private WebElement btnRelacionarCategorizacao;

	@FindBy(xpath="//a[contains(@class,'fas fa-times vermelho btnExcluiRelProjTipAssu')]")
	private WebElement btnExcluirRelacionamento;

	@FindBy(id="ddlTelas")
	private WebElement valorRelacionarTela;

	@FindBy(id="lnkAddTela")
	private WebElement btnAdiconarRelacionarTela;

	//Aba Permissões
	@FindBy(xpath="//span[contains(.,'Permissões')]")
	private WebElement abaPermissao;

	@FindBy(xpath="//span[contains(.,'Livre')]")
	private WebElement permissaoLivre;

	@FindBy(id="analista")
	private WebElement permissaoAnalista;

	@FindBy(id="lnkSair")
	private WebElement sairDoSistema;

	@FindBy(id="login")
	private WebElement userSistema;

	@FindBy(id="senha")
	private WebElement senhaSistema;

	@FindBy(id="outrologin")
	private WebElement usuarioAcesso;

	//Curtir artigo

	@FindBy(id="btnIconCurtir")
	private WebElement curtirArtigo;

	@FindBy(id="btnIconNCurtir")
	private WebElement nCurtirArtigo;

	@FindBy(id="lnkDownloadPDF")
	private WebElement downloadArtigo;



	public void articulosArtigos(String nomeArtigo) {
		this.articulosArtigos.click();
	}
	public void closeImagem () {
		this.closeImagem.click();
	}
	public void camposArtigos () {
		this.camposArtigos.isEnabled();
	}
	public void topicoTema() {
		this.topicoTema.isSelected();
	}
	public void idioma() {
		this.idioma.isSelected();
	}
	public void nomeArtigo(String nomeArtigo) {
		this.nomeArtigo.sendKeys(nomeArtigo);
	}
	public void descripcion(String descripcion) {
		this.descripcion.sendKeys(descripcion);	
	}
	public void palavraChave (String palavraChave) {
		this.palavraChave.sendKeys(palavraChave);
	}
	public void btnAnexo () {
		this.btnAnexo.click();
	}
	public void selecionarImagem () {
		this.selecionarImagem.click();
	}
	public void sequencia(String sequencia) {
		this.sequencia.sendKeys(sequencia);
	}
	public void editarConteudo () {
		this.editarConteudo.click();
	}
	public void btnSalvar() {
		this.btnSalvar.click();
	}
	public void btnPublicarArtigo(){
		this.btnPublicarArtigo.click();
	}
	public void mensagemSucesso () {
		this.mensagemSucesso.click();
	}
	public void meuArtigos() {
		this.meuArtigos.click();
	}
	public void artigoCriado() {
		this.artigoCriado.click();
	}
	public void btneditaArtigo() {
		this.editaArtigo.click();	
	}
	public void btnaprovarArtigo() {
		this.aprovarArtigo.click();
	}
	public void pesquisarArtigos() {
		this.pesquisarArtigos.click();
	}
	public void artigosPendentes() {
		this.artigosPendentes.click();
	}
	public void artigoAprovar() {
		this.artigoAprovar.click();
	}
	public void btnCancelarPendentes() {
		this.btnCancelarPendentes.click();
	}
	public void txtComentario (String comentario) {
		this.txtComentario.sendKeys(comentario);
	}
	public void btnComentar() {
		this.btnComentar.click();
	}
	public void btnAprovarComentado() {
		this.btnAprovarComentado.click();
	}
	public void aprovarComentario() {
		this.aprovarComentario.click();
	}
	public void excluirComentario() {
		this.excluirComentario.click();
	}
	public void motivoReprovacaocomentario(String motivoReprovar) {
		this.motivoReprovacaocomentario.sendKeys(motivoReprovar);
	}
	public void btnEnviarReprovacaoComentario () {
		this.btnEnviarReprovacaoComentario.click();
	}
	public void abaRelacionnamento () {
		this.abaRelacionnamento.click();
	}
	public void relacionamentoProjeto () {
		this.relacionamentoProjeto.isEnabled();
	}
	public void relacionnamentoTipo() {
		this.relacionnamentoTipo.isEnabled();
	}
	public void relacionnamentoAssunto() {
		this.relacionnamentoAssunto.isEnabled();
	}
	public void btnRelacionarCategorizacao () {
		this.btnRelacionarCategorizacao.click();
	}
	
	
	//



	public String getTematopico() {
		return tematopico;
	}
	public void setTematopico(String tematopico) {
		this.tematopico = tematopico;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPalavraChave() {
		return palavraChave;
	}
	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getSequencia() {
		return sequencia;
	}
	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	public ParametroCriarTopico getValoresTopico() {
		return valoresTopico;
	}
	public void setValoresTopico(ParametroCriarTopico valoresTopico) {
		this.valoresTopico = valoresTopico;
	}
	public String getProjetoRel() {
		return projetoRel;
	}
	public void setProjetoRel(String projetoRel) {
		this.projetoRel = projetoRel;
	}
	public String getTipoRel() {
		return tipoRel;
	}
	public void setTipoRel(String tipoRel) {
		this.tipoRel = tipoRel;
	}
	public String getAssuntoRel() {
		return assuntoRel;
	}
	public void setAssuntoRel(String assuntoRel) {
		this.assuntoRel = assuntoRel;
	}
	public void h2verificarArtigoEditado() {
		this.verificarArtigoEditado.isEnabled();
	}
	public void pesquisaGlobal() {
		this.pesquisaGlobal.click();
	}
	public void btnReprovarComentado() {
		this.btnReprovarComentado.click();
	}



}
