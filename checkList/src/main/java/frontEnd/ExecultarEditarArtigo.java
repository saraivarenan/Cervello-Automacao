package frontEnd;

import java.awt.AWTException;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;
import business.CriarArtigo;
import business.PaginaInicial;
import utilitarios.DriversSelenium;

public class ExecultarEditarArtigo extends DriversSelenium  {
	
	PaginaInicial pageHome = new PaginaInicial(driver);
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	CriarArtigo editaartigo = new CriarArtigo(driver);
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();

		@Test
		public void editarArtigo () throws Throwable{
			fazerLogin.executaLogin();
			pageHome.entrarModuloBasedeConhecimento();
			editaartigo.editarArtigo(valoresArtigo.getNome());
	}

}
