package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleSearchResultPage extends PageBaseGoogle {

    private final String TITLO_RESULTADO_BUSQUEDA_XPATH = "/html/body/div[7]/div/div[9]/div[1]/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div[1]/a/h3";

    private WebElement stats() {
        return getWebElement(By.id("rcnt"));
    }

    public GoogleSearchResultPage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public String getStats() {
        //driver.findElement(By.xpath(TITLO_RESULTADO_BUSQUEDA_XPATH)).click();
        return stats().getText();
    }

}
