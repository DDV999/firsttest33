package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@class='kitt-top-menu__list kitt-top-menu__list_icons kitt-top-menu__list_center']")
    WebElement mainMenu;

    @FindBy(xpath = "//*[contains(text(),'Страхование')]/../div[@class='kitt-top-menu__dropdown kitt-top-menu__dropdown_icons']")
    WebElement subMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public MainPage() {
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(".//*[contains(text(),'" + menuItem + "')]")).click();
    }

    public void selectSubMenu(String menuItem) {
        mainMenu.findElement(By.xpath(".//*[contains(text(),'" + menuItem + "')]")).click();
    }
}
