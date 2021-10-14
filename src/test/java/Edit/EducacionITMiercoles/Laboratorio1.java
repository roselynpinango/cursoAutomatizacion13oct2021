package Edit.EducacionITMiercoles;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	/*
	 * Método para abrir automationpractice.com 
	 * en Chrome y hacer una busqueda
	 * */
	@Test
	public void hacerBusquedaEnChrome() {
		// Paso 1: Indicar dónde está nuestro driver.exe
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITMiercoles\\Drivers\\chromedriver.exe");
		
		// Paso 2: Indicar qué navegador vamos a utilizar, instanciando el objeto WebDriver
		WebDriver driver = new ChromeDriver();
				
		// Paso 3: Abrir la página de AutomationPractice
		driver.get("http://automationpractice.com");
		
		// Paso 4: Maximizar el navegador
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Paso 5: Escribir la palabra que queremos buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 6: Hacer la busqueda
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 7: Cerrar el navegador
		//driver.close();
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		// Paso 1: Indicar dónde está nuestro driver.exe
		System.setProperty("webdriver.gecko.driver", "..\\EducacionITMiercoles\\Drivers\\geckodriver.exe");
		
		// Paso 2: Indicar qué navegador vamos a utilizar, instanciando el objeto WebDriver
		WebDriver driver = new FirefoxDriver();
				
		// Paso 3: Abrir la página de AutomationPractice
		driver.get("http://automationpractice.com");
		
		// Paso 4: Maximizar el navegador
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Paso 5: Escribir la palabra que queremos buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 6: Hacer la busqueda
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 7: Cerrar el navegador
		//driver.close();
	}
}
