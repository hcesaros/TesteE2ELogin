//Autor: Henrique Cesar
//Data: 06/05/2025

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    By menuPIM = By.xpath("//aside[@class='oxd-sidepanel']//li[2]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        return driver.findElement(dashboardTitle).isDisplayed();
    }

    public void navigateToPIM() {
        driver.findElement(menuPIM).click();
    }
}