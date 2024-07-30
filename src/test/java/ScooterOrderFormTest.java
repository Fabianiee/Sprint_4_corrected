import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


    @RunWith(Parameterized.class)
    public class ScooterOrderFormTest extends BaseTest {

        // Поля класса
        // Kнопка заказа (сверху или снизу)
        private final String orderButton;
        // Имя
        private final String name;
        // Фамилия
        private final String surname;
        // Адрес доставки
        private final String address;
        // Номер телефона
        private final String phoneNumber;
        // Период аренды
        private final String rentalPeriod;
        // Цвет самоката
        private final String colour;
        // Комментарий
        private final String comment;
        // Результат
        private boolean actual;

        public ScooterOrderFormTest(String orderButton, String name, String surname, String address, String phoneNumber,
                                String rentalPeriod, String colour, String comment)
        {
            this.orderButton = orderButton;
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.rentalPeriod = rentalPeriod;
            this.colour = colour;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] getOrderFormData() {
            return new Object[][] {
                    {OrderButton.ORDER_BUTTON_ON_THE_TOP, "Светлана", "Иванова", "Москва", "79999999999", "сутки", "black", "1"},
                    {OrderButton.ORDER_BUTTON_ON_THE_BOTTOM, "Иван",
                            "Иванов",
                            "Москва, ул. Краснознаменская, дом 5 квартира 25",
                            "79995555555", "семеро суток", "grey",
                            "Без комментариев"
                                    + "Звоните заранее"
                    },
            };
        }

        // Проверяем весь флоу позитив
        @Test
        public void checkOrderScooterValidData_expectScooterIsOrdered() {
            super.implicitlyWait(3);

            MainPage mainPage = new MainPage(driver);
            mainPage.open();
            mainPage.clickOrderButton(orderButton);

            ScooterOrderForm scooterOrderForm = new ScooterOrderForm(driver);
            scooterOrderForm.fillOrderForm(name, surname, address, phoneNumber);
            scooterOrderForm.clickNextButton();

            RentPage rentPage = new RentPage(driver);
            rentPage.waitRentPageWillBeLoaded();
            rentPage.fillRequiredFields(rentalPeriod, colour, comment);
            rentPage.clickOrderButton();

            ConfirmQuestionField confirmQuestionField = new ConfirmQuestionField(driver);
            confirmQuestionField.clickConfirmButton();

            OrderCreationPage orderCreationPage = new OrderCreationPage(driver);
            actual = orderCreationPage.isSuccessOrderCreationMessageVisible();
            Assert.assertTrue("Expected: a message is displayed that the order was created successfully ",
                    actual);
        }
    }















