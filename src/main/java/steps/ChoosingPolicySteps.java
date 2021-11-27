package steps;

import io.qameta.allure.Step;
import pages.ChoosingPolicy;

public class ChoosingPolicySteps extends BaseSteps{
    @Step("Нажать на кнопку Минимальная")
    public void stepClickButtonMin(){
        new ChoosingPolicy(driver).clickButtonMin();
    }

    @Step("Нажать на кнопку Оформить")
    public void stepClickButtonCheckout(){
        new ChoosingPolicy(driver).clickButtonCheckout();
    }
}
