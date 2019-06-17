package business;

import utilitarios.*;

import org.apache.bcel.generic.MethodObserver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class PaginaInicial extends InicializadorBrowser {
	
	@FindBy(xpath="//h4[contains(text(), 'TMS')]")
	private WebElement entrarModuloTMS;
	
	@FindBy(xpath="//h4[contains(text(), 'Catalogo de Serviços')]")
	private WebElement entrarModuloCatalogo;
	
	@FindBy(xpath="//a[@href='../BaseConhecimento/Home']")
	private WebElement entrarModuloBasedeConhecimento;
	
	@FindBy(xpath="//h4[contains(text(), 'RelatÃ³rios')]")
	private WebElement entrarModuloRelatorio;
	MetodoUtil metodos = new MetodoUtil(driver);
	
	
	
	
	public PaginaInicial(ChromeDriver driver) {
		super(driver);
		
	}
	
	public void entrarModuloTMS (){
				entrarModuloTMS.click();
	}
		public void entrarModuloCatalogo(){
		entrarModuloCatalogo.click();
	}
		
		
	public void entrarModuloBasedeConhecimento(){
		metodos.tempo(3);
		entrarModuloBasedeConhecimento.click();
	}
	public void entrarModuloRelatorio() {
		entrarModuloRelatorio.click();
	}
}
