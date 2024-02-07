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

public class Ebay {
    private static void printSearchResults(WebDriver driver) {
        driver.findElements(By.cssSelector(".s-item.s-item__pl-on-bottom")).forEach(e -> {
            if (!Objects.equals(e.findElement(By.tagName("a")).getAttribute("href"), "https://ebay.com/itm/123456?hash=item28caef0a3a:g:E3kAAOSwlGJiMikD&amdata=enc%3AAQAHAAAAsJoWXGf0hxNZspTmhb8%2FTJCCurAWCHuXJ2Xi3S9cwXL6BX04zSEiVaDMCvsUbApftgXEAHGJU1ZGugZO%2FnW1U7Gb6vgoL%2BmXlqCbLkwoZfF3AUAK8YvJ5B4%2BnhFA7ID4dxpYs4jjExEnN5SR2g1mQe7QtLkmGt%2FZ%2FbH2W62cXPuKbf550ExbnBPO2QJyZTXYCuw5KVkMdFMDuoB4p3FwJKcSPzez5kyQyVjyiIq6PB2q%7Ctkp%3ABlBMULq7kqyXYA")) {
                System.out.println("--------------------------------");
                System.out.println(STR."Link: \{e.findElement(By.tagName("a")).getAttribute("href")}");
                System.out.println(STR."Name: \{e.findElement(By.cssSelector("[role='heading'")).getText()}");
                System.out.println(STR."Price: \{e.findElement(By.className("s-item__price")).getText()}");
            }
        });
    }
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
            driver.get("https://www.ebay.com/");
            WebElement searchBox = driver.findElement(By.name("_nkw"));
            WebElement button = driver.findElement(By.id("gh-btn"));
            searchBox.sendKeys(input);

            button.submit();

            printSearchResults(driver);

            System.out.println("To go to next page, type 'n'. Type 'q' to enter another search query.");
            System.out.print("> ");
            while (!Objects.equals(input = scanner.nextLine(), "q")) {
                if (input.equals("n")) {
                    driver.get(driver.findElement(By.className("pagination__next")).getAttribute("href"));
                    printSearchResults(driver);
                    System.out.println("To go to next page, type 'n'. Type 'q' to enter another search query.");
                    System.out.print("> ");
                } else {
                    System.out.println("Please enter a correct command. Use 'n' to view the next page or 'q' to enter another search query.");
                    System.out.print("> ");
                }
            }
            System.out.println("Enter a search query or 'q' to exit:");
            System.out.print("> ");
        }
        driver.quit();
    }
}
