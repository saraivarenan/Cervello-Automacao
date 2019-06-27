package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;
import business.CriarArtigo;
import utilitarios.DriversSelenium;

public class ExecutarRelacionarCategorizacao extends DriversSelenium {
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	CriarArtigo relacionar = new CriarArtigo(driver);
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();
	
	@Test
	public void relacionarCategorizacao() throws Exception{
		fazerLogin.executaLogin();
		relacionar.relacionarCategorizacao(	valoresArtigo.getNome(), 
											valoresArtigo.getProjetoRel(), 
											valoresArtigo.getTipoRel(),
											valoresArtigo.getAssuntoRel());
	}

}
