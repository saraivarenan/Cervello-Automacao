package utilitarios;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

public class InicializadorBrowser {
	
	   protected ChromeDriver driver;
	   protected  File folder;

	    public InicializadorBrowser(WebDriver driver2){
	    	folder = new File(UUID.randomUUID().toString());
	    	folder.mkdir();
	    	
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\10044\\Desktop\\Eclipse 2018\\chromedriver.exe");
		    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		    ChromeOptions options = new ChromeOptions();
	        
    	    Map<String, Object> prefs = new HashMap<String, Object>();
    	    prefs.put("profile.default_content_settings.popups", 0);
    	    prefs.put("download.default_directory", folder.getAbsolutePath());
    	    
    	    options.setExperimentalOption("prefs", prefs);
    	    DesiredCapabilities cap = DesiredCapabilities.chrome();
    	    cap.setCapability(ChromeOptions.CAPABILITY, options);
    	    
    	    
		    
		    this.driver = (ChromeDriver) driver2;
	        PageFactory.initElements(driver2, this);

	    }
}
