package business;

import java.awt.AWTException;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import utilitarios.InicializadorBrowser;
import utilitarios.MetodoUtil;
public class FerrramentaEdicaoArtigo extends InicializadorBrowser {

	@FindBy(xpath="//iframe[contains(@class, 'col-xs-12')]")
	private WebElement ferramentaEdicao;

	@FindBy(xpath="//html/body")
	private WebElement txtArea;

	@FindBy(xpath="//*[@id='RadEditor1Top']/div/ul[2]/li[8]/a/span")
	private WebElement link;

	@FindBy(id="LinkText")
	private WebElement tituloLink;
	
	@FindBy(id="LinkTooltip")
	private WebElement  auxilarInserirLink;

	@FindBy(id="lmInsertButton")
	private WebElement btnSalvarLink;

	@FindBy(id="LinkURL")
	private WebElement hiperLink;

	@FindBy(id="btnSalvarEditor")
	private WebElement btnEditor;

	@FindBy(xpath="//*[@id='lblSucessoEditor']/strong")
	private WebElement artigoEditado;

	@FindBy(id="btnVoltarEditor")
	private WebElement voltarArtigo;
	
	@FindBy(css=".ImageManager")
	private WebElement enviaBtn;
	
	//*[@id="RadFileExplorer1_asyncUpload1row0"]/span/input[2]
	
	@FindBy(css= ".icnUpload .rtbText")
	private WebElement selecioneBtn;
	
	@FindBy(id="RadFileExplorer1_asyncUpload1file0")
	private WebElement selecioneimagemBtn;
	
	@FindBy(id="RadFileExplorer1_btnUpload_input")
	private WebElement fazerUploadImagensBtn;
	
	@FindBy(css=".png")
	private WebElement selecionarImagem;
	
	@FindBy(id="InsertButton")
	private WebElement inseririmagemEditor;
	
	MetodoUtil metodos = new MetodoUtil(driver);

	public FerrramentaEdicaoArtigo(ChromeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void EditarArquivo(String ConteudoArtigo, String nomeLink, String linkAcesso ){

		metodos.tempo(6);
		//driver.switchTo().parentFrame();
		driver.switchTo().frame("ifrmEditor");
		//metodos.tempo(2);
		//link.click();
		metodos.tempo(2);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("ifrmEditor").switchTo().frame("RadEditor1_contentIframe");
		txtArea.click();
		metodos.tempo(2);
		txtArea.sendKeys(ConteudoArtigo, Keys.ENTER);
		metodos.tempo(2);
		driver.switchTo().parentFrame();

		link.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("ifrmEditor").switchTo().frame("Window");
		hiperLink.clear();
		hiperLink.sendKeys(linkAcesso);
		tituloLink.sendKeys(nomeLink);
		auxilarInserirLink.sendKeys("1");
		auxilarInserirLink.sendKeys(Keys.TAB);
		
		metodos.tempo(2);
		btnSalvarLink.click();
		metodos.tempo(2);	
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(ferramentaEdicao);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnEditor);
		metodos.tempo(2);
		btnEditor.click();
		metodos.tempo(1);
		//--Está linha só é utilizada nas versões da 05/10 para baixo
		//assertTrue("Artigo Salvo ",artigoEditado.getText().equals("Artículo grabado con éxito"));

		//voltarArtigo.click();
		metodos.tempo(2);
	}
	public void EdicaoArtigo(String ConteudoArtigoEdicao, String imagemedicao, String linkAcessoEdicao ) throws AWTException{

		metodos.tempo(3);
		//driver.switchTo().parentFrame();
		driver.switchTo().frame("ifrmEditor");
		//metodos.tempo(2);
		//link.click();
		metodos.tempo(2);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("ifrmEditor").switchTo().frame("RadEditor1_contentIframe");
		txtArea.click();
		txtArea.clear();
		metodos.tempo(2);
		txtArea.sendKeys(ConteudoArtigoEdicao, Keys.ENTER);
		metodos.tempo(2);
		driver.switchTo().parentFrame();
		enviaBtn.click();
		metodos.tempo(2);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("ifrmEditor").switchTo().frame("Window");
		//selecioneBtn.click();
		//metodos.tempo(3);
			
		WebElement imagemExiste = driver.findElement(By.id("RadFileExplorer1_grid_ctl00__0"));
		String nomeimagme = imagemExiste.getText();
		String resultImagem = nomeimagme.substring(0,10);
		System.out.println(resultImagem);

		int valorContador = 0;
		
			
while (!resultImagem.equals("@@" ))
{
	try 
	{
	
	imagemExiste = driver.findElement(By.id("RadFileExplorer1_grid_ctl00__"+valorContador+""));
	nomeimagme = imagemExiste.getText();
	resultImagem = nomeimagme.substring(0,15);

		 if (resultImagem.equals("ImageEdicao.png")) 
		 {
		break;
		 }
	}
	catch(StringIndexOutOfBoundsException e) 
	{	 
		selecioneBtn.click();
		selecioneimagemBtn.click();
		metodos.uploadArquivo(imagemedicao);
		metodos.tempo(1);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", fazerUploadImagensBtn);
		fazerUploadImagensBtn.click();
		metodos.tempo(3);
		inseririmagemEditor.click();
		System.out.println("Passou");		
		break;		
	}
valorContador ++;
}	
		
		metodos.tempo(2);

		driver.switchTo().defaultContent();
		//driver.switchTo().frame(ferramentaEdicao);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnEditor);
		metodos.tempo(2);
		btnEditor.click();
		metodos.tempo(1);
		
		
	
	}
}

