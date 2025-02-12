package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoScriptWithDDT {

	public static void main(String[] args) throws IOException {
		
		//Read the data from Property file
		FileInputStream pfis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		
		String BROWSER=prop.getProperty("browser");
		String URL=prop.getProperty("url");
		String USERNAME=prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");
		
		//To read data from Excel files
		//FileInputStream efis= new FileInputStream(".");
		//Workbook wb = WorkbookFactory.create(efis);
		//String LASTNAME=wb.getSheet("Contacts").getRow(1).getCell(2).toString();
		
		
		//AutoScript
		//Step 1: Lunch Browser
				WebDriver driver=null;
				if(BROWSER.contains("chrome")) {
					driver=new ChromeDriver();
					}else if(BROWSER.contains("edge")) {
						driver=new EdgeDriver();
					}else if(BROWSER.contains("firefox")) {
						driver=new FirefoxDriver();
					}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
				
				//Step 2: login to application with valid credentials
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//step 3: Navigate to contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//step 4: Click on create contact look up image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//step 5: Create contact with madatory fields
				driver.findElement(By.name("lastname")).sendKeys("rameeza p");
				
				
				
				//Step 6: save and verify
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String lastEle = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				
				if(lastEle.contains("IDFC")) {
					System.out.println(lastEle+"....pass");
				}
				else {
					System.out.println(lastEle+"....failed");
				}
				
				//Step 8: logout of application
				WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions action = new Actions(driver);
				action.moveToElement(logoutEle).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
				//Step 9: close brwoser
				driver.close();

	}

}
