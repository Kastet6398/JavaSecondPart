import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public static void main(String[] args) {
    // TODO: change path
    System.setProperty("webdriver.chrome.driver", "/home/konstantin/Downloads/chromium/chromedriver");

    WebDriver driver = new ChromeDriver();

    driver.get("http://example.com/");

    WebElement element = driver.findElement(By.tagName("a"));
    element.click();

}
