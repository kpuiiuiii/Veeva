package com.veeva.pages;

import com.veeva.utilities.Driver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    public ContactUsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(text(), 'Contact Sales')]")
    public WebElement contactSalesDropdown;

    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='Company']")
    public WebElement companyInput;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='Title']")
    public WebElement jobTitleInput;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement phoneInput;

    @FindBy(xpath = "//select[@id='Country']")
    public WebElement countrySelect;

    @FindBy(xpath = "//select[@id='areaofInterest']")
    public WebElement chooseAnAreaSelect;

    @FindBy(xpath = "//textarea[@id='MktoPersonNotes']")
    public WebElement descriptionTextArea;

    @FindBy(xpath = "//button[contains(text(), 'Request')]")
    public WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(), 'Must be valid email.')]")
    public WebElement message;

}
