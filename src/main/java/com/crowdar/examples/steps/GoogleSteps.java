package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.PHPTravelsHomePage;
//import com.crowdar.examples.pages.GoogleSearchResultPage;
import com.crowdar.examples.pages.PHPTravlesAboutPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class GoogleSteps extends PageSteps {

    @Given("The user is in home page")
    public void home() {
        Injector._page(PHPTravelsHomePage.class).go();
    }

    @When("The user go to About Us page")
    public void about() {
        Injector._page(PHPTravelsHomePage.class).clickAoutButton();

    }

    @Then("The About Us page is displayed")
    public void statVerfication() {
        Injector._page(PHPTravlesAboutPage.class).verificarAboutUsSection();

    }
}
