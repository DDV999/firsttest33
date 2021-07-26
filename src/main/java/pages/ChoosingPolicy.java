package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoosingPolicy {
    @FindBy(xpath = "//*[contains(text(),'Минимальная')]")
    public WebElement buttonMin;

    @FindBy(xpath = "//*[contains(text(),'Оформить')]")
    public WebElement buttonCheckout;

    public ChoosingPolicy (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickButtonMin() {
        buttonMin.click();
    }

    public void clickButtonCheckout() {
        buttonCheckout.click();
    }
}
