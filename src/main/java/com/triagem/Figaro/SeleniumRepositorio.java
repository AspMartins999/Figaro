package com.triagem.Figaro;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class SeleniumRepositorio {
    private WebDriver driver;
    private WebDriverWait wait;

    private long time = 15;

    @Test
    public void login() throws InterruptedException {
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
    }
    public void teste2() throws InterruptedException {
        driver.navigate().to("https://pje1g.trf1.jus.br/pje/Processo/ConsultaProcesso/listView.seam");
        LocalDateTime hoje = LocalDateTime.now();
        String diadasemana= String.valueOf(hoje.getDayOfWeek());
        if (diadasemana=="MONDAY"){
            LocalDateTime sexta = hoje.minusDays(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String sextaformatado= sexta.format(formatter);
            String iddatasexta = "fPP:dataAutuacaoDecoration:dataAutuacaoInicioInputDate";
            String datasexta=sextaformatado;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(iddatasexta)));
            driver.findElement(By.id(iddatasexta)).sendKeys(datasexta);
        }else{
            LocalDateTime ontem = hoje.minusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String ontemformatado= ontem.format(formatter);
            String iddataontem = "fPP:dataAutuacaoDecoration:dataAutuacaoInicioInputDate";
            String dataontem=ontemformatado;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(iddataontem)));
            driver.findElement(By.id(iddataontem)).sendKeys(dataontem);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeformatado= hoje.format(formatter);
        String iddatahoje = "fPP:dataAutuacaoDecoration:dataAutuacaoFimInputDate";
        String datahoje=hojeformatado;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(iddatahoje)));
        driver.findElement(By.id(iddatahoje)).sendKeys(datahoje);
        String idnomeparte = "fPP:j_id150:nomeParte";
        String nomeparte="inss";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idnomeparte)));
        driver.findElement(By.id(idnomeparte)).sendKeys(nomeparte);
        String polopassivo="/html/body/div[6]/div/div/div/div[2]/form/div[1]/div/div/div[5]/div[2]/table/tbody/tr/td[2]/label";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(polopassivo)));
        driver.findElement(By.xpath(polopassivo)).click();
        Thread.sleep(5000);
        String pesquisar="fPP:searchProcessos";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pesquisar)));
        driver.findElement(By.id(pesquisar)).click();









    }
}
