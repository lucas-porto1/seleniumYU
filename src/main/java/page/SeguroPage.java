package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Lucas Porto Gomes.
 */

public class SeguroPage extends BasePage {

    public SeguroPage(WebDriver driver) {
        super(driver);
    }

    public void enterVehicleData() {
        selecionarCombo("make","Volkswagen");
        selecionarCombo("model","Scooter");
        escreve("cylindercapacity","123");
        escreve("engineperformance","800");
        escreve("dateofmanufacture","08/08/2020");
        selecionarCombo("numberofseats","2");
        clicarXPath("//label[normalize-space()='No']");
        selecionarCombo("numberofseatsmotorcycle","2");
        selecionarCombo("fuel","Electric Power");
        escreve("payload","500");
        escreve("totalweight","700");
        escreve("listprice","15000");
        escreve("licenseplatenumber","99911");
        escreve("annualmileage","555");

    }

    public void enterInsurantData() {
        clicar("nextenterinsurantdata");
        escreve("firstname","Lucas");
        escreve("lastname","Porto");
        escreve("birthdate","08/01/1990");
        clicarXPath("//label[normalize-space()='Male']");
        escreve("streetaddress","Constantino");
        selecionarCombo("country","Austria");
        escreve("zipcode","08808080");
        escreve("city","São Paulo");
        selecionarCombo("occupation","Employee");
        clicarXPath("//label[normalize-space()='Skydiving']");
        escreve("website","github.com/lucas-porto1");

    }

    public void enterProductData() {
        clicar("nextenterproductdata");
        escreve("startdate","08/11/2022");
        selecionarCombo("insurancesum","35.000.000,00");
        selecionarCombo("meritrating","Super Bonus");
        selecionarCombo("damageinsurance","Full Coverage");
        clicarXPath("//label[normalize-space()='Euro Protection']");
        selecionarCombo("courtesycar","Yes");

    }

    public void selectPriceOption() {
        clicar("nextselectpriceoption");
        clicarXPath("//*[@id='pricePlans']//label[2]");
        esperar("//*[contains(text(),'View Quote')]");

    }

    public void sendQuote() {
        clicar("nextsendquote");
        escreve("email","testeqa@hotmail.com");
        escreve("phone","12312321");
        escreve("username","lucas");
        escreve("password","Lucas1");
        escreve("confirmpassword","Lucas1");
        escreve("Comments","Teste de automação.");

    }

    public void confirmationEmail(){
        clicar("sendemail");
        esperar("//button[normalize-space()='OK']");
        String texto = getText(By.xpath("//*[contains(text(),'Sending e-mail success!')]"));
        screenshot();
        Assert.assertEquals("Sending e-mail success!",texto);
    }
}