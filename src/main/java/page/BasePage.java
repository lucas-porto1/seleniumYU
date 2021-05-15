package page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarTricentis() {
        driver.get("http://sampleapp.tricentis.com/101/app.php");
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void escreve(String id_campo, String texto) {
        driver.findElement(By.id(id_campo)).clear();
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }

    public void clicar(String id_campo) {
        driver.findElement(By.id(id_campo)).click();
    }

    public void clicarXPath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }


    public void selecionarCombo(String id_campo, String valor) {
        WebElement element = driver.findElement(By.id(id_campo));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void esperar(String xpath){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    public void screenshot(){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            DateFormat dateFormatYear= new SimpleDateFormat("yyyy");
            DateFormat dateFormatMonth= new SimpleDateFormat("MMMM");
            DateFormat dateFormatDay= new SimpleDateFormat("dd");
            Date date = new Date();
            File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(image,new File("src/main/java/data/screenshots/"
                    +dateFormatYear.format(date)+
                    "/"+dateFormatMonth.format(date)+
                    "/"+dateFormatDay.format(date)+
                    "/"+dateFormat.format(date)+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


//        FileUtils.copyFile(image,new File("src/main/java/data/screenshots/step-"+dateFormat.format(date)+".png"));
