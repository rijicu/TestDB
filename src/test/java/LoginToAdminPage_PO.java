import org.junit.*;
import pages.AdminPanelPage;
import pages.LoginToAdminPage;
import utils.DriverFactory;
import utils.PropertyHelper;

public class LoginToAdminPage_PO {

    String appLink = PropertyHelper.getProperty("appAdminUrl");
    String username = PropertyHelper.getProperty("username");
    String password = PropertyHelper.getProperty("password");

    @Before
    public void setup() {
        DriverFactory.getDriver().get(appLink);
    }

    @Test
    public void loginToAdminPanel() {
        new LoginToAdminPage().loginAsUser(username, password);
    }

    @Test
    public void checkThatAdminPanelDirectoriesContainHeaders() {
        new LoginToAdminPage().loginAsUser(username, password);
        Assume.assumeNotNull();
        Assert.assertTrue(new AdminPanelPage().isHeaderPresent());
        new LoginToAdminPage().loginAsUser(username, password);
    }

    @After
    public void teardown() {
        DriverFactory.shutDownDriver();
    }
}