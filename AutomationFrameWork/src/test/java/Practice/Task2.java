package Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task2 {

	public static void main(String[] args) {
		//Step 1: Lunch Browser
				WebDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("http://localhost:8888/index.php");
				
				//Step 2: login to application with valid credentials
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.id("submitButton")).click();
				
				//step 3: Navigate to organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//step 4: Click on create organization look up image
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				
				//step 5: Create organization with madatory fields
				Random r = new Random();
				int ramdom = r.nextInt(1000);
				driver.findElement(By.name("accountname")).sendKeys("Infosys"+ramdom);
				
				
				//Step 6: save and verify
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String lastEle = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				
				if(lastEle.contains("Infosys")) {
					System.out.println(lastEle+"....pass");
				}
				else {
					System.out.println(lastEle+"....failed");
				}
				
				//Step 7: logout of application
				WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions action = new Actions(driver);
				action.moveToElement(logoutEle).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				
				//Step 8: close brwoser
				driver.close();

	}

}
