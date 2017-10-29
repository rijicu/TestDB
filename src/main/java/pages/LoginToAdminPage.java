package pages;

import utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToAdminPage {

    @FindBy(name = "username")
    WebElement usernameControl;

    @FindBy(name = "password")
    WebElement passwordControl;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitButton;

    public LoginToAdminPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void loginAsUser(String username, String password) {
        usernameControl.sendKeys(username);
        passwordControl.sendKeys(password);
        submitButton.click();
    }
}