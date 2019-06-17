package utilitarios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriversSelenium {
    protected static  ChromeDriver driver;

    @BeforeClass
    public static  void setUp(){	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\10044\\Desktop\\Eclipse 2018\\chromedriver.exe");
	    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        driver = new ChromeDriver();
    //  driver.get("http://10.254.16.80/17042019-v2018");
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
