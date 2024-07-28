import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    //Объявляем переменную драйвера
    protected WebDriver driver;
    protected void implicitlyWait(int i) {
    }

    @Before
    public void setUp() {
        // Инициализируйте WebDriver здесь
        driver = new ChromeDriver(); // Пример с ChromeDriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Другие операции настройки
    }


    @After
    public void tearDown() {

            driver.quit();
        }
    }


