package com.veeva.step_definitions;


import com.github.javafaker.Faker;
import com.veeva.pages.ContactUsPage;
import com.veeva.utilities.BrowserUtils;
import com.veeva.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.Map;

public class ContactUs_StepDefs {
    ContactUsPage contactPage = new ContactUsPage();
    Faker faker;
    Actions actions;


    @Given("User is on the {string} page")
    public void user_is_on_the_page(String page) {
        page = "https://www.veeva.com/contact-us/";
        Driver.getDriver().get(page);
    }

    @When("User press on Contact Sales arrow")
    public void user_press_on_arrow() {
        contactPage.contactSalesDropdown.click();

    }

    @When("User fills out the form with valid details")
    public void user_fills_out_the_form_with_valid_details() {
        faker = new Faker();

        Select countryDropdown = new Select(contactPage.countrySelect);
        Select chooseAnAreaDropdown = new Select(contactPage.chooseAnAreaSelect);

        contactPage.firstNameInput.sendKeys(faker.name().firstName());
        contactPage.lastNameInput.sendKeys(faker.name().lastName());
        contactPage.companyInput.sendKeys(faker.company().name());
        contactPage.emailInput.sendKeys("bananaphone");
        contactPage.jobTitleInput.sendKeys(faker.job().title());
        contactPage.phoneInput.sendKeys(faker.phoneNumber().phoneNumber());

        countryDropdown.selectByIndex(1);
        chooseAnAreaDropdown.selectByVisibleText("Medical");

        contactPage.descriptionTextArea.sendKeys(faker.lorem().sentence(10));


    }

    @When("User submits the form")
    public void user_submits_the_form() {
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(contactPage.submitButton).perform();

        BrowserUtils.scrollToElement(contactPage.submitButton);
        contactPage.submitButton.click();


    }

    @Then("User should see a success message")
    public void user_should_see_a_success_message() {
        Assert.assertEquals("Must be valid email.\n" +
                "example@yourdomain.com", contactPage.message.getText());

    }


}
