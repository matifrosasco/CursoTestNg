package com.proyecto;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListasDependientes {
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		WebDriver navegador = new ChromeDriver();
		navegador.get("https://www.codigopostal.gob.ec/");
		navegador.manage().window().maximize();
		navegador.findElement(By.xpath("/html/body/div[1]/section/div[4]/article[1]/div[1]/div[1]/div/p[1]/span/span/span/span")).click();
		Thread.sleep(3000);
		navegador.findElement(By.xpath("/html/body/div[5]/div/ul/li[19]")).click();
		Thread.sleep(3000);
		navegador.findElement(By.xpath("/html/body/div[1]/section/div[4]/article[1]/div[1]/div[1]/div/p[2]/span/span/span/span")).click();
		Thread.sleep(3000);
		navegador.findElement(By.xpath("/html/body/div[13]/div/ul/li[6]")).click();
	}

}
