package vtiger_ObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInforamtionPage {

	public ContactInforamtionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'Information')]")
	private WebElement contactInformation;
	public WebElement getContactInformation() {
		return contactInformation;
	}
}
