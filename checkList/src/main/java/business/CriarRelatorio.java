package business;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilitarios.InicializadorBrowser;
import utilitarios.MetodoUtil;

public class CriarRelatorio extends InicializadorBrowser {
	
	MetodoUtil metodos = new MetodoUtil(driver); 
	
	@FindBy(id= "btnNovoRelatorio")
	private WebElement btnrelatorio;
	
	@FindBy(id= "txtNome")
	private WebElement nomeRelatorio;
	
	@FindBy(id= "ddlIdioma")
	private WebElement idiomaRelatorio;
	
	@FindBy(id= "txtDescricao")
	private WebElement descricaoRelatorio;
	
	@FindBy(id= "ddlEstrutura")
	private WebElement estruturaRelatorio;
	
	@FindBy(id= "ddlTipoRelatorio")
	private WebElement tipoRelatorio;
	
	@FindBy(id= "ddlEixoX")
	private WebElement eixoRelatorio;
	
	@FindBy(id= "ddlSerie1")
	private WebElement serieRelatorio;
	
	@FindBy(id= "ddlTipoSerie1")
	private WebElement tipoSerieRelatorio;
	
	@FindBy(id= "txtNomeSerie1")
	private WebElement nomeSerieRelatorio;
	
	@FindBy(id= "ddlCamposFiltro")
	private WebElement filtroRelatorio;
	
	@FindBy(id= "addCamposDrillDown")
	private WebElement registroRelatorio;
	
	//frame filho campos do Relatório
	@FindBy(xpath="//iframe[contains(@class, 'col-xs-12')]")
	private WebElement camposRelatorio;
	
	//Mouse double nos campos do detalhe
	@FindBy(xpath="//*[@id=\"ddlCamposFiltro\"]/option[1]")
	private WebElement doubleClickFiltro;	
	
	@FindBy(id= "btnSubmit")
	private WebElement btnSalvarRel;
	

	public CriarRelatorio(ChromeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void criarRelatorio (String nomeRel, 
								String descricaoRel, 
								String nomeSerieRel, 
								String idiomaRel, 
								String estruturarel, 
								String tipoRel,
								String eixoRel,
								String serieRel,
								String filtrorel,
								String nomeserieRel,
								String tiposerieRel) {
		
		metodos.tempo(3);
		metodos.iframeRelatorio();
		metodos.tempo(1);
		btnrelatorio.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(camposRelatorio);
		metodos.tempo(2);
		nomeRelatorio.sendKeys(nomeRel);
		metodos.SelectDropDown(idiomaRelatorio, idiomaRel);
		metodos.tempo(2);
		descricaoRelatorio.sendKeys(descricaoRel);
		metodos.SelectDropDown(estruturaRelatorio, estruturarel);
		metodos.SelectDropDown(tipoRelatorio, tipoRel);
		metodos.SelectDropDown(eixoRelatorio, eixoRel);
		metodos.SelectDropDown(serieRelatorio, serieRel);
		metodos.SelectDropDown(tipoSerieRelatorio, tiposerieRel);
		nomeSerieRelatorio.sendKeys(nomeserieRel);
		metodos.SelectDropDown(filtroRelatorio, filtrorel);
		Actions ac = new Actions(driver);
		ac.moveToElement(doubleClickFiltro).doubleClick().perform();
		
		registroRelatorio.click();
		
		metodos.tempo(2);
		btnSalvarRel.click();
		metodos.tempo(2);
		
		
	}
	

}
