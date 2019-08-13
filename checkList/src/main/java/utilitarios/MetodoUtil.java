package utilitarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;





public class MetodoUtil extends InicializadorBrowser  {

	public MetodoUtil(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void tempo(int tempo) {

		int tempoSegundos1= tempo;
		tempoSegundos1 = tempoSegundos1 * 1000;
		try {
			Thread.sleep(tempoSegundos1);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	public  void buscaDropReverso(WebElement ElementoDrp, String ValorComparado) {

		int cont = 0;
		String nomeFunc = ElementoDrp.getAttribute("value");
		while (!nomeFunc.equals("@@@")) {
			ElementoDrp.sendKeys(Keys.DOWN);
			ElementoDrp.sendKeys(Keys.ARROW_UP);
			ElementoDrp.sendKeys(Keys.ENTER);
			nomeFunc = ElementoDrp.getAttribute("value");
			cont++;

			System.out.println(nomeFunc);

			if (nomeFunc.equals(ValorComparado)) {
				ElementoDrp.sendKeys(Keys.TAB);
				break;

			} else if (cont > 30) {
				System.out.println("Valor n�o encontrado");
				break;

			}
		}
	}
	public  void buscaDrop(WebElement drpNome, String ValorComparado) {

		int cont = 0;
		String nomeFunc = drpNome.getAttribute("value");;
		while (!nomeFunc.equals("@@@")) {
			drpNome.sendKeys(Keys.ARROW_DOWN);
			drpNome.sendKeys(Keys.ARROW_DOWN);
			drpNome.sendKeys(Keys.ENTER);
			nomeFunc = drpNome.getAttribute("value");
			cont++;

			System.out.println(nomeFunc);

			if (nomeFunc.equals(ValorComparado)) {
				drpNome.sendKeys(Keys.ENTER);
				break;

			} else if (cont > 10) {
				buscaDropReverso(drpNome, ValorComparado);
				break;
			}
		}
	}
	//iframe filhos do TMS
	public void iframeFilhoTms (){
		String idFramefilho = driver.findElement(By.xpath("//iframe[contains(@class, 'fancybox-iframe')]")).getAttribute("id");
		driver.switchTo().frame(idFramefilho);
	}	
	// iframe TMS
	public void iframePaiTms(){
		driver.switchTo().frame("tabPrincipalCervello_iframe_17");
	}
	
	//iframe Catologo de Serviço
	public void iframePaiCatalogo(){
		driver.switchTo().frame("tabPrincipalCervello_iframe_28");
	}
	public void iframePaiBaseConhecimento(){
		driver.switchTo().frame("tabPrincipalCervello_iframe_24");
	}
	public void iframeRelatorio() {
		driver.switchTo().frame("tabPrincipalCervello_iframe_29");
	}
	public void uploadArquivo(String caminhoArquivo) throws AWTException{
		
		StringSelection caminho = new StringSelection(caminhoArquivo);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(caminho, null);
		
		Robot rebotUpload = new Robot();
		rebotUpload.delay(1000);
		
		rebotUpload.keyPress(KeyEvent.VK_CONTROL);
		rebotUpload.keyPress(KeyEvent.VK_V);
		rebotUpload.keyRelease(KeyEvent.VK_V);
		rebotUpload.keyRelease(KeyEvent.VK_CONTROL);
		rebotUpload.keyPress(KeyEvent.VK_ENTER);
		rebotUpload.keyRelease(KeyEvent.VK_ENTER);
		rebotUpload.delay(1000);	
	}
	 public  boolean implicitWait(long time) {
		   try {
		    driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		    //System.out.println("Waited for " + time + " sec implicitly");

		   } catch (Exception e) {
		    return false;
		   }
		   return true;
		  }

	 public void SelectDropDown (WebElement dropDown, String valorDrop){
		 Select selectTipoSolici = new Select(dropDown);
		  selectTipoSolici.selectByVisibleText(valorDrop);
		 
	 }
	 public void tirarFotoTela (WebDriver driver,String caminhoArquivo)throws Exception{
		 
		 
		 //convertando webDriver objeto para TakesScreenshot
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 
		 ////Call getScreenshotAs method to create image file
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 
		 //Move image file to new destination
		 File DestFile=new File(caminhoArquivo);
		 
		 FileUtils.copyFile(SrcFile, DestFile);

		 
		 
	 }
	 public boolean verificarElemento(WebElement LocalElemnt ) throws Exception {
		    try {
		    	LocalElemnt.getText();
		        System.out.println("Elemento Existe");
		        return true;

		    } catch (NoSuchElementException e) {
		        System.out.println("Elemento não existe");
		        return false;
		    }
	
}
}
