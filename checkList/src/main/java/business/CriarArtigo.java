package business;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import backEnd.ParametroFerramentaArtigo;
import utilitarios.InicializadorBrowser;
import utilitarios.MetodoUtil;

public class CriarArtigo extends InicializadorBrowser {

	MetodoUtil metodos = new MetodoUtil(driver);
	FerrramentaEdicaoArtigo editordeArtigo = new FerrramentaEdicaoArtigo(driver);
	ParametroFerramentaArtigo valoresFerramentaEdicao = new ParametroFerramentaArtigo();
	
	@FindBy(xpath="//span[contains(text(),'Ferramentas')]")	
	private WebElement criaArtigo;
	
	@FindBy(xpath="//span[contains(text(),'Cadastro de Artigos')]")	
	private WebElement articulosArtigos;
	
	@FindBy(xpath="//iframe[contains(@class, 'col-xs-12')]")
	private WebElement camposArtigos;
	
	@FindBy(id="ddlTopico")
	private WebElement topicoTema;
	
	@FindBy(id="ddlIdioma")
	private WebElement idioma;
	
	@FindBy(id="txtNome")
	private WebElement nomeArtigo;
	
	@FindBy(id="txtDescricao")
	private WebElement descripcion;
	
	@FindBy(id="txtPalavraChave")
	private WebElement palavraChave;
	
	@FindBy(xpath="//div[@id='spanImagemNoticia']/div/span/label")
	//*[@id='spanImagemNoticia']/div/span/label
	private WebElement btnAnexo;
	
	@FindBy(id="txtSequencia")
	private WebElement sequencia;
	
	@FindBy(id="btnEditarArtigo")
	private WebElement editarConteudo;
		
	@FindBy(id="btnSalvarArtigo")
	private WebElement btnSalvar;
	
	@FindBy(id="btnPublicarArtigo")
	private WebElement publicarArtigo;
	
	@FindBy(xpath="/html/body/div[2]/span[3]")
	private WebElement mensagemSucesso;
	
	
	public CriarArtigo(ChromeDriver driver) {
		super(driver);
	}
	
	public void criarArtigo(String valorTema, String valorIdioma, String valorNome, String valorDescricao, String valorpalavraChave, String caminhoArquivo, String valorSequencia ) throws AWTException{
		metodos.tempo(2);
		metodos.iframePaiBaseConhecimento();
		metodos.tempo(2);
		criaArtigo.click();
		metodos.tempo(2);
		Actions act = new Actions(driver);
		act.doubleClick(criaArtigo).build().perform();
		metodos.tempo(1);
		articulosArtigos.click();
		metodos.tempo(4);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(camposArtigos);	
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
		metodos.uploadArquivo(caminhoArquivo);
		metodos.tempo(2);
		//Abrir o editot de arquivo
		editarConteudo.click();
		
		editordeArtigo.EditarArquivo(valoresFerramentaEdicao.getConteudoArtigo(), valoresFerramentaEdicao.getNomeLink(), valoresFerramentaEdicao.getHiperLink());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(camposArtigos);	
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnSalvar);
		metodos.tempo(2);
		btnSalvar.click();
		driver.switchTo().alert().accept();		
		metodos.tempo(3);
		metodos.implicitWait(20);
		publicarArtigo.click();
		metodos.tempo(1);
		driver.switchTo().alert().accept();
		metodos.implicitWait(20);
		mensagemSucesso.click();
	//	assertTrue(mensagemSucesso.getText().equals("Artículo publicado con éxito"));
		
		System.out.println(" valor: "+mensagemSucesso.getText());
		
		//*[@id="btnCloseModalFrame"]
		//class="close"
		//*[@id="dvArtigo-minibox"]/div[2]/div[2]/div/div[3]
		
	}
	
	
	

}

