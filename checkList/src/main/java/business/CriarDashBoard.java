package business;

import org.openqa.selenium.chrome.ChromeDriver;

import utilitarios.InicializadorBrowser;
import utilitarios.MetodoUtil;

public class CriarDashBoard extends InicializadorBrowser {
	
	MetodoUtil metodos = new MetodoUtil(driver);
	
	public CriarDashBoard(ChromeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void criardashboardRel () throws Exception {
		
		metodos.iframeRelatorio();
		metodos.tirarFotoTela(driver, "C://Users//Cervello-Renan//Documents//Screen//Acessar_Relatorios.png");
		metodos.tempo(4);
		
	}
	

}
