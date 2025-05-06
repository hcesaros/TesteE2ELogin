package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By mensagemErro = By.cssSelector(".oxd-alert-content-text");
    By campoObrigatorio = By.cssSelector(".oxd-input-field-error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).clear();
        driver.findElement(password).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isMensagemCredenciaisInvalidasVisivel() {
        return driver.findElements(mensagemErro).size() > 0;
    }

    public boolean isMensagemCampoObrigatorioVisivel() {
        return driver.findElements(campoObrigatorio).size() > 0;
    }
}