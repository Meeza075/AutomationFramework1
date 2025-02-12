package vtiger_ObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
	
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement createOrg;
	
	public WebElement getCreateOrg() {
		return createOrg;
	}

	@FindAll({@FindBy(xpath="//input[@type='submit']"), @FindBy(name="button")})
	private WebElement saveButton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orgAdd;

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrgAdd() {
		return orgAdd;
	}

}
