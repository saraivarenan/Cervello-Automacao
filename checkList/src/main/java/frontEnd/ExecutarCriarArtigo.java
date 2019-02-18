package frontEnd;

import java.awt.AWTException;

import utilitarios.*;
import business.CriarArtigo;
import business.PaginaInicial;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;

public class ExecutarCriarArtigo extends DriversSelenium {
	PaginaInicial pageHome = new PaginaInicial(driver);
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();
	CriarArtigo criarArtigo = new CriarArtigo(driver); 

	@Test
	public void criarArtigo () throws AWTException{
		fazerLogin.executaLogin();
		pageHome.entrarModuloBasedeConhecimento();
		criarArtigo.criarArtigo(valoresArtigo.getTematopico(),valoresArtigo.getIdioma(),valoresArtigo.getNome(),valoresArtigo.getDescricao(),valoresArtigo.getPalavraChave(), valoresArtigo.getCaminhoArquivo(),valoresArtigo.getSequencia());
		
	}
	
	
}
