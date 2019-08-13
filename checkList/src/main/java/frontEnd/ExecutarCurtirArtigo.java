package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;
import business.CriarArtigo;
import utilitarios.DriversSelenium;

public class ExecutarCurtirArtigo extends DriversSelenium {

	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();
	CriarArtigo criarArtigo = new CriarArtigo(driver); 
	
	@Test
	public void curtirArtigo () throws Throwable{
		fazerLogin.executaLogin();
		criarArtigo.gosteiArtigo(valoresArtigo.getNome());
		
		
	}
}
