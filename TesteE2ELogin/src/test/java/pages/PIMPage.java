//Autor: Henrique Cesar
//Data: 06/05/2025

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {
    WebDriver driver;

    By addEmployeeBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a");
    By employeeForm = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirFormularioAddEmployee() {
        driver.findElement(addEmployeeBtn).click();
    }

    public boolean isFormularioAddEmployeeVisivel() {
        return driver.findElement(employeeForm).isDisplayed();
    }
}