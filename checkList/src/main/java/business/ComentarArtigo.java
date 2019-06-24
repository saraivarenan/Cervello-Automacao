package business;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import utilitarios.InicializadorBrowser;

public class ComentarArtigo extends InicializadorBrowser {
	
	
	public ComentarArtigo(ChromeDriver driver) {
		super(driver);
		
	}

	@FindBy(id= "txtComentario")
	private WebElement txtComentario;
	
	@FindBy(id="btnComentar")
	private WebElement btnComentar;
	
	@FindBy(xpath="//a[contains(@class, 'acao--simples lnkAprovarComentario')]")
	private WebElement btnAprovar;
	
}
