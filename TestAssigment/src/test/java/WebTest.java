import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class WebTest {

    WebDriver driver;
    private LinksPage linksPage;
    private WebDriverFactory driverInitializer;
    private String baseURL;


    @BeforeClass
    public void beforeClass() {
        baseURL = "https://www.links.hr/";
    }

    @BeforeTest
    public void setUp() {
        driverInitializer = new WebDriverFactory();
        this.driver = driverInitializer.initialize("chrome");
        linksPage = new LinksPage(driver);
        this.driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goToBaseUrl() {
        this.driver.navigate().to(baseURL);
    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(0,400)");
    }

    @Test(priority = 0)
    public void testBodyDisplayed() {
        Assert.assertTrue(linksPage.bodyTag().isDisplayed());
    }

    @Test(priority = 1)
    public void testSearchBox() throws InterruptedException {
        String item = "Mouse";
        linksPage.searchItemInTextBox(item);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().endsWith(item));
    }


    @Test(priority = 4)
    public void testQuickViewButton() throws InterruptedException {
        scroll();
        linksPage.clickQuickViewButton();
        Assert.assertTrue(linksPage.quickViewPopUp().isDisplayed());
        Thread.sleep(1000);
        linksPage.closeQuickViewPopUP();
    }

    @Test(priority = 5)
    public void testAddToCartButton() throws InterruptedException {
        scroll();
        linksPage.clickAddToCartButton();
        Thread.sleep(500);
        Assert.assertEquals(linksPage.numberOfItemsInCart(),"1");
    }

    @Test (priority = 2)
    public void testAutoComplete(){
        String partialItemName= "DeathAdder";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        linksPage.selectAutoCompleteSearchBox(partialItemName);
        Assert.assertTrue(linksPage.selectedItemName().getText().contains(partialItemName));
    }

    @Test(priority = 3)
    public void testDropDownButton() {
        String numberOfItems = "12";
        linksPage.chooseNumberOfItemsDisplayedDropDownButton(numberOfItems);
        linksPage.getNumberOfItemsDisplayed();
        Assert.assertEquals(numberOfItems, "12");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
