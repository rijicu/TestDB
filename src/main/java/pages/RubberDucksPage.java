package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RubberDucksPage extends AbstractPage{

    @FindBy(className = "name")
    List<WebElement> duckNames;

    @FindBy(className = "regular-price")
    List<WebElement> duckRegularPrice;

    @FindBy(className = "price")
    List<WebElement> duckPrice;

    @FindBy(className = "campaign-price")
    List<WebElement> duckCampaignPrice;

    public List<String> getDuckNames() {
        List<String> duckNamesResult = new ArrayList<>();
        for(WebElement duckName : duckNames) {
            duckNamesResult.add(duckName.getText());
        }

        return duckNamesResult;
    }

    public List<Float> getDuckPrices() {
        List<Float> duckPricesResult = new ArrayList<>();
        for (WebElement duckRegPrice : duckRegularPrice) {
            duckPricesResult.add(Float.valueOf(duckRegPrice.getText().substring(1)));
        }

        for (WebElement duckPrice : duckPrice) {
            duckPricesResult.add(Float.valueOf(duckPrice.getText().substring(1)));
        }
        return duckPricesResult;
    }

    public List<Float> getDuckCampaignPrices() {
        List<Float> duckCampaignPricesResult = new ArrayList<>();
        for (WebElement duckCampaignPrice : duckCampaignPrice) {
            duckCampaignPricesResult.add(Float.valueOf(duckCampaignPrice.getText().substring(1)));
        }
        return duckCampaignPricesResult;
    }
}
