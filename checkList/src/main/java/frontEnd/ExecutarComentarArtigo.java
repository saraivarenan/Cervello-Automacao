package frontEnd;

import org.junit.Test;

import backEnd.ParametroComentarArtigo;
import backEnd.ParametroCriarArtigo;
import business.CriarArtigo;
import business.PaginaInicial;
import utilitarios.DriversSelenium;

public class ExecutarComentarArtigo extends DriversSelenium {
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	CriarArtigo consultar = new CriarArtigo(driver);
	ParametroComentarArtigo valoresComentario = new ParametroComentarArtigo();
	ParametroCriarArtigo valoresArtigo = new ParametroCriarArtigo();
	
	@Test
	public void comentarArtigo () throws Exception {
		fazerLogin.executaLogin();
		consultar.comentarArtigo(valoresArtigo.getNome(),valoresComentario.getComentario(),valoresComentario.getReprovarMotivo());
	}
	

}
