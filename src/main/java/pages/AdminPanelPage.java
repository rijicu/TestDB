package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;

public class AdminPanelPage {

    @FindBy(id = "box-apps-menu")
    WebElement sideMenuContainer;

    @FindBy(xpath = "//span[text()='Appearence']")
    WebElement appearenceMenuItem;

    public boolean isHeaderPresent() {
        return isElementPresent(By.tagName("h1"));
    }

    private boolean isElementPresent(By locator) {
        return !DriverFactory.getDriver().findElements(locator).isEmpty();
    }
}