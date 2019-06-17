package frontEnd;

import org.junit.Test;

import utilitarios.*;
import backEnd.ParametroFazerLogin;
import business.FazerLogin;

public class ExecutarFazerLogin extends DriversSelenium {

	FazerLogin regrasLogin = new FazerLogin(driver);
	ParametroFazerLogin valoresUsuario = new ParametroFazerLogin();
	MetodoUtil metodos = new MetodoUtil(driver);
	
	
	public void fazerLogin(String usuarioAdm, String usuario, String senha){
		//driver.get("http://10.254.16.80/17042019-v2018-Home/");
		driver.get("http://186.237.202.19/CervelloPortal/");
		regrasLogin.user(usuarioAdm, senha);
		regrasLogin.submit();
		metodos.tempo(2);
		regrasLogin.escolherUsuario(usuario);
		metodos.tempo(3);
		}
	@Test
	public void executaLogin (){
		fazerLogin(valoresUsuario.getUsuarioAdm(), valoresUsuario.getUsuario(), valoresUsuario.getSenha());
		
	}
	
}
