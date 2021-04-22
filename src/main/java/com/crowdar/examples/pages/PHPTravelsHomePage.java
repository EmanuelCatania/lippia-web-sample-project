package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class PHPTravelsHomePage extends PageBaseGoogle {



    private final String ABOUT_BUTTON_NAME = "/html/body/footer/div/div/div[6]/a[2]";

    public PHPTravelsHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }


    public void go() {
        navigateToCompleteURL();
    }


    public void clickAoutButton() {
        clickElement(By.xpath(ABOUT_BUTTON_NAME));
    }

}
