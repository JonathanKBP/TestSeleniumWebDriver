package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
	
	private WebDriver navegador;
	
	public LoginFormPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public LoginFormPage typeLogin(String login) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("julio0001");
		
		return this;
	}
}
