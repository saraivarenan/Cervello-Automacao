package utilitarios;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.Before;


public class DriversSelenium {
//	protected static File folder;
	public static  WebDriver driver;
   
    
   // @BeforeClass
    public void setUp(){	
   
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\10044\\Desktop\\Eclipse 2018\\chromedriver.exe");
    	
	  //  System.getProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

	   driver = new ChromeDriver();
	
  
        driver.manage().window().maximize();
    }

  //  @After
    public void limparCookies(){
    	
    	driver.quit();
//    	for(File file : folder.listFiles()) {
    //		file.delete();
    	}
  //  	folder.delete();
    //    driver.manage().deleteAllCookies();
//    }

  //  @AfterClass
       public  void sair(){
        driver.quit();
    }   


}
