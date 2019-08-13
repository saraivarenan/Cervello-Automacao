package executar;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature.Cucumber"	
		,glue = {"business"}
		)
//@Suite.SuiteClasses({
//	ExecutarFazerLogin.class,
	//ExecutarCriarTopico.class,
	//ExecutarCriarArtigo.class,
	//ExecultarEditarArtigo.class,
//	ExecutarConsultaArtigo.class
	
//}
//)

public class CriarArtigo {   
}  	


