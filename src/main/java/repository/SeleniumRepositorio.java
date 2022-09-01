package repository;

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

import java.util.*;
import java.util.List;


public class SeleniumRepositorio<usuario> {
    String urlpesquisa = "https://pje1g.trf1.jus.br/pje/Processo/ConsultaProcesso/listView.seam";
    public WebDriver driver;
    public int z=1;

    private WebDriverWait wait;

    private long time = 15;


    public int login() throws InterruptedException, AWTException {
        String url = "https://pje1g.trf1.jus.br/";
        System.setProperty("webdriver.gecko.driver", "GeckoDriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile fxProfile = profile.getProfile("default");
        fxProfile.setPreference("browser.download.dir", "C:\\Utility\\Downloads");
        fxProfile.setPreference("browser.download.folderList", 2);
        fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        fxProfile.setPreference("browser.helperApps.neverAsk.openFile", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        fxProfile.setPreference("browser.download.manager.useWindow", false);
        fxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
        fxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
        fxProfile.setPreference("browser.download.manager.closeWhenDone", true);
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(fxProfile);
        driver = new FirefoxDriver(opt);

        driver.get(url);
        this.time = 15000;
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        String a = "/html/body/div[4]/div[2]/div[2]/div/div/div[2]/form/div[1]/input";
        String b = "41022777220";
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(a)));
        driver.findElement(By.xpath(a)).sendKeys(b);
        String c = "/html/body/div[4]/div[2]/div[2]/div/div/div[2]/form/div[2]/input";
        String d = "pjefederal01grau";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(a)));
        driver.findElement(By.xpath(c)).sendKeys(d);
        Thread.sleep(2000);
        String pesquisar = "btnEntrar";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pesquisar)));
        driver.findElement(By.id(pesquisar)).click();


        Thread.sleep(2000);


        automatização();
        return 1;
    }

    public String automatização() throws InterruptedException, AWTException {
        String urlpesquisa = "https://pje1g.trf1.jus.br/pje/Processo/ConsultaProcesso/listView.seam";
        driver.navigate().to(urlpesquisa);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String janelapadrao = driver.getWindowHandle();

      return janelapadrao;
    }



    public void entradadados(String filtropesquisa, String nome, int test){
        LocalDateTime hoje = LocalDateTime.now();
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
        String nomeparte = nome;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idnomeparte)));
        driver.findElement(By.id(idnomeparte)).sendKeys(nomeparte);
        String polopassivo = "/html/body/div[6]/div/div/div/div[2]/form/div[1]/div/div/div[5]/div[2]/table/tbody/tr/td[2]/label";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(polopassivo)));
        driver.findElement(By.xpath(polopassivo)).click();
        if(test==0) {
            String idclasse_judicial = "fPP:j_id257:classeJudicial";
            String classe_judicial = filtropesquisa;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idclasse_judicial)));
            driver.findElement(By.id(idclasse_judicial)).sendKeys(classe_judicial);
        }else {
            String assuntoid = "fPP:j_id248:assunto";
            String assunto = filtropesquisa;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(assuntoid)));
            driver.findElement(By.id(assuntoid)).sendKeys(assunto);
        }
            String pesquisar = "fPP:searchProcessos";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(pesquisar)));
        driver.findElement(By.id(pesquisar)).click();

    }
    public void pesquisa(String janelapadrao) throws InterruptedException, AWTException {
        String displayNone = "";
        System.out.println("Display none? " + displayNone );
        while (!displayNone.equals("display: none;")){
            displayNone = driver.findElement(By.id("_viewRoot:status.start")).getAttribute("style");
        }
        WebElement TabelaTref = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody"));
        List<WebElement> listaMovimentacao = new ArrayList<>(TabelaTref.findElements(By.cssSelector("tr")));
        for (int j = listaMovimentacao.size(); j > 0; j--) {
            Boolean isPresent = driver.findElements(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]")).size() > 0;
            System.out.println(isPresent);
            if (isPresent) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]")));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[1]")));
                driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[1]")).click();
                Thread.sleep(1500);
                System.setProperty("java.awt.headless", "false");
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_ENTER);
                Thread.sleep(2000);
                janeladownload(janelapadrao);


                driver.switchTo().window(janelapadrao);
            } else {
                driver.get(urlpesquisa) ;

            }

        }
    }
    public void pesquisaExceçoes(String janelapadrao) throws InterruptedException, AWTException {
        String displayNone = "";
        System.out.println("Display none? " + displayNone );
        while (!displayNone.equals("display: none;")){
            displayNone = driver.findElement(By.id("_viewRoot:status.start")).getAttribute("style");
        }
        WebElement TabelaTref = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody"));
        List<WebElement> listaMovimentacao = new ArrayList<>(TabelaTref.findElements(By.cssSelector("tr")));
        for (int j = listaMovimentacao.size(); j > 0; j--) {
            Boolean isPresent = driver.findElements(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]")).size() > 0;
            if (isPresent) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[5]")));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[5]")));
                String verifica = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[5]")).getText().toUpperCase();
                Set<String> exceões = new HashSet<String>(Arrays.asList(
                        "EXECUÇÃO FISCAL", "EMBARGOS À EXECUÇÃO FISCAL", "CARTA PRECATÓRIA", "CUMPRIMENTO DE SENTENÇA", "PROCEDIMENTO DE JUIZADO ESPECIAL"
                ));
                if(exceões.contains(verifica)){
                    j--;
                }else{
                    driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[" + j + "]/td[1]")).click();
                    Thread.sleep(1500);
                    System.setProperty("java.awt.headless", "false");
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    Thread.sleep(2000);
                    janeladownload(janelapadrao);
                    driver.switchTo().window(janelapadrao);
                }
            } else {
                driver.get(urlpesquisa) ;
            }
        }
    }
    public String data() {
        LocalDateTime hoje = LocalDateTime.now();
        String diadasemana = String.valueOf(hoje.getDayOfWeek());
        if (diadasemana.equals("MONDAY")) {
            LocalDateTime sexta = hoje.minusDays(3);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return sexta.format(formatter);
        } else {
            LocalDateTime ontem = hoje.minusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return ontem.format(formatter);

        }

    }

    public void janeladownload(String janelapadrao) throws InterruptedException, AWTException {
        Thread.sleep(1000);
        Set<String> janela = driver.getWindowHandles();
        for (String handle : janela) {
            if (!handle.equals(janelapadrao)) {
                driver.switchTo().window(handle);

                String spam = "detalheDocumento:primeiroDocumento";

                driver.findElement(By.id(spam)).click();

                Thread.sleep(500);
                String download = "detalheDocumento:download";
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(download)));
                wait.until(ExpectedConditions.elementToBeClickable(By.id(download)));
                Thread.sleep(1000);
                driver.findElement(By.id(download)).click();
                Thread.sleep(3000);
                System.setProperty("java.awt.headless", "false");
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_A + z);
                robot.keyPress(KeyEvent.VK_A  +z);
                z=z+1;
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_ENTER);

                Thread.sleep(2000);
                driver.close();



            }
        }
        Set<String> janela1 = driver.getWindowHandles();
        for (String handle1 : janela1) {
            if (!handle1.equals(janelapadrao)) {
                try {
                    driver.switchTo().window(handle1);
                    /*String download1 = "download";
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(download1)));
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(download1)));
                    Thread.sleep(3000);
                    driver.findElement(By.id(download1)).click();

                    System.setProperty("java.awt.headless", "false");
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyPress(KeyEvent.VK_ENTER);

                    Thread.sleep(2000);
                    */driver.close();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


    }
}
