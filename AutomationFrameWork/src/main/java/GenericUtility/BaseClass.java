package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import vtiger_ObjectFactory.HomePage;
import vtiger_ObjectFactory.LoginPage;

public class BaseClass {

	PropertyFileUtility putil = new PropertyFileUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite(groups = {"smoke","regression"})
	public void bsConfig() {
		Reporter.log("----DataBase connection Established---", true);
	}

	@BeforeClass(groups = {"smoke","regression"})
	public void bcConfig() throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		sDriver=driver;
		Reporter.log("Browser got lunch successfully", true);
		wutil.toMaximize(driver);
		wutil.towaitForElements(driver);
		driver.get(URL);
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void bmConfig() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextfield().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		Reporter.log("-------Navigate to vtiger Home Page Successfully---", true);
	}

	@AfterMethod(groups = {"smoke","regression"})
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		wutil.toMouseHover(driver, hp.getAdministrator());
		hp.getSignout();
		Reporter.log("---Successfully log out", true);
	}

	@AfterClass(groups = {"smoke","regression"})
	public void acConfig() {
		driver.quit();
		Reporter.log("---close the browser Sucessfully", true);
	}

	@AfterSuite(groups = {"smoke","regression"})
	public void asConfig() {
		Reporter.log("---disconnect the database Sucessfully", true);
	}
}
