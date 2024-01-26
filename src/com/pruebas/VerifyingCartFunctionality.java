package com.pruebas;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyingCartFunctionality {
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		//Inicializar e instanciar el navegador
		WebDriver navegador = new ChromeDriver();
		navegador.get("https://winstoncastillo.com/robot-selenium/");
		navegador.manage().window().maximize();
		List<WebElement> objetoComparar = navegador.findElements(By.cssSelector("#common-home > div.alert.alert-success.alert-dismissible"));
		Assert.assertTrue(objetoComparar.isEmpty());
		navegador.findElement(By.cssSelector("#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(2)")).click();
		Thread.sleep(2000);
		String textoLogueoHome = navegador.findElement(By.cssSelector("#common-home > div.alert.alert-success.alert-dismissible")).getText();
		String textoFinal = textoLogueoHome.substring(0, 70);
		Assert.assertEquals("You must login or create an account to save MacBook Pro to your wish l", textoFinal);
		Assert.assertEquals(navegador.findElement(By.cssSelector("#cart > button")).getText() , "0 item(s) - $0.00");
		String precioConIva = navegador.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/p[2]")).getText();
		String [] precios = precioConIva.split("Ex", 2);
		String precio = "1 item(s) - " + precios[0].replaceAll(" ", "");
		navegador.findElement(By.cssSelector("#content > div.row > div:nth-child(1) > div > div.button-group > button:nth-child(1) > span")).click();
		Thread.sleep(5000);
		Assert.assertEquals(precio.replaceAll("\\s+", ""), navegador.findElement(By.cssSelector("#cart > button")).getText().replaceAll("\\s+", ""));
		//003 Verificar el carrito de compras.
		navegador.findElement(By.cssSelector("#cart-total")).click();
		String nombreProducto = navegador.findElement(By.cssSelector("#content > div.row > div:nth-child(1) > div > div.caption > h4 > a")).getText();
		System.out.println(nombreProducto);
		String nombreProductoEliminar = navegador.findElement(By.cssSelector("#cart > ul > li:nth-child(1) > table > tbody > tr > td.text-left > a")).getText();
		Assert.assertEquals(nombreProducto, nombreProductoEliminar);
		Thread.sleep(3000);
		navegador.findElement(By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(1) > strong")).click();
		Thread.sleep(3000);
		String carritoProductoUno = navegador.findElement(By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(2) > a")).getText();
		Assert.assertEquals(nombreProducto, carritoProductoUno);
		System.out.println(precios[0].replaceAll(" ", ""));
		String precioTotalCarrito = navegador.findElement(By.cssSelector("#content > div.row > div > table > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
		Assert.assertEquals(precios[0].replaceAll("\\s+", ""), precioTotalCarrito.replaceAll("\\s+", ""));
		navegador.close();
		
		
		
	}

}

