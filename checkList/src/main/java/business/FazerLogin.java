package business;

import utilitarios.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class FazerLogin extends InicializadorBrowser {
	MetodoUtil metodos = new MetodoUtil(driver);
	
	 	@FindBy(id="UC_Login1_txtLogin")
	    private WebElement userName;

	    @FindBy(id="UC_Login1_txtSenha")
	    private WebElement userPass;
	    
	    @FindBy(id="UC_Login1_btnLogarADM")
	    private WebElement btnEscolherUsuario;
	    
	    @FindBy(id="UC_Login1_txtLoginADM")
	    private WebElement escolherUsuario;

	    
	    @FindBy(id="UC_Login1_btnLogar")
	    private WebElement btnLogar;

	    public FazerLogin(ChromeDriver driver) {
	        super(driver);
	    }

	    public void user(String userAdm, String pass){
	        this.userName.clear();
	        this.userName.sendKeys(userAdm);

	        this.userPass.clear();
	        this.userPass.sendKeys(pass);
	    }
	    public void  submit(){
	    	btnLogar.click();
	    		    }
	    public void escolherUsuario(String usuario){
	    	escolherUsuario.clear();
	    	escolherUsuario.sendKeys(usuario);
	    	btnEscolherUsuario.click();
	    }


}
