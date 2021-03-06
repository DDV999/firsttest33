import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import steps.BaseSteps;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MyRefactoringTest extends BaseSteps {

    @Test
    @Ignore
    public void newIncurenceTest(){
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Все страховые программы");

        new Insurance(driver).clickButton();
        new PageTravelInsurance(driver).clickButtonOnline();

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        new PageTravelInsurance(driver).clickButtonOnSite();
        String newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.switchTo().window(newWindow);

        new ChoosingPolicy(driver).clickButtonMin();
        new ChoosingPolicy(driver).clickButtonCheckout();
        new ChoosingPolicy(driver).clickButtonCheckout();

        Formalization formalization = new Formalization(driver);

        formalization.fillField("Имя","Дмитрий");
        formalization.fillField("Имя_","Дмитрий2");
        formalization.fillField("Фамилия","Иванов");
        formalization.fillField("Фамилия_","Иванов2");
        formalization.fillField("Отчество","Иванович");
        formalization.fillField("Дата рождения","09.07.2003");
        formalization.fillField("Дата рождения_","09.07.2021");
        formalization.clickSexM();
        formalization.fillField("Серия","1234");
        formalization.fillField("Номер","123456");
        formalization.fillField("Дата выдачи","09.07.2019");
        formalization.clickFieldNumber();
        formalization.fillField("Кем выдан","No name");

        assertEquals("Иванов", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Дмитрий", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("09.07.2003", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("123456", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("09.07.2019", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("No name", driver.findElement(By.id("documentIssue")).getAttribute("value"));


        formalization.clickButtonNext();
        assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//*[@class='alert-form alert-form-error']")).getText());
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//legend[text()='Контакты']/..//*[@class='invalid-validate form-control__message']")).getText());


    }
}
