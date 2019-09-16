package business;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.NotActiveException;

import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import backEnd.ParametroFerramentaArtigo;
import junit.framework.Assert;
import utilitarios.InicializadorBrowser;
import utilitarios.MetodoUtil;

public class CriarArtigo extends InicializadorBrowser {

	MetodoUtil metodos = new MetodoUtil(driver);
	FerrramentaEdicaoArtigo editordeArtigo = new FerrramentaEdicaoArtigo(driver);
	ParametroFerramentaArtigo valoresFerramentaEdicao = new ParametroFerramentaArtigo();
	

	
	@FindBy(xpath="//a[contains(text(),'Novo artigo')]")	
	private WebElement articulosArtigos;
	
	@FindBy(xpath="//a[@href='#close-modal']")
	private WebElement closeImagem;
	
	@FindBy(xpath="//iframe[contains(@class, 'col-xs-12')]")
	private WebElement camposArtigos;
	
	@FindBy(id="ddlTopico")
	private WebElement topicoTema;
	
	@FindBy(id="ddlLingua")
	private WebElement idioma;
	
	@FindBy(id="txtTitulo")
	private WebElement nomeArtigo;
	
	@FindBy(id="txtDescricao")
	private WebElement descripcion;
	
	@FindBy(id="txtPalavraChave")
	private WebElement palavraChave;
	
	@FindBy(xpath="//a[@href='#modalImagem']")
	//*[@id='spanImagemNoticia']/div/span/label
	private WebElement btnAnexo;
	
//Selecionar imagem de uma pasta
	
	@FindBy(id="flImgIco")
	private WebElement selecionarImaegem;
	@FindBy(id="txtSequencia")
	private WebElement sequencia;
	
	@FindBy(xpath="//a[@href='#editorArtigo']")
	private WebElement editarConteudo;
	
	
	@FindBy(id="btnSalvar")
	private WebElement btnSalvar;
	
	@FindBy(id="lnkPublicarArtigo")
	private WebElement publicarArtigo;
	
	@FindBy(xpath="/html/body/div[2]/span[3]")
	private WebElement mensagemSucesso;
	
	
	//Modo Edição -- Base de Conhecimento
	
	@FindBy(xpath="//a[contains(.,'Meus artigos')]")	
	private WebElement meuArtigos;
	
	@FindBy(xpath="//p[contains(.,'AutoMatico script')]")	
	private WebElement artigoCriado;
	
	@FindBy(xpath="//i[contains(@class,'fas fa-edit')]")
	private WebElement editaArtigo;
	
	@FindBy(xpath="//a[contains(@class,'acao--simples')]")
	private WebElement aprovarArtigo;
	
	@FindBy(xpath="//h2[contains(.,'AutoMatico script')]")
	private WebElement verificarArtigoEditado;
	
	@FindBy(id="buscaPortal")
	private WebElement pesquisaGlobal;	
	
	@FindBy(xpath="//a[contains(text(),'AutoMatico script')]")
	private WebElement pesquisarArtigos;
	
	//Aprovar Artigo pendente como aprovador da base de conhecimento	
	@FindBy(xpath="//a[contains(text(),'Artigos pendentes: ')]")	
	private WebElement artigosPendentes;
	
	@FindBy(xpath= "//p[contains(.,'AutoMatico script')]")
	private WebElement artigoAprovar;
	
	
	@FindBy(xpath= "//a[contains(@class,'acao--cancela')]")
	private WebElement btnCancelarPendentes;
	
	//Comentar Artigo
	@FindBy(id= "txtComentario")
	private WebElement txtComentario;
	
	@FindBy(id="btnComentar")
	private WebElement btnComentar;
	
	@FindBy(xpath="//a[contains(@class, 'acao--simples lnkAprovarComentario')]")
	private WebElement btnAprovarComentado;
	
	@FindBy(xpath="//a[contains(@class, 'acao--cancela lnkreprovacomentario')]")
	private WebElement btnReprovarComentado;
	
	@FindBy(xpath="//a[contains(@class,'acao--simples lnkAprovarComentario')]")
	private WebElement aprovarComentario;
	
	@FindBy(xpath="//a[contains(@class,'fas fa-times vermelho lnkDesativarComentario')]")
	private WebElement excluirComentario;
	
	@FindBy(id="txtMotivo")
	private WebElement motivoReprovacaocomentario;
	
	@FindBy(id="btnEnviarMensagemReprovacao")
	private WebElement btnEnviarReprovacaoComentario;
	
	//Relacionar Categorização	
	@FindBy(xpath="//span[contains(.,'Relacionamentos')]")
	private WebElement abaRelacionnamento;
	
	@FindBy(id="ddlProjeto")
	private WebElement relacionamentoProjeto;
	
	@FindBy(id="ddlTipo")
	private WebElement relacionnamentoTipo;
	
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
	
	public CriarArtigo(WebDriver driver) {
		super(driver);
	}
	
	public void criarArtigo(String valorTema, String valorIdioma, String valorNome, String valorDescricao, String valorpalavraChave, String caminhoArquivo, String valorSequencia ) throws AWTException{
		
		
		metodos.tempo(1);
		articulosArtigos.click();
		metodos.tempo(4);
		metodos.tempo(3);
		metodos.SelectDropDown(topicoTema, valorTema);
		metodos.tempo(2);
		metodos.SelectDropDown(idioma, valorIdioma);
		nomeArtigo.sendKeys(valorNome);
		descripcion.sendKeys(valorDescricao);
		palavraChave.sendKeys(valorpalavraChave);
		metodos.tempo(2);
		sequencia.clear();
		sequencia.sendKeys(valorSequencia);
		metodos.tempo(2);
		btnAnexo.click();
		metodos.tempo(2);
		selecionarImaegem.click();
		metodos.tempo(2);
		metodos.uploadArquivo(caminhoArquivo);
		metodos.tempo(3);
		
		closeImagem.click();
		metodos.tempo(4);
		//Abrir o editot de arquivo
		editarConteudo.click();
		metodos.tempo(3);
//driver.switchTo().frame(PainelConteudoArtigo);

		editordeArtigo.EditarArquivo(valoresFerramentaEdicao.getConteudoArtigo(), valoresFerramentaEdicao.getNomeLink(), valoresFerramentaEdicao.getHiperLink());
		metodos.tempo(3);

		btnSalvar.click();	
		metodos.tempo(3);
		//metodos.implicitWait(20);
	//	publicarArtigo.click();
	//	metodos.tempo(5);
	//	driver.switchTo().alert().accept();
	//	metodos.implicitWait(20);
	//	mensagemSucesso.click();
	//	assertTrue(mensagemSucesso.getText().equals("ArtÃ­culo publicado con Ã©xito"));
		
	//	System.out.println(" valor: "+mensagemSucesso.getText());
		
		//*[@id="btnCloseModalFrame"]
		//class="close"
		//*[@id="dvArtigo-minibox"]/div[2]/div[2]/div/div[3]
		
	}
	public void editarArtigo(String nomeArtigo) throws AWTException {
		metodos.tempo(2);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", articulosArtigos);
		meuArtigos.click();
		metodos.tempo(3);
		artigoCriado.click();
		metodos.tempo(5);
		editaArtigo.click();
		metodos.tempo(2);
		editarConteudo.click();
		
		editordeArtigo.EdicaoArtigo("Artigo Editado via teste de Automação - Script", valoresFerramentaEdicao.getImagemedicao(), valoresFerramentaEdicao.getHiperLink());
		metodos.tempo(3);
		btnSalvar.click();
		metodos.tempo(3);
		publicarArtigo.click();
		metodos.tempo(4);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", meuArtigos);
		metodos.tempo(2);
		meuArtigos.click();
		metodos.tempo(4);
		artigoCriado.click();
		metodos.tempo(4);
	//	aprovarArtigo.click();
		metodos.tempo(3);
		System.out.println(verificarArtigoEditado.getText());
	}
	public void buscarArtigo(String nomeArtigo) throws Exception {
		metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\Página_Inicial.png");
		metodos.tempo(3);
		pesquisaGlobal.click();
		pesquisaGlobal.sendKeys(nomeArtigo,Keys.ENTER);
		metodos.tempo(1);
		metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\Pesquisar_Artigo.png");
		metodos.tempo(2);
		pesquisarArtigos.click();
		metodos.tempo(3);
		metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\Artigo_Consultado.png");
	}
	public void aprovarArtigo(String nomeArtigo) throws Exception{
		//Clicar no link Pendentes
		artigosPendentes.click();
		metodos.tempo(3);
		//Escolher aritgo para aprovar
		artigoAprovar.click();
		metodos.tempo(3);
		//Clicar em aprovar no artigo pendente
		aprovarArtigo.click();
		metodos.tempo(2);
		assertTrue("Artigo Aprovado", verificarArtigoEditado.getText().equals("AutoMatico script"));
		
	}
	public void comentarArtigo(String nomeArtigo, String comentario, String motivoReporvar) throws Exception{
		pesquisaGlobal.sendKeys(nomeArtigo,Keys.ENTER);
		metodos.tempo(2);
		pesquisarArtigos.click();
		metodos.tempo(3);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", txtComentario);
		txtComentario.click();
		txtComentario.sendKeys(comentario);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnComentar);
		btnComentar.click();
		metodos.tempo(2);
		aprovarComentario.click();
		metodos.tempo(2);
		excluirComentario.click();
		metodos.tempo(2);
		driver.switchTo().alert().accept();
		metodos.tempo(2);
		txtComentario.click();
		txtComentario.sendKeys(comentario);
		metodos.tempo(2);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnComentar);
		btnComentar.click();
		metodos.tempo(2);
		btnReprovarComentado.click();
		metodos.tempo(2);
		motivoReprovacaocomentario.click();
		motivoReprovacaocomentario.sendKeys(motivoReporvar);
		metodos.tempo(2);
		btnEnviarReprovacaoComentario.click();
		metodos.tempo(4);
		txtComentario.click();
		txtComentario.sendKeys(comentario);
		metodos.tempo(2);
		btnComentar.click();
		metodos.tempo(2);
		aprovarComentario.click();
		metodos.tempo(2);
	}
	public void relacionarCategorizacao (String nomeArtigo, String projetoRel, String tipoRel,  String assuntoRel ) throws Exception {
		pesquisaGlobal.sendKeys(nomeArtigo,Keys.ENTER);
		metodos.tempo(2);
		pesquisarArtigos.click();
		metodos.tempo(3);
		editaArtigo.click();
		metodos.tempo(2);
		abaRelacionnamento.click();
		metodos.tempo(2);
		metodos.SelectDropDown(relacionamentoProjeto, projetoRel);
		metodos.tempo(2);
		metodos.SelectDropDown(relacionnamentoTipo, tipoRel);
		metodos.tempo(2);
		metodos.SelectDropDown(relacionnamentoAssunto, assuntoRel);
		metodos.tempo(2);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnRelacionarCategorizacao);
		metodos.tempo(3);

			    try {
			    	WebElement tableaRelacionamento =driver.findElement(By.xpath("//*[@id=\"tblRelProjTipAssun\"]/tbody/tr"));
			        System.out.println(tableaRelacionamento +"Elemento Existe");
			        btnExcluirRelacionamento.click();
			        driver.switchTo().alert().accept();
			        metodos.tempo(2);
			        btnRelacionarCategorizacao.click();
			        metodos.tempo(2);

			    } catch (Exception e) {
			        System.out.println(e+"Elemento não existe");
			btnRelacionarCategorizacao.click();
			    }
			    metodos.tempo(2);
			    btnRelacionarCategorizacao.click();
			    
			    driver.switchTo().alert().accept();
			    metodos.tempo(2);
			    btnExcluirRelacionamento.click();
			    driver.switchTo().alert().accept();
			    metodos.tempo(2);
			    btnRelacionarCategorizacao.click();
			    metodos.tempo(2);
		btnSalvar.click();
		metodos.tempo(6);

		
		
	}
	public void relacionarTela (String nomeTela, String telaSelecionada) {
		pesquisaGlobal.sendKeys(nomeTela,Keys.ENTER);
		metodos.tempo(2);
		pesquisarArtigos.click();
		metodos.tempo(3);
		editaArtigo.click();
		metodos.tempo(2);
		abaRelacionnamento.click();
		metodos.tempo(2);
		metodos.SelectDropDown(valorRelacionarTela, telaSelecionada);
		metodos.tempo(2);
		btnAdiconarRelacionarTela.click();
		//*[@id="tblRelTelas"]/tbody/tr/td[1]
		
	}
	public void permissaoArtigo (String nomeArtigo, String tipoPermissao, String usuarioAdm, String senhaAdm, String usuario) throws Exception {
		pesquisaGlobal.sendKeys(nomeArtigo,Keys.ENTER);
		metodos.tempo(2);
		pesquisarArtigos.click();
		metodos.tempo(3);
		editaArtigo.click();
		metodos.tempo(2);
		abaPermissao.click();
		metodos.tempo(2);
		driver.findElement(By.xpath("//span[contains(.,'"+tipoPermissao+"')]")).click();
		metodos.tempo(3);
		btnSalvar.click();
		metodos.tempo(2);
		sairDoSistema.click();
		metodos.tempo(1);
		driver.switchTo().alert().accept();
		metodos.tempo(3);
		
		if (tipoPermissao.equals("Analista")) {
			
			userSistema.sendKeys(usuarioAdm);
			senhaSistema.sendKeys(senhaAdm);		
			senhaSistema.submit();
			usuarioAcesso.clear();
			usuarioAcesso.sendKeys(usuario);		
			usuarioAcesso.submit();
			metodos.tempo(3);
			
			
			buscarArtigo(nomeArtigo);
			}
		else {
			userSistema.sendKeys(usuarioAdm);
			senhaSistema.sendKeys(senhaAdm);		
			senhaSistema.submit();
			usuarioAcesso.clear();
			usuarioAcesso.sendKeys(usuario);
			usuarioAcesso.submit();
			metodos.tempo(3);
			buscarArtigo(nomeArtigo);
			
		}
		
		
	}
	public void gosteiArtigo (String nomeArtigo) throws Exception {
		pesquisaGlobal.sendKeys(nomeArtigo,Keys.ENTER);
		metodos.tempo(2);
		pesquisarArtigos.click();		
		metodos.tempo(2);
		String valorCurti = curtirArtigo.getAttribute("data-curtiu");
		
		if (valorCurti.equals("0")) {
			curtirArtigo.click();
			metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\Curtiu_Artigo.png");
		}
		else {
			System.out.println("Já está curtido");
			metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\SemCurtida_Artigo.png");
		}
		
	}
	public void descurtiArtigo (String nomeArtigo) throws Exception {
		pesquisaGlobal.sendKeys(nomeArtigo,Keys.ENTER);
		metodos.tempo(2);
		pesquisarArtigos.click();
		metodos.tempo(2);
		String valorNCurti = nCurtirArtigo.getAttribute("data-ncurtiu");
		System.out.println(valorNCurti);
		
		if (valorNCurti.equals("0")) {
			nCurtirArtigo.click();
			metodos.tempo(2);
			metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\Curtiu_Artigo.png");
		}
		else {
			System.out.println("já está descurtido");
	
		}
		
	}
	public void UltimoDownloadFeito() throws InterruptedException {
		downloadArtigo.click();
		metodos.tempo(2);		
		File listOfFiles[] = folder.listFiles();
		//Assert.assertEquals(listOfFiles.length, Is(Not(0)));
	//	Assert.assertEquals(IsNot<T>, listOfFiles.length);
  
  
	}
}

