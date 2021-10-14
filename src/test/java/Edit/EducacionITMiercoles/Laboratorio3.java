package Edit.EducacionITMiercoles;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio3 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionITMiercoles\\Drivers\\chromedriver.exe";
	File screen;
	
	@BeforeSuite
	public void setUp() {
		// Configuración y apertura del navegador en la página correspondiente
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("Inicio de la Suite de Pruebas");
	}
	
	@Test(description="CP Hacer Busqueda en AutomationPractice", priority=200)
	public void hacerBusqueda() throws IOException {
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITMiercoles\\Evidencias\\01_pantalla_inicial.png"));
		
		// Caso de Prueba Hacer una Búsqueda en la página
		WebElement txtBuscador = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		txtBuscador.sendKeys("skirt");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITMiercoles\\Evidencias\\02_palabra_a_buscar.png"));
		
		txtBuscador.sendKeys(Keys.ENTER);
	
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITMiercoles\\Evidencias\\03_resultado_busqueda.png"));
	}
	
	@Test(description="CP Ir a la sección Contact Us", priority=100)
	public void irAContactUs() {
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact us"));
		lnkContactUs.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=contact");
		Assert.assertEquals(driver.getTitle(), "Contact us - My Store");
	}
	
	@Test(description="CP Registro de Usuario con datos válidos", priority=0)
	public void registrarUsuario() {
		// Paso 2: Completar el correo y hacer clic en el boton Create An Account
		WebElement correo = driver.findElement(By.id("email_create"));
		correo.sendKeys("nuevocorreo" + Math.random() + "@micorreo.com");
				
		WebElement btnCreate = driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
				
		// Paso 3: Completar el formulario y hacer clic en el boton Register
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender2")));
				
		WebElement radMrs = driver.findElement(By.cssSelector("#id_gender2"));
		radMrs.click();
				
		WebElement txtFirstname = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		txtFirstname.sendKeys("Ramon");
				
		WebElement chkNewsletter = driver.findElement(By.id("newsletter"));
		chkNewsletter.click();
				
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("18");
				
		driver.findElement(By.name("customer_lastname")).sendKeys("Gomez");
				
		driver.findElement(By.name("passwd")).sendKeys("123456789");
				
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("June ");
				
		Select years = new Select(driver.findElement(By.name("years")));
		years.selectByIndex(10);

		driver.findElement(By.cssSelector("#optin")).click();
				
		WebElement txtAddress1 = driver.findElement(By.name("address1"));
		txtAddress1.sendKeys("MiCalle 3454 6B");
				
		WebElement txtCity = driver.findElement(By.id("city"));
		txtCity.sendKeys("Cordoba");
				
		Select selState = new Select(driver.findElement(By.cssSelector("#id_state")));
		selState.selectByVisibleText("California");
				
		WebElement txtZipCode = driver.findElement(By.xpath("//*[@id='postcode']"));
		txtZipCode.sendKeys("15493");
		
		Select selCountry = new Select(driver.findElement(By.id("id_country")));
		selCountry.selectByValue("21");
				
		WebElement txtPhoneMobile = driver.findElement(By.id("phone_mobile"));
		txtPhoneMobile.sendKeys("654765454");
				
		WebElement txtAlias = driver.findElement(By.name("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Trabajo");
				
		WebElement btnRegister = driver.findElement(By.xpath("//button[@id='submitAccount']"));
		btnRegister.click();
	}
	
	@AfterSuite
	public void tearDown() {
		// Cerrar el navegador
		driver.close();
		
		System.out.println("Fin de la Suite de Pruebas");
	}
}
