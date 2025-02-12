package vtiger_ObjectFactory;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorganization;
	
	@FindBy(name="accountname")
	private WebElement oraganizationname;
	
	@FindBy(name="button")
	private WebElement saveButton;
	@FindBy(name="industry")
	private WebElement industryDropDwon;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDwon;
	
	@FindBy(linkText = "infosys989")
	private WebElement orgnameInSwithPage;

	public WebElement getOrgnameInSwithPage() {
		return orgnameInSwithPage;
	}

	
	public WebElement getTypeDropDwon() {
		return typeDropDwon;
	}

	public WebElement getIndustryDropDwon() {
		return industryDropDwon;
	}

	public WebElement getCreateorganization() {
		return createorganization;
	}
	Random r = new Random();
	public int ramdom = r.nextInt(1000);

	public WebElement getOraganizationname() {
		return oraganizationname;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	 
	
}
