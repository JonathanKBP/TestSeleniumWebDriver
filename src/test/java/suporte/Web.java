package suporte;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	  public static final String AUTOMATE_USERNAME = "jonathankevin_Bb4IEi";
	  public static final String AUTOMATE_ACCESS_KEY = "vzxPy7SGgu871iFEx59e";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  
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
	
	public static WebDriver createBrowserStack() {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os_version", "Big Sur");
	    caps.setCapability("resolution", "1920x1080");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "latest");
	    caps.setCapability("os", "OS X");
	    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
	    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	    
	    WebDriver navegador = null;
	    
	    try {
	    	navegador = new RemoteWebDriver(new URL(URL), caps);
	    	
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// Navegando para a pagina taskit
			navegador.get("http://www.juliodelima.com.br/taskit");
	    } catch (MalformedURLException e){
	    	System.out.println("Houve um problema com a URL" + e.getMessage());
	    }
	    
	    
	    
	    return navegador;
	}
}
