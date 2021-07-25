package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Web {
	public static WebDriver createChrome() {
		// Abrindo navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonathan\\drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver navegador = new ChromeDriver(options);
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navegando para a pagina taskit
		navegador.get("http://www.juliodelima.com.br/taskit");
		
		return navegador; 
	}
}
