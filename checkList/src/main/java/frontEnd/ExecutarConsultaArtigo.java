package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;
import business.CriarArtigo;
import utilitarios.DriversSelenium;

public class ExecutarConsultaArtigo extends DriversSelenium {
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	CriarArtigo editaartigo = new CriarArtigo(driver);
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();
	
	@Test
	public void cosultarArtigo() throws Exception{
		fazerLogin.executaLogin();
		editaartigo.buscarArtigo(valoresArtigo.getNome());	}

}
