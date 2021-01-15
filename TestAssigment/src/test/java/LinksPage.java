import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LinksPage {
    private WebDriver driver;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement bodyTag() {WebElement element = driver.findElement(By.xpath("//body[@class=\"color-neutral notAndroid23\"]"));return element;}


    public WebElement searchTextBox() {return driver.findElement(By.name("q"));}
    public void searchItemInTextBox(String item) {WebElement textBox = searchTextBox();textBox.sendKeys(item);textBox.submit();}


    public WebElement quickViewButton() {return driver.findElement(By.cssSelector("div[class='quick-view-button']"));}
    public void clickQuickViewButton() {WebElement viewButton = quickViewButton();viewButton.click();}
    public WebElement quickViewPopUp() {return driver.findElement(By.xpath("//div[@class='k-overlay']"));}
    public WebElement quickViewPopUpClosingButton() {return driver.findElement(By.xpath("//div[@class='k-window-actions']/a"));}
    public void closeQuickViewPopUP() {quickViewPopUpClosingButton().click(); }

    public WebElement addToCartButton() {return driver.findElement(By.xpath("//li[@class=\"jcarousel-item jcarousel-item-horizontal jcarousel-item-1 jcarousel-item-1-horizontal\"]//button[@title=\"Dodaj\"]"));}
    public void clickAddToCartButton() {addToCartButton().click(); }
    public String numberOfItemsInCart() { return driver.findElement(By.cssSelector("span[class=\"cart-qty\"]")).getText(); }

    public WebElement autoCompleteFirstItem() {return driver.findElement(By.xpath("//ul[@id=\"ui-id-1\"]/li[1]/a"));}
    public void selectAutoCompleteSearchBox(String text) {WebElement textBox = searchTextBox();textBox.sendKeys(text);autoCompleteFirstItem().click();}
    public WebElement selectedItemName() {return driver.findElement(By.cssSelector("h1[itemprop=\"name\"]"));}


    public WebElement numberOfItemsDisplayedDropDownButton() {return driver.findElement(By.id("products-pagesize")); }
    public void chooseNumberOfItemsDisplayedDropDownButton(String number) {searchItemInTextBox("mouse");WebElement dropDownButton = numberOfItemsDisplayedDropDownButton();Select sel = new Select(dropDownButton);sel.selectByVisibleText(number);}
    public int getNumberOfItemsDisplayed() { List<WebElement> displayedItems = driver.findElements(By.xpath("//div[@class=\"item-grid\"]/div")); return displayedItems.size();}
}
