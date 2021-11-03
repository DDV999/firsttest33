package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Insurance {

    @FindBy(xpath = "//*[@data-test-id='ProductCatalog_minicard_header'][contains(text(),'Страхование путешественников')]")
    public WebElement buttonTravelInsurance;

    public Insurance(WebDriver driver) {

        PageFactory.initElements(driver, this);
        WebElement element = driver.findElement(By.xpath("//*[@data-test-id='ProductCatalog_minicard_header'][contains(text(),'Страхование путешественников')]"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.visibilityOf(buttonTravelInsurance));

    }

    public void clickButton(){
        buttonTravelInsurance.click();
    }
}
