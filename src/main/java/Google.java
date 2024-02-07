import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.OutputStream;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Google {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/konstantin/Downloads/chromium/chromedriver");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        ChromeDriverService service = ChromeDriverService.createDefaultService();
        service.sendOutputTo(OutputStream.nullOutputStream());
        WebDriver driver = new ChromeDriver(service, options);

        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a search query or 'q' to exit:");
        System.out.print("> ");
        while (!Objects.equals(input = scanner.nextLine(), "q")) {
            driver.get("https://www.google.com");
            WebElement searchBox = driver.findElement(By.name("q"));

            searchBox.sendKeys(input);

            WebElement button = driver.findElement(By.className("gNO89b"));
            button.submit();

            try {
                System.out.println(driver.findElement(By.cssSelector("[jscontroller=\"GCSbhd\"]")).findElements(By.tagName("span")).getFirst().getText());
            } catch (Exception ignored) {
            }
            try {
                System.out.println(driver.findElement(By.className("co8aDb")).getText());
                System.out.println(driver.findElement(By.className("i8Z77e")).getText());
            } catch (Exception ignored) {
            }
            System.out.println();
            driver.findElements(By.cssSelector("[jsname=\"UWckNb\"]"))
                    .forEach(x -> System.out.printf("%s\n%n", x.getAttribute("href")));
            System.out.print("> ");
        }
        driver.quit();
    }
}
