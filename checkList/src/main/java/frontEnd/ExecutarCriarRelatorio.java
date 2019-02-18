package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarRelatorio;
import business.CriarRelatorio;
import business.PaginaInicial;
import utilitarios.DriversSelenium;

public class ExecutarCriarRelatorio extends DriversSelenium {
	
	PaginaInicial pageHome = new PaginaInicial(driver);
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	CriarRelatorio criarRelatorio = new CriarRelatorio(driver);
	ParametroCriarRelatorio parametroRelatorio = new  ParametroCriarRelatorio();
	
	@Test
	public void criarRelatorio () {
		fazerLogin.executaLogin();
		pageHome.entrarModuloRelatorio();
		criarRelatorio.criarRelatorio(	 parametroRelatorio.getNomeRel(), 
										 parametroRelatorio.getDescricaoRel(), 
										 parametroRelatorio.getTipoSerieRel(), 
										 parametroRelatorio.getIdiomaRel(), 
										 parametroRelatorio.getEstruturaRel(), 
										 parametroRelatorio.getTipoRel(), 
										 parametroRelatorio.getEixoXRel(), 
										 parametroRelatorio.getSerieRel(), 
										 parametroRelatorio.getFiltrosSerieRel(), 
										 parametroRelatorio.getNomeSerieRel(),
										 parametroRelatorio.getTipoSerieRel());
	}

}
