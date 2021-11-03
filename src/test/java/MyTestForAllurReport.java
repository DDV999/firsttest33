import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import steps.*;

import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MyTestForAllurReport extends BaseSteps {

    @DisplayName("Страхование")
    @Test
    public void testIncurance(){
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        MainSteps mainSteps = new MainSteps();
        InsuranceSteps insuranceSteps = new InsuranceSteps();
        PageTravelInsuranceSteps pageTravelInsuranceSteps = new PageTravelInsuranceSteps();
        ChoosingPolicySteps choosingPolicySteps = new ChoosingPolicySteps();
        FormalizationSteps formalizationSteps = new FormalizationSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Имя","Дмитрий");
        testData.put("Имя_","Дмитрий2");
        testData.put("Фамилия","Иванов");
        testData.put("Фамилия_","Иванов2");
        testData.put("Отчество","Иванович");
        testData.put("Дата рождения","09.07.2003");
        testData.put("Дата рождения_","09.07.2021");
        testData.put("Серия","1234");
        testData.put("Номер","123456");
        testData.put("Дата выдачи","09.07.2019");
        testData.put("Кем выдан","No name");

        mainSteps.stepClickMenu("Страхование");
        mainSteps.stepClickButtonSubMenu("Все страховые программы");
        insuranceSteps.stepClickButtonInsurace();
        pageTravelInsuranceSteps.stepClickButtonOnline();
        pageTravelInsuranceSteps.stepClickButtonSite();

        choosingPolicySteps.stepClickButtonMin();
        choosingPolicySteps.stepClickButtonCheckout();
        choosingPolicySteps.stepClickButtonCheckout();

        formalizationSteps.stepFillFields(testData);
        formalizationSteps.stepSelectSexM();

        assertEquals("Иванов1", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Дмитрий", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("09.07.2003", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("123456", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("09.07.2019", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("No name", driver.findElement(By.id("documentIssue")).getAttribute("value"));

        formalizationSteps.stepClickButtonNext();

        assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//*[@class='alert-form alert-form-error']")).getText());
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//legend[text()='Контакты']/..//*[@class='invalid-validate form-control__message']")).getText());
    }

}
