package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//nav[@id='site-menu']//a[contains(text(), 'Rubber Ducks')]")
    private WebElement ruberDucksLink;

    public RubberDucksPage openRubberDucksPage() {
        ruberDucksLink.click();

        return new RubberDucksPage();
    }
}