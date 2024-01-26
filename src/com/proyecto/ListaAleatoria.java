package com.proyecto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ListaAleatoria {
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe";
		public static void main(String[] args) throws InterruptedException {
			
		ChromeOptions notificaciones=new ChromeOptions();
		notificaciones.addArguments("--disable-notifications"); //eliminar anuncios, ventanas
		notificaciones.addArguments("--disable-extensions");
		
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		WebDriver driver=new ChromeDriver(notificaciones);
        driver.get("http://www.mercadolibre.com.ar");
        driver.findElement(By.className("nav-search-input")).sendKeys("Play");
        Thread.sleep(2000);
        List<WebElement> opciones = driver.findElements(By.className("sb-suggestions__list"));
        for(WebElement opcion:opciones) {
        	System.out.println(opcion.getText());
        	if(opcion.getText().contains("play 5")) {
        		opcion.click();
        		break;
        
        	}
        }
        Assert.assertEquals(driver.getTitle(), "Play 5 | MercadoLibre 📦");
	}
}
