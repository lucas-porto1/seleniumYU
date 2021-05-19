package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.BasePage;
import page.SeguroPage;


public class SeguroSteps {
    public WebDriver driver;
    public SeguroPage page;
    public BasePage base;


    @Before
    public void start() {
        if(driver==null) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        page = new SeguroPage(driver);
        base = new BasePage(driver);
    }

    @After
    public void end() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterStep
    public void takeScreenshot(){
        base.screenshot();
    }

    @Dado("que estou na página de verificação de seguro")
    public void queEstouNaPáginaDeVerificaçãoDeSeguro() {
        base.acessarTricentis();
    }

    @Quando("eu preencho o formulário de informações do veículo")
    public void euPreenchoOFormulárioDeInformaçõesDoVeículo() {
        page.enterVehicleData();
    }

    @E("preencho o formulário de informações do seguro")
    public void preenchoOFormulárioDeInformaçõesDoSeguro() {
        page.enterInsurantData();
    }

    @E("preencho o formulário de informações do produto")
    public void preenchoOFormulárioDeInformaçõesDoProduto() {
        page.enterProductData();
    }

    @E("seleciono o valor do produto")
    public void selecionoOValorDoProduto() {
        page.selectPriceOption();
    }

    @E("envio um comentário")
    public void envioUmComentário() {
        page.sendQuote();
    }

    @Então("eu recebo a mensagem de confirmação")
    public void euReceboAMensagemDeConfirmação() {
        page.confirmationEmail();
    }
}
