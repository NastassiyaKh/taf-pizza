import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TerraPizzaTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TerraPizzaPage.URL);
    }

    @Test
    public void testFillingCart() {
        driver.findElement(By.xpath(TerraPizzaPage.BUTTON_CLOSE_COOKIES)).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(TerraPizzaPage.BUTTON_PIZZA))).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(TerraPizzaPage.BUTTON_PIZZA_MARGARITA_IN_CART))).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(TerraPizzaPage.BUTTON_BASKET))).click();
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(TerraPizzaPage.LABEL_PIZZA_MARGARITA_IN_CART_ALL)));

        Assertions.assertEquals("Пицца Маргарита Классическая 32 см",driver.findElement(By.xpath(TerraPizzaPage.LABEL_PIZZA_MARGARITA_IN_CART)).getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
