package utilitarios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriversSelenium {
    protected static  ChromeDriver driver;

    @BeforeClass
    public static  void setUp(){	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Cervello-Renan\\workspace\\driver\\chromedriver.exe");
	    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        driver = new ChromeDriver();
      //  driver.get("http://186.237.202.19/cervello_homolog/");
        driver.manage().window().maximize();
    }

    @After
    public void limparCookies(){
    //    driver.manage().deleteAllCookies();
    }

    @AfterClass
       public static void sair(){
        driver.quit();
    }   


}
