package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps extends BaseSteps {
    @Step("Нажать на кнопку Меню")
    public void stepClickMenu(String menuItem){
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("Нажать на кнопку подменю")
    public void stepClickButtonSubMenu(String menuItem){
        new MainPage(driver).selectSubMenu(menuItem);
    }
}
