package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Test_Laboratorio4_E1 {
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
	
	@Test(dataProvider="Datos Excel para Login")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.ingresarEmail(email);
		login.ingresarPassword(password);
		login.hacerClicEnEntrar();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="Datos Excel para Login")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionITMiercoles\\Datos\\datosLab4_E2.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos para Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[4][2];
		datos[0][0] = "correo900@gmail.com";
		datos[0][1] = "54rytdfgsawr";
		
		datos[1][0] = "correo901@gmail.com";
		datos[1][1] = "65u7itfg";
		
		datos[2][0] = "correo902@gmail.com";
		datos[2][1] = "dcsdeae2";
		
		datos[3][0] = "correo903@gmail.com";
		datos[3][1] = "89o9uo0u0";
		
		return datos;
	}
}
