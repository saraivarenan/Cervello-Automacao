package business;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitarios.InicializadorBrowser;
import utilitarios.MetodoUtil;

public class BuscarRelatorio extends InicializadorBrowser  {
	
	MetodoUtil metodos = new MetodoUtil(driver); 
	
	@FindBy(id= "filterText")
	private WebElement buscarRelatorio;
	
	@FindBy(xpath="//*[@id=\"ulMenuRelatorioChart\"]/li[6]/a")
	private WebElement clicarRelatorio;
	
	@FindBy(id="DataAberturaInicio")
	private WebElement datainicioRel;
	
	@FindBy (id = "DataAberturaTermino")
	private WebElement dataterminoRel;

	@FindBy (id = "lnkGenerate")
	private WebElement gerarRelatorio;
	
	static  String mainPage;
	
	@FindBy (xpath= "//*[@id=\"dvMenuBotoes\"]/div/div[3]/a")
	private WebElement resgistroSerieDrop;
	
	@FindBy (id= "lnkListaDetalheSerie1")
	private WebElement resgistroSerie1;
	
	
	@FindBy (id="btnAtualizar")
	private WebElement resgistroSerieAtulizar;
	
	@FindBy (id="btnExportar")
	private WebElement resgistroSerieExportar;
	
	 Robot robot;

	public BuscarRelatorio(ChromeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void buscarRelatorioRel (String nomeRelatorio) throws Exception {
		metodos.tirarFotoTela(driver, "C://Users//10044//Desktop//Eclipse 2018//evidencias//Acessar_Ambiente.png");
		metodos.iframeRelatorio();
		metodos.tirarFotoTela(driver, "C://Users//10044//Desktop//Eclipse 2018//evidencias//Acessar_Relatorios.png");
		metodos.tempo(4);
		buscarRelatorio.sendKeys(nomeRelatorio, Keys.ENTER);
		metodos.tempo(3);
		metodos.tirarFotoTela(driver, "C://Users//Cervello-Renan//Documents//Screen//Relatório.png");
		
		String nomeDaJanelaDeOrigem1 = driver.getWindowHandle();
		System.out.println("principal" + nomeDaJanelaDeOrigem1);	
		
		clicarRelatorio.click();
		metodos.tempo(2);
		mainPage = driver.getWindowHandle();
		 
		
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_TAB);
			 metodos.tempo(3);
			  robot.keyRelease(KeyEvent.VK_CONTROL);
			  robot.keyRelease(KeyEvent.VK_T);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		WebDriverWait wait = new WebDriverWait(driver, 5);
		  wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		  // Mudar para nova guia
		  List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		 // System.err.println(windowHandles);
		  driver.switchTo().window(windowHandles.get(1));
		  
		  metodos.implicitWait(60);
		  datainicioRel.sendKeys("14112018");
		  metodos.tempo(1);
		  dataterminoRel.sendKeys("14112018");
		  gerarRelatorio.click();
		  metodos.tempo(3);
		  metodos.tirarFotoTela(driver, "C://Users//Cervello-Renan//Documents//Screen//VerificarGráfico.png");
		  metodos.tempo(3);
		  resgistroSerieDrop.click();
		  metodos.implicitWait(60);
		  resgistroSerie1.click();
		  
		  try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				 robot.keyPress(KeyEvent.VK_TAB);
				 metodos.tempo(3);
				  robot.keyRelease(KeyEvent.VK_CONTROL);
				  robot.keyRelease(KeyEvent.VK_T);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  metodos.tempo(3);
		  List<String> windowHandles2 = new ArrayList<String>(driver.getWindowHandles());
			 // System.err.println(windowHandles);
			  driver.switchTo().window(windowHandles2.get(2));
			  metodos.tempo(3);
		   
		  resgistroSerieAtulizar.click();
		  
		  metodos.tempo(3);
		  metodos.tirarFotoTela(driver, "C://Users//Cervello-Renan//Documents//Screen//RegistrodaSerie1.png");
		  metodos.tempo(1);
		  
		  resgistroSerieExportar.click();
		  metodos.tempo(3);
	
	}


	
	
	
}
