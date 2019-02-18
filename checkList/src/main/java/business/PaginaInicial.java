package business;

import utilitarios.*;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class PaginaInicial extends InicializadorBrowser {
	
	@FindBy(xpath="//h4[contains(text(), 'TMS')]")
	private WebElement entrarModuloTMS;
	
	@FindBy(xpath="//h4[contains(text(), 'Catálogo de Servicios')]")
	private WebElement entrarModuloCatalogo;
	
	@FindBy(xpath="//h4[contains(text(), 'Base de Conhecimento')]")
	private WebElement entrarModuloBasedeConhecimento;
	
	@FindBy(xpath="//h4[contains(text(), 'Relatórios')]")
	private WebElement entrarModuloRelatorio;
	
	
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
		entrarModuloBasedeConhecimento.click();
	}
	public void entrarModuloRelatorio() {
		entrarModuloRelatorio.click();
	}
}
