package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class PageTravelInsurance extends BaseSteps {
    @FindBy(xpath = "//*[@class='kitt-button__text'][contains(text(),'Оформить онлайн')]")
    public WebElement buttonCheckoutOnline;
    @FindBy(xpath = "//*[@class='kitt-button__text'][contains(text(),'Оформить на сайте')]")
    public WebElement buttonCheckoutOnSite;

    public PageTravelInsurance (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickButtonOnline() {
        buttonCheckoutOnline.click();
    }

    public void clickButtonOnSite() {
        buttonCheckoutOnSite.click();
    }

}
