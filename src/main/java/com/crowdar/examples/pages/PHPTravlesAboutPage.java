package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class PHPTravlesAboutPage extends PageBaseGoogle {

    SoftAssert sAssert = new SoftAssert();

    private final String ABOUT_TITLE_XPATH = "//h1[contains(text(),'About Us')]";
    private final String SUBTITLE_XPATH = "//p[contains(text(),'A reliable partner')]";
    private final String YEAR_LIST_XPATH = "//strong[contains(text(), '20')]";

    private WebElement stats() {
        return getWebElement(By.id("rcnt"));
    }

    public PHPTravlesAboutPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "/about-us/"; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public String getStats() {
        return stats().getText();
    }

    public void verificarAboutUsSection(){
        List<String> years = Arrays.asList("2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012");
        waitForElementVisibility(By.xpath(ABOUT_TITLE_XPATH));
        sAssert.assertTrue(getElementText(By.xpath(ABOUT_TITLE_XPATH)).equals("About Us"), "El titulo no es el correcto");
        waitForElementVisibility(By.xpath(SUBTITLE_XPATH));
        sAssert.assertTrue(getElementText(By.xpath(SUBTITLE_XPATH)).equals("A reliable partner and an expert in the area of online travel business applications!"), "El subtitulo no es el correcto");
        List<WebElement> listaYearsLocators = getWebElements(By.xpath(YEAR_LIST_XPATH));
        for (WebElement item: listaYearsLocators) {
            sleep(2000);
            scroll(item);
        }
        for (String year : years) {
            sAssert.assertTrue(listaYearsLocators.stream().anyMatch(object -> object.getText().contains(year)), "No se encuentra año: "+year);
        }
        sAssert.assertAll();
    }

    public void scroll(WebElement element) {
        JavascriptExecutor jse = this.driver;
        jse.executeScript("arguments[0].scrollIntoView()", new Object[]{element});
    }

}
