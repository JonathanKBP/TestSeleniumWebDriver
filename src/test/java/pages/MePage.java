package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage{

	public MePage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	
	public MePage clicarAbaMoreDateAboutYou() {
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		return this;
	}
	
	public AddContactPage clicarBotaoAddMoreAboutYou() {
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		return new AddContactPage(navegador);
	}
}
