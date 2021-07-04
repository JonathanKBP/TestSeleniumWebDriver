package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InformacoesUsuariosTest {
	private WebDriver navegador;
	
	@Before
	public void setUp()
	{
		// Abrindo navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonathan\\drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		navegador = new ChromeDriver(options);
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navegando para a pagina taskit
		navegador.get("http://www.juliodelima.com.br/taskit");
	}

	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {

		// Clicar no link que possui o texto "Sign in"
		navegador.findElement(By.linkText("Sign in")).click();

		// Identificar o formulário de login
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo com name "login" que esta dentro do formulario de id
		// "signinbox" o texto "julio0001".
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

		// Digitar no campo com name "password" que esta dentro do formulario de id
		// "signinbox" o texto "123456".
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar mo link com o texto "SIGN IN"
		formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

		// Validar que dentro do elemento com class "me" esta o texto "Hi, Julio"
		WebElement me = navegador.findElement(By.className("me"));
		String textoNoElementoMe = me.getText();
		assertEquals("Hi, Julio", textoNoElementoMe);

	}
	
	@After
	public void tearDown() {
		// Fechar o navegador
		navegador.quit();
	}
}
