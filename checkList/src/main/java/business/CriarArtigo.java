package business;

import java.awt.AWTException;

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
	
	@FindBy(id="btnPublicarArtigo")
	private WebElement publicarArtigo;
	
	@FindBy(xpath="/html/body/div[2]/span[3]")
	private WebElement mensagemSucesso;
	
	
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
		metodos.tempo(1);
		driver.switchTo().alert().accept();
		metodos.implicitWait(20);
		mensagemSucesso.click();
	//	assertTrue(mensagemSucesso.getText().equals("ArtÃ­culo publicado con Ã©xito"));
		
		System.out.println(" valor: "+mensagemSucesso.getText());
		
		//*[@id="btnCloseModalFrame"]
		//class="close"
		//*[@id="dvArtigo-minibox"]/div[2]/div[2]/div/div[3]
		
	}
	
	
	

}

