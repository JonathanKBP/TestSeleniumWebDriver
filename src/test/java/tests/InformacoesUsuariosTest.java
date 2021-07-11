package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;

public class InformacoesUsuariosTest {
	private WebDriver navegador;
	
	@Rule
	public TestName test = new TestName();

	@Before
	public void setUp() {
		// Abrindo navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonathan\\drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		navegador = new ChromeDriver(options);
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navegando para a pagina taskit
		navegador.get("http://www.juliodelima.com.br/taskit");
		

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

		// clicar em um link que possui a class "me"
		navegador.findElement(By.className("me")).click();

		// clicar em um link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}

	// @Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
		// Clicar no botão através do seu xpatc //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

		// Identificar a popup onde está o formulário de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

		// Na combo de nome "type" escolher a opção "Phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");

		// No campo de nome "contact" digitar "+5511999999999"
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511999999999");

		// Clicar no link de text "SAVE" que esta no popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();

		// Na mensagem de id "toast-container" validar que o texto é "Your contact has
		// been added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Your contact has been added!", mensagem);
	}

	@Test
	public void removerUmContatoDeUmUsuario() {
		// Clicar no elemento pelo xpath //span[text()="+551133334444"]/following-sibling::a
		navegador.findElement(By.xpath("//span[text()=\"+551133334444\"]/following-sibling::a")).click();
		
		// Confirmar a janela javascript
		navegador.switchTo().alert().accept();
		
		// Validar que a mensagem apresentada foi Rest in peace, dear phone!
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);
		
		String screenshotArquivo = "C:\\Users\\Jonathan\\Documents\\cursoSelenium\\testReport" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo );
		
		// Aguardar até 10 segundos para que a janela desapareça
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
		// Clicar no link com texto "logout"
		navegador.findElement(By.linkText("Logout")).click();
	}

	@After
	public void tearDown() {
		// Fechar o navegador
		navegador.quit();
	}
}
