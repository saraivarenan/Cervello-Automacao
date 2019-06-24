package business;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import backEnd.ParametroFerramentaArtigo;
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
	
	public CriarArtigo(ChromeDriver driver) {
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
		metodos.implicitWait(20);
		publicarArtigo.click();
		metodos.tempo(5);
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
		pesquisaGlobal.sendKeys(nomeArtigo);
		pesquisaGlobal.sendKeys(Keys.ENTER);
		metodos.tempo(1);
		metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\Pesquisar_Artigo.png");
		metodos.tempo(2);
		pesquisarArtigos.click();
		metodos.tempo(3);
		metodos.tirarFotoTela(driver, "C:\\Users\\10044\\Documents\\Screen\\Artigos\\Artigo_Consultado.png");
	}

	
	
	

}

