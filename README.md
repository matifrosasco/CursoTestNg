Espacio para poner anotaciones: 
public class AnotacionesBase {
	
	@BeforeClass
	public void codigoAntesClase() {
		//Rutina de codigo antes de la clase
		System.out.println("Este codigo se ejecuta antes de la clase");
		
	}
	
	@AfterClass
	public void codigoDespuesClase(){
		//Rutina de codigo despues de la clase
		System.out.println("Este codigo se ejecuta despues de la clase");
		
	}
	
	@BeforeSuite
	//Rutina de codigo despues de la clase
	public void codigoSuite() {
		System.out.println("Este codigo se ejecuta antes de toda la suite");
	}
	
	@AfterSuite
	//Rutina de codigo despues de la clase
	public void codigoDespuesSuite() {
		System.out.println("Este codigo se ejecuta despues de toda la suite");
	}
	
	@BeforeMethod
	public void antesDelMetodo() {
		//Rutina de codigo que se ejecuta antes de cada metodo (test)
		System.out.println("Este codigo se ejecuta antes de cada Test");
	
	}
	
	@AfterMethod
	public void despuesDelMetodo() {
		//Rutina de codigo que se ejecuta antes de cada metodo (test)
		System.out.println("Este codigo se ejecuta despues de cada Test");
	
	}
	
	@Test
	public void pruebaUno() {
		//Rutina de codigo para correr la prueba, generalmente esta todo el codigo de selenium
		System.out.println("Esta es la prueba 1");
	}
	
