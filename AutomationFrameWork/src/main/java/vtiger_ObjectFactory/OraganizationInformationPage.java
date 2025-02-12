package vtiger_ObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationInformationPage {
    public OraganizationInformationPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
   // @FindBy(xpath = "//span[contains(text(),'Organization')]")
    @FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInformation;
    
	public WebElement getOrganizationInformation() {
		return organizationInformation;
	}
}
