package basePackage;

import java.io.File;
import java.io.FileInputStream;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class SetUpTest extends SeleniumActions{

	@BeforeTest
	public static void BeforeTest() {
		try {
			File file = new File("./datafile.properties");
			FileInputStream fileInput = null;
			fileInput = new FileInputStream(file);
			prop.load(fileInput);	
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath") + "chromedriver.exe");
			_driver = new ChromeDriver();
			_driver.manage().window().maximize();
			_driver.manage().deleteAllCookies();
			_driver.get(prop.getProperty("AppURL"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	@AfterTest
	 public void AfterTest() {
	        _driver.close();
	 }
}
