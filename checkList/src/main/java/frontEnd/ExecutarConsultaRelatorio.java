package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarRelatorio;
import business.BuscarRelatorio;
import business.PaginaInicial;
import utilitarios.DriversSelenium;

public class ExecutarConsultaRelatorio extends DriversSelenium {
	
	PaginaInicial pageHome = new PaginaInicial(driver);
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	BuscarRelatorio buscarelatorio = new BuscarRelatorio(driver);
	ParametroCriarRelatorio parametrosRelatorio = new ParametroCriarRelatorio();

	@Test
	public void consultarRelatorio () throws Exception {
		fazerLogin.executaLogin();
		pageHome.entrarModuloRelatorio();
		buscarelatorio.buscarRelatorioRel(parametrosRelatorio.getNomeRel());
		
	}
}
