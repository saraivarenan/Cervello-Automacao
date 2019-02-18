package business;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilitarios.*;


public class CriarTopico extends InicializadorBrowser {

	MetodoUtil metodos = new MetodoUtil(driver); 
	
	
	@FindBy(xpath="//span[contains(text(),'Ferramentas')]")	
	private WebElement criaTopico;
	
	@FindBy(xpath="//span[contains(text(),'Cadastro de Tópicos')]")	
	private WebElement temasTopicos;
	
	@FindBy(id="ddlTopicoPai")
	private WebElement TipoTopico;
	
	@FindBy(id="txtDescricao")
	private WebElement descricaoTema;
	
	@FindBy(id="txtOrdem")
	private WebElement campoOrgemTopico;
	
	@FindBy(id="btnSalvarTopico")
	private WebElement btnSalvar;
	
	@FindBy(xpath="//iframe[contains(@class, 'col-xs-12')]")
	private WebElement camposTopicos;
	
	public CriarTopico(ChromeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//*[@id="treeview_tv_active"]/div/span[2]
	public void criarTopico(String temaPadre, String descricao, String orden){
		metodos.tempo(3);
		metodos.iframePaiBaseConhecimento();
		metodos.tempo(2);
		criaTopico.click();
		metodos.tempo(2);
		Actions act = new Actions(driver);
		act.doubleClick(criaTopico).build().perform();
		metodos.tempo(3);
		temasTopicos.click();
		metodos.tempo(4);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(camposTopicos);	
		metodos.SelectDropDown(TipoTopico, temaPadre);
		descricaoTema.sendKeys(descricao);
		campoOrgemTopico.click();
		campoOrgemTopico.sendKeys(orden);
		btnSalvar.click();
		
		driver.switchTo().alert().accept();
		metodos.tempo(3);
		
		
		
	}

	

}
