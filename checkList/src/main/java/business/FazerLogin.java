package business;

import utilitarios.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import backEnd.ParametroFazerLogin;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FazerLogin extends DriversSelenium {
	MetodoUtil metodos = new MetodoUtil(driver);
	    
	    @Given("^logar user \"(.*)\"e pass \"(.*)\"$")
	    public void logar_usuario(String userAdm, String pass) throws Throwable {
	    	super.setUp();
	    	ParametroFazerLogin login = new ParametroFazerLogin(driver);
	        driver.get("http://10.254.16.80/17042019-v2018");
	    	
	        login.userName.clear();
	       login.userName(userAdm);
	       login.userPass.clear();
	       login.userPass.sendKeys(pass);
	       login.userPass.submit();
	      metodos.tempo(3);
	    }

	    @When("^usuario insere suas credencias \"(.*)\"$")
	    public void usuario_insere_suas_credencias(String usuario) throws Throwable {

	    	ParametroFazerLogin login = new ParametroFazerLogin(driver);	
	    login.escolherUsuario.clear();
	    login.escolherUsuario.sendKeys(usuario);
	    }

	    @Then("^a página inicial e acessada$")
	    public void a_página_inicial_e_acessada() throws Throwable {
	    	ParametroFazerLogin login = new ParametroFazerLogin(driver);
	    	metodos.tempo(3);
	    	login.escolherUsuario.submit();
	    	
	    	metodos.tempo(3);
	 super.sair();
	    }

	    
	    
	    
}
