package steps;

import io.qameta.allure.Step;
import pages.Formalization;

import java.util.HashMap;

public class FormalizationSteps extends BaseSteps{
    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String fieldName,String value){
        new Formalization(driver).fillField(fieldName, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("Нажать на кнопку Продолжить")
    public void stepClickButtonNext(){
        new Formalization(driver).clickButtonNext();
    }

    @Step("Выбрать пол Мужской")
    public void stepSelectSexM(){
        new Formalization(driver).clickSexM();
    }
}
