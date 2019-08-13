package backEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParametroFazerLogin {
		
	public WebDriver driver;
		
	@FindBy(id="login")
	public WebElement userName;

   @FindBy(id="senha")
   public WebElement userPass;
   
   
   @FindBy(id="outrologin")
   public WebElement escolherUsuario;

   
   @FindBy(xpath="//button[contains(text(), 'entrar')]")
   public WebElement btnLogar;
	
	public ParametroFazerLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
   
   public void userName(String usuarioNome) {
	   this.userName.sendKeys(usuarioNome);
   }
	public void userPass(String senha) {
		this.userPass.sendKeys(senha);
	}
	public void outrousuario(String usuarioEscolhido) {
		this.escolherUsuario.sendKeys(usuarioEscolhido);
		
	}	

}
