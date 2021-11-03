package steps;

import io.qameta.allure.Step;
import pages.PageTravelInsurance;

public class PageTravelInsuranceSteps extends BaseSteps{
    @Step("Нажать на кнопку Оформить онлайн {0}")
    public void stepClickButtonOnline(){
        new PageTravelInsurance(driver).clickButtonOnline();
    }

    @Step("Нажать на кнопку Оформить на сайте {0}")
    public void stepClickButtonSite(){
        new PageTravelInsurance(driver).clickButtonOnSite();
    }
}
