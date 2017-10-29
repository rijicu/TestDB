import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.RubberDucksPage;
import utils.DBHelper;
import utils.DriverFactory;
import utils.PropertyHelper;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class DucksNamesTest {

    private final String APPLINK = PropertyHelper.getProperty("addUserUrl");

    @Before
    public void setup() {
        DriverFactory.getDriver().get(APPLINK);
    }

    @After
    public void tearDown() {
        DriverFactory.shutDownDriver();
    }

    @Test
    public void duckNamesShouldBeEqualToDB() throws SQLException {
        List<String> duckNamesFromUI = new MainPage()
                .openRubberDucksPage()
                .getDuckNames();

        List<String> duckNamesFromDB = DBHelper.getProductNames();

        Collections.sort(duckNamesFromDB);
        Collections.sort(duckNamesFromUI);

        assertEquals(duckNamesFromDB, duckNamesFromUI);
    }

    @Test
    public void checkDuckCount() throws SQLException {
        System.out.println(DBHelper.getProducts().size());
    }

    @Test
    public void duckPricesShouldBeEqualsToDB() throws SQLException {
        List<Float> duckPricesFromUI = new MainPage()
                .openRubberDucksPage()
                .getDuckPrices();

        List<Float> duckPriceFromDB = DBHelper.getProductsPrice();

        Collections.sort(duckPriceFromDB);
        Collections.sort(duckPricesFromUI);

        assertEquals(duckPriceFromDB, duckPricesFromUI);

    }

    @Test
    public void duckCampaignPricesShouldBeEqualsToDB() throws SQLException{
        List<Float> duckCampaignPricesFromUI = new MainPage()
                .openRubberDucksPage()
                .getDuckCampaignPrices();

        List<Float> duckCampaignPricesFromDB = DBHelper.getProductsCampaignPrice();

        assertEquals(duckCampaignPricesFromDB, duckCampaignPricesFromUI);
    }
}