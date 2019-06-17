package business;

import utilitarios.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class FazerLogin extends InicializadorBrowser {
	MetodoUtil metodos = new MetodoUtil(driver);
	
	 	@FindBy(id="login")
	    private WebElement userName;

	    @FindBy(id="senha")
	    private WebElement userPass;
	    
	//    @FindBy(id="outrologin")
	 //   private WebElement btnEscolherUsuario;
	    
	    @FindBy(id="outrologin")
	    private WebElement escolherUsuario;

	    
	    @FindBy(xpath="//button[contains(text(), 'entrar')]")
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
	    //	btnEscolherUsuario.click();
	    	escolherUsuario.submit();
	    }


}
