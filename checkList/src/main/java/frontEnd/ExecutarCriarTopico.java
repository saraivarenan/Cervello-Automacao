package frontEnd;

import org.junit.Test;

import utilitarios.DriversSelenium;
import backEnd.ParametroCriarTopico;
import business.CriarTopico;
import business.PaginaInicial;

public class ExecutarCriarTopico extends DriversSelenium {
	CriarTopico regrasCriarTopico = new CriarTopico(driver);
	PaginaInicial pageHome = new PaginaInicial(driver);
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	ParametroCriarTopico valoresTopico = new ParametroCriarTopico();
	
	
	@Test
	public void criarTopico (){
		fazerLogin.executaLogin();
		pageHome.entrarModuloBasedeConhecimento();
		regrasCriarTopico.criarTopico(valoresTopico.getTemaPadre(), valoresTopico.getDescricao(), valoresTopico.getOrden());
	}
	
	

}
