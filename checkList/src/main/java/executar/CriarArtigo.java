package executar;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import frontEnd.ExecutarCriarArtigo;
import frontEnd.ExecutarCriarTopico;
import frontEnd.ExecutarFazerLogin;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	//ExecutarFazerLogin.class,
	//ExecutarCriarTopico.class,
	ExecutarCriarArtigo.class
	
}
)

public class CriarArtigo {   
}  	


