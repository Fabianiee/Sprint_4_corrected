import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderForm {


    private WebDriver driver;

    // Локатор поля ввода имени
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // Локатор поля ввода фамилии
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Локатор поля ввода адреса
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор поля выбора станции метро
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    // Локатор поля ввода номера телефона
    private By phoneField =
            By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Локатор кнопки далее
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    public ScooterOrderForm(WebDriver driver) {
        this.driver = driver;
    }

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

    public void fillOrderForm(String name, String surname, String address, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        chooseMetroStation();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}


