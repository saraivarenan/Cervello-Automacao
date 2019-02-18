package business;

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

	MetodoUtil metodos = new MetodoUtil(driver);

	public FerrramentaEdicaoArtigo(ChromeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void EditarArquivo(String ConteudoArtigo, String nomeLink, String linkAcesso ){

		metodos.tempo(6);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(ferramentaEdicao).switchTo().frame("ifrmEditor");
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
		driver.switchTo().frame(ferramentaEdicao);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnEditor);
		metodos.tempo(2);
		btnEditor.click();
		metodos.tempo(1);
		//assertTrue("Artigo Salvo ",artigoEditado.getText().equals("Artículo grabado con éxito"));

		voltarArtigo.click();
		metodos.tempo(2);
	}
}
