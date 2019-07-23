package frontEnd;

import org.junit.Test;

import backEnd.ParametroCriarArtigo;
import backEnd.ParametroFazerLogin;
import business.CriarArtigo;
import utilitarios.DriversSelenium;

public class ExecutarPermissaoUsuarioLivre extends DriversSelenium {
	
	ExecutarFazerLogin fazerLogin = new ExecutarFazerLogin();
	CriarArtigo permissao = new CriarArtigo(driver);
	ParametroFazerLogin acessoSistema = new ParametroFazerLogin ();
	ParametroCriarArtigo artigo = new ParametroCriarArtigo();
@Test
public void executarpermissao() throws Exception {
	fazerLogin.executaLogin();
	permissao.permissaoArtigo(artigo.getNome(), "Livre",acessoSistema.getUsuarioAdm(),acessoSistema.getSenha(), acessoSistema.getUsuarioComum());
		
	}
}



