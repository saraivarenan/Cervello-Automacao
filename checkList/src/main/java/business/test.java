package business;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitarios.InicializadorBrowser;
import utilitarios.MetodoUtil;

public class test extends InicializadorBrowser {
	
	static String numSolicitacao;
	
	@FindBy(id="txtFavorecido")
	private WebElement campoUser;
	
	@FindBy(id="filterText")
	private WebElement buscaSolicitacao;
	
	@FindBy(xpath="//*[@id='divResultadoPesquisa']/ul/li[2]/a")
	//*[@id="divResultadoPesquisa"]/ul/li[2]/a
	private WebElement selecionarFluxo;
	
	@FindBy(id="Campo_24256_30")
	private WebElement tipoSolicitud;
	
	@FindBy(id="Campo_24258_3")
	private WebElement descricao;
	//*[@id="divResultadoPesquisa"]/ul/li[1]/a
	@FindBy(id="btnSalvar")
	private WebElement btnSalvar;
	
	@FindBy(id="txtPesquisaUniversal")
	private WebElement campoBuscaSistema;
	
	@FindBy(xpath="//label[contains(@class, 'btn btn-primary btn-sm')]")
	private WebElement btnUpload;
	
	@FindBy(xpath="//iframe[contains(@class, 'col-xs-12')]")
	private WebElement reprovarIframe;
	
	@FindBy(id="txtObs")
	private WebElement txtAreaReprovar;
	
	@FindBy (id="btnAcao")
	private WebElement btnCancelarSolicitacao;
	
		
	static  String mainPage;
	
	MetodoUtil metodos = new MetodoUtil(driver);
	
	public test(ChromeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void abrirSolicitacao (String usser, String buscaSolici, String tipoSolicitudVal, String descripcion, String caminhoArquivo) throws AWTException {
		metodos.iframePaiCatalogo();
		buscaSolicitacao.sendKeys(buscaSolici, Keys.ENTER);
		metodos.tempo(2);
		String nomeDaJanelaDeOrigem1 = driver.getWindowHandle();
		System.out.println("principal" + nomeDaJanelaDeOrigem1);
		//*[@id="divResultadoPesquisa"]/ul/li[2]/a
		selecionarFluxo.click();
		//String nomeDaJanelaDeOrigem = driver.getWindowHandle();
		
		metodos.tempo(5);
		mainPage = driver.getWindowHandle();
 
		 Robot robot;
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
		  System.err.println(windowHandles);
		  driver.switchTo().window(windowHandles.get(1));
 
		  metodos.tempo(3);
		  Select selectTipoSolici = new Select(tipoSolicitud);
		
		  selectTipoSolici.selectByVisibleText(tipoSolicitudVal);
		  
		  descricao.sendKeys(descripcion);
		  //função que move o scrool do mouse até o componente
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnUpload);
		  btnUpload.click();
		  metodos.uploadArquivo(caminhoArquivo);
		  
		  
		  btnSalvar.click();
		  driver.switchTo().alert().accept();
		  
		  System.out.println(driver.switchTo().alert().getText());
		  metodos.tempo(4);
		  
		  List<String> listMensagem = new  ArrayList<String>();
		  
		  String valor = driver.switchTo().alert().getText();  
		  for (int i=0; i < valor.length(); i++) {  
		      System.out.println(valor.charAt(i));
		      char valor1 = valor.charAt(i);
		      String asString = Character.toString(valor1);
		      listMensagem.add(asString);
		  } 
		  numSolicitacao = listMensagem.get(10)+listMensagem.get(11)+listMensagem.get(12)+listMensagem.get(13)+listMensagem.get(14)+listMensagem.get(15);
	   
	}
	public static String getNumeroChamado(){
		return numSolicitacao;
	}
	public static String getPaginaMae(){
		return mainPage;
	}
	public void aprovarSoli(){
		  driver.switchTo().window(mainPage);
		  driver.findElement(By.xpath("//*[@id='tabPrincipalCervello']/li[2]/a/span[2]")).click();
		  campoBuscaSistema.sendKeys(numSolicitacao, Keys.ENTER);
		  metodos.tempo(4);
		  WebElement framePesquisa = driver.findElement(By.xpath("//iframe[contains(@class,'iframeTab')]"));
		   
		   String valorFrmae = framePesquisa.getAttribute("id");
		   System.out.println("valor"+valorFrmae);
		   driver.switchTo().frame(valorFrmae);
		 //*[@id="tabPrincipalCervello_iframe_08092017172050"]
		   
		   metodos.tempo(3);
		   WebElement btnAprovar = driver.findElement(By.xpath("//*[@id='dvPanel-"+numSolicitacao+"']/div[2]/div[1]/div[1]/a"));
		   btnAprovar.click();
		   metodos.tempo(3);
	
		   driver.switchTo().alert().accept();
		   metodos.tempo(6);
		   driver.switchTo().parentFrame();
		   driver.switchTo().frame(valorFrmae);
		   metodos.tempo(3);
		   WebElement verificarSolicitudeAprovar = driver.findElement(By.xpath("//*[@id='dvPanel-"+numSolicitacao+"']/p"));
		   System.out.println(verificarSolicitudeAprovar.getText());
		   assertTrue("Solicitação Aprovada", verificarSolicitudeAprovar.getText().equals("Solicitud aprobada."));
		   
	}
	public void reprovarSoli(){
		 driver.switchTo().window(mainPage);
		  driver.findElement(By.xpath("//*[@id='tabPrincipalCervello']/li[2]/a/span[2]")).click();
		  campoBuscaSistema.sendKeys(numSolicitacao, Keys.ENTER);
		  metodos.tempo(4);
		  WebElement framePesquisa = driver.findElement(By.xpath("//iframe[contains(@class,'iframeTab')]"));
		  driver.switchTo().frame(framePesquisa.getAttribute("id"));
		  
		   WebElement btnReprovar = driver.findElement(By.xpath("//*[@id='dvPanel-"+numSolicitacao+"']/div[2]/div[1]/div[2]/button"));
		   btnReprovar.click();
		   metodos.tempo(3);
		   
		   driver.switchTo().parentFrame();
		   driver.switchTo().frame(reprovarIframe);
		   txtAreaReprovar.sendKeys("txt area solicitação Reprovar");
		   btnCancelarSolicitacao.click();
		   metodos.tempo(3);
		   driver.switchTo().parentFrame();
		   driver.switchTo().frame(framePesquisa);
		   WebElement verificarSolicitudeReprovada = driver.findElement(By.xpath("//*[@id='dvPanel-"+numSolicitacao+"']/p"));
		   System.out.println(verificarSolicitudeReprovada.getText());
		   assertTrue("Solicitação Reprovada", verificarSolicitudeReprovada.getText().equals("Solicitud desaprobada."));
		   //*[@id="dvPanel-203775"]/p;
	}

}
