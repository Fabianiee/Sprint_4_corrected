import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterOrderForm {
    private final WebDriverWait wait;
    private WebDriver driver;

    public ScooterOrderForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Локаторы формы заказа:
    //поле для ввода имени
    private final By nameField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    //поле для ввода фамилии
    private final By surnameField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    // поле для ввода адреса
    private final By addressField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    // поле для выбора станции метро
    private final By metroStation = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    //полеа для ввода номера телефона
    private final By phoneField = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    //кнопка "Далее"
    private final By nextButton = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button");


    public void setName(String firstName) {
        driver.findElement(nameField).sendKeys(firstName);
    }

    public void setSurname(String secondName) {
        driver.findElement(surnameField).sendKeys(secondName);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void chooseMetroStation() {
        driver.findElement(metroStation).click();
        driver.findElement(metroStation).sendKeys(Keys.DOWN);
        driver.findElement(metroStation).sendKeys(Keys.ENTER);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillOrderForm(String nameField, String surnameField, String addressField, String metroStation, String phoneField, String deliveryDateField, String rentalPeriodField, String scooterColourField, String commentField) {
    }
}





