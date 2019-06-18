package executar;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import frontEnd.ExecultarEditarArtigo;
import frontEnd.ExecutarConsultaArtigo;
import frontEnd.ExecutarCriarArtigo;
import frontEnd.ExecutarCriarTopico;
import frontEnd.ExecutarFazerLogin;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	//ExecutarFazerLogin.class,
	//ExecutarCriarTopico.class,
	ExecutarCriarArtigo.class,
	ExecultarEditarArtigo.class,
	ExecutarConsultaArtigo.class
	
}
)

public class CriarArtigo {   
}  	


