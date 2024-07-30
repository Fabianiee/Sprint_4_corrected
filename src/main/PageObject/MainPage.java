import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    // Главная страница сайта https://qa-scooter.praktikum-services.ru

    // Локатор кнопки заказа самоката сверху
    private final By topOrderButton =
            By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // Локатор кнопки заказа самоката снизу
    private final By bottomOrderButton =
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }
    // Клик по верхней или нижней кнопке заказа самоката
    public void clickOrderButton(String orderButton) {
        if (orderButton.equals(OrderButton.ORDER_BUTTON_ON_THE_TOP)) {
            driver.findElement(topOrderButton).click();
        } else if (orderButton.equals(OrderButton.ORDER_BUTTON_ON_THE_BOTTOM)) {
            // Скролл до кнопки
            WebElement lowerOrderButton = driver.findElement(bottomOrderButton);
            ((JavascriptExecutor)driver).
                    executeScript("arguments[0].scrollIntoView();", lowerOrderButton);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(bottomOrderButton));
            lowerOrderButton.click();
        }
    }
    public String dropDownTest(int index) {
        By question = By.id(String.format("accordion__heading-%s", index));
        WebElement questionElement = driver.findElement(question);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(question));
        questionElement.click();
        return  questionElement.getText();
    }
    public String answerDisplayed(int index) {
        WebElement answerElement = driver.findElement(By.id(String.format("accordion__panel-%s", index)));
        return answerElement.getText();
    }

    public void acceptCookies(WebDriver driver) {
    }

    public void clickOrderButton(WebDriver driver, boolean b) {
    }
}



