package com.proyecto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioCheckButtons {
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		WebDriver navegador = new ChromeDriver();
		navegador.get("https://winstoncastillo.com/robot-selenium/index.php?route=account/register");
		navegador.findElement(By.cssSelector("#content > form > fieldset:nth-child(3) > div > div > label:nth-child(1) > input[type=radio]")).click();
		Assert.assertFalse(navegador.findElement(By.cssSelector("#content > form > fieldset:nth-child(3) > div > div > label:nth-child(2) > input[type=radio]")).isSelected());
		//con assert verificamos si la prueba es true o false ( si el elemento esta seleccionado en yes or no )
		Assert.assertFalse(navegador.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).isSelected());
	}

}
