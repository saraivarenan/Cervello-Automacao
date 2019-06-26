package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;
import business.CriarArtigo;
import business.PaginaInicial;
import utilitarios.DriversSelenium;

public class ExecutarArtigoPendente extends DriversSelenium {
	PaginaInicial pageHome = new PaginaInicial(driver);
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();
	CriarArtigo criarArtigo = new CriarArtigo(driver); 
	
	@Test
	public void aprovarArtigoPendente ()throws Exception {
		fazerLogin.executaLogin();
		pageHome.entrarModuloBasedeConhecimento();
		criarArtigo.aprovarArtigo(valoresArtigo.getNome());
	}
	

}
