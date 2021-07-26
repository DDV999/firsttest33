package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Formalization extends MainPage {

    @FindBy(xpath = "//h2[text()='Страхование путешественников']")
    public WebElement title;

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surNameVsr;

    @FindBy(id = "name_vzr_ins_0")
    WebElement nameVsr;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement birthDateVsr;

    @FindBy(id = "person_lastName")
    WebElement personLastName;

    @FindBy(id = "person_firstName")
    WebElement personFirstName;

    @FindBy(id = "person_middleName")
    WebElement personMiddleName;

    @FindBy(id = "person_birthDate")
    WebElement personBirthDate;

    @FindBy(xpath = "//label[contains(text(),'Мужской')]")
    WebElement sexM;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(xpath = "//*[contains(text(),'Продолжить')]")
    WebElement next;



    public Formalization (WebDriver driver){
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver,10))
                .until(ExpectedConditions.visibilityOf(title));
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия_":
                fillField(surNameVsr, value);
                break;
            case  "Имя_":
                fillField(nameVsr, value);
                break;
            case  "Дата рождения_":
                fillField(birthDateVsr, value);
                break;
            case  "Имя":
                fillField(personFirstName, value);
                break;
            case  "Фамилия":
                fillField(personLastName, value);
                break;
            case  "Отчество":
                fillField(personMiddleName, value);
                break;
            case  "Дата рождения":
                fillField(personBirthDate, value);
                break;
            case  "Серия":
                fillField(passportSeries, value);
                break;
            case  "Номер":
                fillField(passportNumber, value);
                break;
            case  "Дата выдачи":
                fillField(documentDate, value);
                break;
            case  "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия_":
                return surNameVsr.getAttribute("value");
            case  "Имя_":
                return nameVsr.getAttribute("value");
            case  "Дата рождения_":
                return birthDateVsr.getAttribute("value");
            case  "Имя":
                return personFirstName.getAttribute("value");
            case  "Фамилия":
                return personLastName.getAttribute("value");
            case  "Отчество":
                return personMiddleName.getAttribute("value");
            case  "Дата рождения":
                return personBirthDate.getAttribute("value");
            case  "Серия":
                return passportSeries.getAttribute("value");
            case  "Номер":
                return passportNumber.getAttribute("value");
            case  "Дата выдачи":
                return documentDate.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void clickFieldNumber() {
        passportNumber.click();
    }

    public void clickButtonNext() {
        next.click();
    }

    public void clickSexM() {
        sexM.click();
    }

}
