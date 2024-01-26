package com.proyecto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Listas {
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe";
		public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		WebDriver driver=new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=contact");
        //Instanciando listas estaticas
        
        WebElement listaEstatica=driver.findElement(By.id("id_contact"));
        Select listaSeleccionada = new Select(listaEstatica);
        listaSeleccionada.selectByIndex(2);
        System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        listaSeleccionada.selectByVisibleText("Customer service");
        System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        listaSeleccionada.selectByValue("0");
        System.out.println(listaSeleccionada.getFirstSelectedOption().getText());
        Thread.sleep(3000);
   
	}
}
