package frontEnd;

import org.junit.Test;

import utilitarios.*;
import backEnd.ParametroFazerLogin;
import business.FazerLogin;

public class ExecutarFazerLogin extends DriversSelenium {

	FazerLogin regrasLogin = new FazerLogin(driver);
	ParametroFazerLogin valoresUsuario = new ParametroFazerLogin();
	MetodoUtil metodos = new MetodoUtil(driver);
	
	
	public void fazerLogin(String usuarioAdm, String usuario, String senha) throws Throwable{
		driver.get("http://10.254.16.80/17042019-v2018");
		//driver.get("http://186.237.202.19/CervelloPortal/");
		regrasLogin.logar_usuario(usuarioAdm, senha);
	//	regrasLogin.submit();
		metodos.tempo(2);
		regrasLogin.usuario_insere_suas_credencias(usuario);
		regrasLogin.a_página_inicial_e_acessada();
		metodos.tempo(3);
		}
	@Test
	public void executaLogin () throws Throwable
	{
		fazerLogin(valoresUsuario.getUsuarioAdm(), valoresUsuario.getUsuario(), valoresUsuario.getSenha());
		
	}
	
}
