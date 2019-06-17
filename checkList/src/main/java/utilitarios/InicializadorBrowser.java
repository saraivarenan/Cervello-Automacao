package utilitarios;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class InicializadorBrowser {
	
	   protected ChromeDriver driver;

	    public InicializadorBrowser(ChromeDriver driver){
	    	
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\10044\\Desktop\\Eclipse 2018\\chromedriver.exe");
		    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }
}
