package steps;

import io.qameta.allure.Step;
import pages.Insurance;

public class InsuranceSteps extends BaseSteps{
    @Step("Нажать на кнопку Страхование путешественников {0}")
    public void stepClickButtonInsurace(){
        new Insurance(driver).clickButton();
    }
}
