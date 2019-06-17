package frontEnd;

import org.junit.Test;
import org.openqa.selenium.By;

import utilitarios.DriversSelenium;
import utilitarios.MetodoUtil;



public class ExecutarHome extends DriversSelenium {
	
	MetodoUtil Util = new MetodoUtil(driver);
	
@Test
	public void AcessarHome () {
		
	
	driver.get("http://10.254.16.80/17042019-v2018");
	driver.findElement(By.id("login")).sendKeys("cervello");
	driver.findElement(By.id("senha")).sendKeys("cervello01");
	driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/button")).click();
	Util.tempo(4);
	driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/button")).click();
	
	Util.tempo(4);
	
	
	//while ()
	
	//System.out.println(driver.findElement(By.xpath("//*[@id=\"dvMinhasPendencias\"]/section/div[2]/ul/li[1]/a/span[1]/b")).getText());
	
	int numeroSol = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"dvMinhasPendencias\"]/section/div[2]/ul/li[1]/a/span[1]/b")).getText()); 
	
	
	driver.findElement(By.xpath("//*[@id=\"dvMinhasPendencias\"]/section/div[2]/ul/li[1]/a/span[2]/span[2]")).click();
	
	Util.tempo(4);
	
	driver.switchTo().frame("mdAprovar_iFrameModel");
	
	driver.findElement(By.id("btnFormEtapaAvancarSolicitacao")).click();
	
	Util.tempo(4);
	//*[@id="dvMinhasPendencias"]/section/div[2]/ul/li[1]
	
	
	
	
	}


}
