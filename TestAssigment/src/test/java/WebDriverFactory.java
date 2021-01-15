import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    WebDriver driver;
    String chromeDriverPath = "F:\\\\chromedriver_win32\\\\chromedriver.exe";
    String fireFoxDriverPath = "F:\\geckodriver-v0.28.0-win64\\geckodriver.exe";

    public WebDriver initialize(String driverName) {

        if (driverName == "chrome") {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            this.driver = new ChromeDriver();
            return this.driver;
        } else if (driverName == "firefox") {
            System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
            this.driver = new FirefoxDriver();
            return this.driver;
        }
        return null;
    }

}
