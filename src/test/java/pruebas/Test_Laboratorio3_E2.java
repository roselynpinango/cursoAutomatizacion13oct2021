package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Test_Laboratorio3_E2 {
	WebDriver driver;
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionITMiercoles\\Drivers\\chromedriver.exe";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.ingresarEmail("micorreo@correo.com");
		login.ingresarPassword("1q2w3e4r5t");
		login.hacerClicEnEntrar();
	}
	
	@Test
	public void irAContactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
	}
	
	@Test
	public void hacerBusqueda() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.ingresarPalabraABuscar("dress");
		inicio.hacerBusqueda();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
}
