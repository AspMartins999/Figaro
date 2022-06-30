package com.triagem.Figaro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import java.time.Duration;

//   
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class SeleniumRepositorio<usuario> {
    public  WebDriver driver;

    private WebDriverWait wait;

    private long time = 15;


    public void login() throws InterruptedException, AWTException {
        String url = "https://pje1g.trf1.jus.br/";
        System.setProperty("webdriver.gecko.driver", "GeckoDriver.exe");
        ProfilesIni profile= new ProfilesIni();
        FirefoxProfile fxProfile=profile.getProfile("automationprofile");
        fxProfile.setPreference("browser.download.dir", "C:\\Utility\\Downloads");
        fxProfile.setPreference("browser.download.folderList",2);
        fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        fxProfile.setPreference("browser.helperApps.neverAsk.openFile","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        fxProfile.setPreference("browser.download.manager.useWindow", false);
        fxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
        fxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
        fxProfile.setPreference("browser.download.manager.closeWhenDone", true);
        FirefoxOptions opt= new FirefoxOptions();
        opt.setProfile(fxProfile);
        driver = new FirefoxDriver(opt);

        driver.get(url);
        this.time = 15000;
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        String a = "/html/body/div[4]/div[2]/div[2]/div/div/div[2]/form/div[1]/input";
        String b="41022777220";
        driver.manage().window().maximize();
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
    public void teste2() throws InterruptedException, AWTException {
        String urlpesquisa= "https://pje1g.trf1.jus.br/pje/Processo/ConsultaProcesso/listView.seam";
        driver.navigate().to(urlpesquisa);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String janelapadrao = driver.getWindowHandle();
        pesquisa(janelapadrao,urlpesquisa) ;

        }
    public String pesquisa(String janelapadrao, String urlpesquisa) throws InterruptedException, AWTException {
        LocalDateTime hoje = LocalDateTime.now();
        for(int i=0;i<4;i++) {
            driver.get(urlpesquisa);
            String iddatahoje = "fPP:dataAutuacaoDecoration:dataAutuacaoFimInputDate";
            String iddatasexta = "fPP:dataAutuacaoDecoration:dataAutuacaoInicioInputDate";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String hojeformatado = hoje.format(formatter);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(iddatasexta)));
            driver.findElement(By.id(iddatasexta)).sendKeys(data());
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(iddatahoje)));
            driver.findElement(By.id(iddatahoje)).sendKeys(hojeformatado);
            String idnomeparte = "fPP:j_id150:nomeParte";
            String nomeparte = "inss";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idnomeparte)));
            driver.findElement(By.id(idnomeparte)).sendKeys(nomeparte);
            String polopassivo = "/html/body/div[6]/div/div/div/div[2]/form/div[1]/div/div/div[5]/div[2]/table/tbody/tr/td[2]/label";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(polopassivo)));
            driver.findElement(By.xpath(polopassivo)).click();
            String idnomeparte1="fPP:j_id257:classeJudicial";
            String nomeparte1=classejudicial(i);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idnomeparte1)));
            driver.findElement(By.id(idnomeparte1)).sendKeys(nomeparte1);

            String pesquisar = "fPP:searchProcessos";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pesquisar)));
            driver.findElement(By.id(pesquisar)).click();
            Thread.sleep(5000);
            System.out.println("to vivo");
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tfoot/tr/td/div")));
            //driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tfoot/tr/td/div"));
            WebElement TabelaTref = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tfoot/tr/td/div"));
            List<WebElement> listaMovimentacao = new ArrayList<>(TabelaTref.findElements(By.cssSelector("tr")));
            for (int j = listaMovimentacao.size(); j > 0; j--) {
                Boolean isPresent= driver.findElements(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]")).size() > 0;
                System.out.println(isPresent);
              if(isPresent) {
                  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]")));
                  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[1]")));
                  driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[1]")).click();
                  Thread.sleep(1500);
                  System.setProperty("java.awt.headless", "false");
                  try {
                      Robot robot = new Robot();
                      robot.keyPress(KeyEvent.VK_ENTER);
                      robot.keyPress(KeyEvent.VK_ENTER);
                  }catch (Exception e){
                      System.out.println(e);
                  }
                  Thread.sleep(5000);
                  janeladownload(janelapadrao);
                  driver.switchTo().window(janelapadrao);
              }else{
                  System.out.println("cheguei aqui");
                  driver.get(urlpesquisa);

              }

            }

        }
        return janelapadrao;
    }



    public String data()  {
        LocalDateTime hoje = LocalDateTime.now();
        String diadasemana= String.valueOf(hoje.getDayOfWeek());
        if (diadasemana.equals("MONDAY")){
            LocalDateTime sexta = hoje.minusDays(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return sexta.format(formatter);
        }else{
            LocalDateTime ontem = hoje.minusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return ontem.format(formatter);

        }

    }
    public String classejudicial(int i) {
        if (i == 0) {
            return "Ação Civil Pública";
        } else if (i == 1) {
            return "Ação Coletiva";

        } else if (i == 2) {
            return "Mandado de Segurança Coletivo";

        } else {
            return "Ação Popular";
        }
    }

        public void janeladownload(String janelapadrao) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        Set<String> janela = driver.getWindowHandles();
        for (String handle : janela) {
            if (!handle.equals(janelapadrao)) {
                driver.switchTo().window(handle);

                String spam = "/html/body/div[2]/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/form[1]/div[2]/div[1]/div[10]/div[2]/div[1]/ul/li[1]/a/span";
                Thread.sleep(2000);
                driver.findElement(By.xpath(spam)).click();
                //String spam2 = "/html/body/div[2]/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/form[2]/div[3]/div[2]/div[2]/ul/li[4]/a";
                Thread.sleep(2000);
                //driver.findElement(By.xpath(spam2)).click();
                driver.switchTo().frame(0);
                String download = "download";
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(download)));
                wait.until(ExpectedConditions.elementToBeClickable(By.id(download)));
                Thread.sleep(4000);
                driver.findElement(By.id(download)).click();
                Thread.sleep(3000);
                System.setProperty("java.awt.headless", "false");
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyPress(KeyEvent.VK_ENTER);
                }catch (Exception e){
                    System.out.println(e);
                }

               // robot.keyPress(KeyEvent.VK_CONTROL + KeyEvent.VK_B);
                //Thread.sleep(2000);
                driver.close();

            }
        }


    }
}




