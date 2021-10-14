package Edit.EducacionITMiercoles;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionITMiercoles\\Drivers\\chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		// Paso 1: Inicializar el driver
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
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
}
