package teste.gamemania;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
	private WebDriver driver;
	
	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/");
		
		driver.findElement(By.xpath("//*[@id=\"menu\"]/button[4]/a")).click();
	}
	
	@Test
	public void TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botao = driver.findElement(By.id("botao-enviar"));
		
		String[] listaEmails = {"caique@email.com","maicon@gmail.com","joao@email.com"};
		String[] listaSenhas = {"senhaaleatoria","12345678","senhadojoao"};
		
		
		try {
			
			for(int contador = 0; contador < 3; contador++) {
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listaSenhas[contador]);
				botao.click();
				
				Thread.sleep(3000);
				
				campoEmail.clear();
				campoSenha.clear();
			}
			
			/*Teste de email incorreto
			campoEmail.sendKeys("caique@email.com");
			campoSenha.sendKeys("senhaaleatoria");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//Senha incorreta para um email cadastrado
			campoEmail.sendKeys("maicon@gmail.com");
			campoSenha.sendKeys("12345678");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//Usuario correto
			campoEmail.sendKeys("joao@email.com");
			campoSenha.sendKeys("senhadojoao");
			botao.click();
			
			Thread.sleep(5000);*/
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void EncerrarTeste() {
		driver.quit();
		
	}

}
