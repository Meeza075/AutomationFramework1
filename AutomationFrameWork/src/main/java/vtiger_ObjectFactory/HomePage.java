package vtiger_ObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Contacts")
	private WebElement contact;
	
	@FindBy(linkText="Organizations")
	private WebElement organization;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;

	public WebElement getContact() {
		return contact;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	
	

}
