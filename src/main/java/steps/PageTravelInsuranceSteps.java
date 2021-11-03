package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageTravelInsurance;

import java.util.Set;

public class PageTravelInsuranceSteps extends BaseSteps{
    @Step("Нажать на кнопку Оформить онлайн {0}")
    public void stepClickButtonOnline(){
        new PageTravelInsurance(driver).clickButtonOnline();
    }

    @Step("Нажать на кнопку Оформить на сайте {0}")
    public void stepClickButtonSite(){
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
    }
}
