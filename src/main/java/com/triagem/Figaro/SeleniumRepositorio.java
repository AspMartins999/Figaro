package com.triagem.Figaro;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class SeleniumRepositorio<usuario> {
    private WebDriver driver;
    private WebDriverWait wait;

    private long time = 15;

    @Test
    public int login(int usuario) throws InterruptedException {
        String url = "https://pje1g.trf1.jus.br/";
        System.setProperty("webdriver.gecko.driver", "GeckoDriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        this.time = 15000;
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        String a = "/html/body/div[4]/div[2]/div[2]/div/div/div[2]/form/div[1]/input";
        String b="41022777220";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(a)));
        driver.findElement(By.xpath(a)).sendKeys(b);
        String c = "/html/body/div[4]/div[2]/div[2]/div/div/div[2]/form/div[2]/input";
        String d="pjefederal01grau";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(a)));
        driver.findElement(By.xpath(c)).sendKeys(d);
        Thread.sleep(4000);
        String pesquisar="btnEntrar";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pesquisar)));
        driver.findElement(By.id(pesquisar)).click();
        Thread.sleep(5000);
        teste2();
    return 1; }
    public void teste2() throws InterruptedException {
        driver.navigate().to("https://pje1g.trf1.jus.br/pje/Processo/ConsultaProcesso/listView.seam");

        LocalDateTime hoje = LocalDateTime.now();
        String iddatahoje = "fPP:dataAutuacaoDecoration:dataAutuacaoFimInputDate";
        String iddatasexta = "fPP:dataAutuacaoDecoration:dataAutuacaoInicioInputDate";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeformatado= hoje.format(formatter);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(iddatasexta)));
        driver.findElement(By.id(iddatasexta)).sendKeys(data());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(iddatahoje)));
        driver.findElement(By.id(iddatahoje)).sendKeys(hojeformatado);
        String idnomeparte = "fPP:j_id150:nomeParte";
        String nomeparte="inss";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idnomeparte)));
        driver.findElement(By.id(idnomeparte)).sendKeys(nomeparte);
        String polopassivo="/html/body/div[6]/div/div/div/div[2]/form/div[1]/div/div/div[5]/div[2]/table/tbody/tr/td[2]/label";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(polopassivo)));
        driver.findElement(By.xpath(polopassivo)).click();
        //String idnomeparte1="fPP:j_id257:classeJudicial";
        //String nomeparte1="Ação Civil Pública";
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idnomeparte1)));
        //driver.findElement(By.id(idnomeparte1)).sendKeys(nomeparte1);
        Thread.sleep(5000);
        String pesquisar="fPP:searchProcessos";
        driver.findElement(By.id(pesquisar)).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pesquisar)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[1]")).click();

        Thread.sleep(4000);
        String spam="/html/body/div[2]/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/form[1]/div[2]/div[1]/div[5]/div[2]/div[1]/ul/li[1]/a/span";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(spam)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(spam)));
        driver.findElement(By.xpath(spam)).click();

        String download = "/html/body/div[2]/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/form[2]/div[3]/div[2]/div[3]/ul/li[3]/a/i";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(download)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(download)));
        driver.findElement(By.xpath(download)).click();
        //driver.findElement(By.xpath(download)).sendKeys(Keys.ENTER);


    }
    public String data()  {
        LocalDateTime hoje = LocalDateTime.now();
        String diadasemana= String.valueOf(hoje.getDayOfWeek());
        if (diadasemana.equals("MONDAY")){
            LocalDateTime sexta = hoje.minusDays(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String sextaformatado= sexta.format(formatter);

            return sextaformatado;
        }else{
            LocalDateTime ontem = hoje.minusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String ontemformatado= ontem.format(formatter);
           return ontemformatado;
        }

    }
}
