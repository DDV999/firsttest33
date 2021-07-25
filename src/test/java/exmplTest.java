import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class exmplTest {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//li[@class='kitt-top-menu__item kitt-top-menu__item_first']/a[contains(text(),'Страхование')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        driver.findElement(By.xpath("//a[contains(text(),'Все страховые программы')]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-test-id='Product_catalog_header']"))));

        assertEquals("Страхование",
                driver.findElement(By.xpath("//*[@data-test-id='Product_catalog_header']")).getText());

        WebElement element = driver.findElement(By.xpath("//*[@data-test-id='ProductCatalog_minicard_header'][contains(text(),'Страхование путешественников')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);


        driver.findElement(By.xpath("//*[@data-test-id='ProductCatalog_minicard_header'][contains(text(),'Страхование путешественников')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-test-id='PageTeaserDict_header'][contains(text(),'Страхование путешественников')]"))));

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@class='kitt-button__text'][contains(text(),'Оформить онлайн')]")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='Страхование путешественников']"))));
        Thread.sleep(1000);
        fillField(By.xpath("//*[@id='surname_vzr_ins_0']"),"Иванова");
        fillField(By.xpath("//*[@id='name_vzr_ins_0']"),"Ольга");
        fillField(By.xpath("//*[@id='birthDate_vzr_ins_0']"),"09.07.2021");


        driver.findElement(By.xpath("//*[@id='name_vzr_ins_0']")).click();
        Thread.sleep(1000);
        fillField(By.xpath("//*[@id='person_lastName']"),"Сергеев");
        fillField(By.xpath("//*[@id='person_firstName']"),"Иван");
        fillField(By.xpath("//*[@id='person_middleName']"),"Иванович");
        Thread.sleep(1000);
        fillField(By.xpath("//*[@id='person_birthDate']"),"09.07.2003");

        driver.findElement(By.xpath("//*[@id='person_middleName']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[contains(text(),'Мужской')]")).click();


        fillField(By.xpath("//*[@id='passportSeries']"),"1234");
        fillField(By.xpath("//*[@id='passportNumber']"),"123456");
        fillField(By.xpath("//*[@id='documentDate']"),"09.07.2019");
        driver.findElement(By.xpath("//*[@id='passportNumber']")).click();
        Thread.sleep(1000);
        fillField(By.xpath("//*[@id='documentIssue']"),"No name");
        Thread.sleep(13000);

        assertEquals("Сергеев", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("09.07.2003", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("123456", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("09.07.2019", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("No name", driver.findElement(By.id("documentIssue")).getAttribute("value"));


        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();
        assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//*[@class='alert-form alert-form-error']")).getText());
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//legend[text()='Контакты']/..//*[@class='invalid-validate form-control__message']")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


}