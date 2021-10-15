package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class acessarModal {
    private WebDriver navegador;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deisee\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();

        navegador.get("https://site.getnet.com.br/");
        navegador.manage().window().maximize();
    }

    @Test
    public void testAcessarModal() {
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.findElement(By.id("u-depth1__item-15214")).click();
        navegador.findElement(By.id("u-depth3__item-15218")).click();

        navegador.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/a[5]"))
                .click();

        WebElement question = navegador.findElement(By.xpath("/html/body/div[2]/div/section/div[2]/a[1]"));
        String textQuestion = question.getText();
        assertEquals("Como posso acompanhar a entrega da minha SuperGet?",textQuestion);

    }

    @After
    public void tearDown() {
        navegador.close();
    }

}
