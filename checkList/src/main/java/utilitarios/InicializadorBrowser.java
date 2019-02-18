package utilitarios;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class InicializadorBrowser {
	
	   protected ChromeDriver driver;

	    public InicializadorBrowser(ChromeDriver driver){
	    	
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Renan\\workspace\\driver\\chromedriver.exe");
		    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }
}
