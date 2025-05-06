//Autor: Henrique Cesar
//Data: 06/05/2025

package steps;

// Importações necessárias para o uso de anotações do Cucumber e ferramentas de automação
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import org.testng.Assert;
import pages.*;
import support.BaseTest;



/**
 * Classe de etapas (steps) usada pelo Cucumber para mapear os cenários descritos no arquivo .feature.
 * Realiza testes de login e navegação na aplicação OrangeHRM utilizando Selenium WebDriver.
 */
public class LoginSteps extends BaseTest {

    // Objetos das páginas utilizados nas etapas
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PIMPage pimPage;


    /**
     * Etapa que inicializa o WebDriver e abre a página de login do OrangeHRM.
     */
    @Dado("que o usuário está na página de login do OrangeHRM")
    public void acessarPaginaLogin() {
        initializeDriver(); // Método da classe BaseTest para inicializar o ChromeDriver
        driver.get("https://opensource-demo.orangehrmlive.com/"); // Acessa o site
        loginPage = new LoginPage(driver); // Instancia a página de login
    }

    /**
     * Etapa que executa o login com usuário e senha fornecidos via cenário.
     * @param usuario nome de usuário fornecido no cenário
     * @param senha senha fornecida no cenário
     */
    @Quando("ele faz login com usuário {string} e senha {string}")
    public void fazerLogin(String usuario, String senha) {
        loginPage.login(usuario, senha); // Executa o login com os dados
        dashboardPage = new DashboardPage(driver);
    }

    /**
     * Etapa que tenta fazer login com campos vazios.
     */
    @Quando("ele tenta fazer login sem preencher os campos")
    public void loginComCamposVazios() {
        loginPage.login("", ""); // Login com valores vazios
    }

    /**
     * Etapa que valida se o login foi bem-sucedido verificando se o Dashboard está visível.
     */
    @Entao("ele deve visualizar o Dashboard")
    public void validarDashboard() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard não visível após login.");
        driver.quit(); // Fecha o navegador após o teste
    }

    /**
     * Etapa que valida se uma mensagem de erro de credenciais inválidas é exibida.
     */
    @Entao("uma mensagem de erro de credenciais deve ser exibida")
    public void validarErroCredenciais() {
        Assert.assertTrue(loginPage.isMensagemCredenciaisInvalidasVisivel(), "Mensagem de erro não exibida.");
        driver.quit();
    }

    /**
     * Etapa que valida se a mensagem de campo obrigatório é exibida ao tentar logar com campos vazios.
     */
    @Entao("uma mensagem de erro de campos obrigatórios deve ser exibida")
    public void validarErroCamposObrigatorios() {
        Assert.assertTrue(loginPage.isMensagemCampoObrigatorioVisivel(), "Mensagem de campo obrigatório não exibida.");
        driver.quit();
    }

    /**
     * Etapa que realiza a navegação até o menu PIM e acessa o formulário de adicionar funcionário.
     */
    @Quando("ele navega até o menu PIM e seleciona Add Employee")
    public void navegarParaAddEmployee() {
        dashboardPage.navigateToPIM(); // Acessa o menu lateral PIM
        pimPage = new PIMPage(driver);
        pimPage.abrirFormularioAddEmployee(); // Clica em "Add Employee"
    }

    /**
     * Etapa que valida se o formulário de cadastro de novo funcionário foi carregado corretamente.
     */
    @Entao("o formulário de cadastro de funcionário deve ser exibido")
    public void validarFormularioFuncionario() {
        Assert.assertTrue(pimPage.isFormularioAddEmployeeVisivel(), "Formulário de funcionário não visível.");
        driver.quit();
    }
}
