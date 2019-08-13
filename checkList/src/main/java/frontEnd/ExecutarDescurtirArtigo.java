package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;
import business.CriarArtigo;
import utilitarios.DriversSelenium;

public class ExecutarDescurtirArtigo extends DriversSelenium {
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();
	CriarArtigo criarArtigo = new CriarArtigo(driver); 
	
	@Test
	public void descurtirArtigo () throws Exception{
		fazerLogin.executaLogin();
		criarArtigo.descurtiArtigo(valoresArtigo.getNome());
		
		
	}

}
