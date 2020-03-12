package basePackage;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import PageObjects.CarLoanApp;
import PageObjects.HomePage;
import PageObjects.LoginPage;


public class SeleniumActions {

	public static WebDriver _driver;
	public static Properties prop = new Properties();
	public static ITestResult result;

	public static CarLoanApp carLoanApp;
	public static LoginPage loginPage;
	public static HomePage homePage;



	public static void dropDownSelection(WebElement DrpdwnEle, String drpDwonOptionValue) {

		List<WebElement> deductibelDrpdwnList = DrpdwnEle.findElements(By.tagName("option"));
		for (WebElement we : deductibelDrpdwnList) {
			String drpText = we.getText();
			if (drpText.contains(drpDwonOptionValue)) {
				we.click();
				break;
			}
		}
	}

	public static boolean isobjDisplayed(WebElement obj) {
		try {
			if (obj.isEnabled())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static boolean EnterTextFeild(WebDriver driver, WebElement Obj, String Value) {
		try {
			if (isobjDisplayed(Obj)) {
				Obj.clear();
				Obj.sendKeys(Value);
				return true;
			} else {

				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();

			return false;
		}
	}

	public static boolean ClickFeild(WebDriver _driver, WebElement Obj) {
		try {
			if (isobjDisplayed(Obj)) {
				((JavascriptExecutor) _driver).executeScript("arguments[0].click();", Obj);
				return true;
			} else
				return false;
		} catch (NoSuchElementException exception) {
			return false;
		}
	}
	
	public static boolean isobjDisplayedWait(WebElement obj){
		try{
		int t = Integer.parseInt(prop.getProperty("ExplicitWait"));
		WebDriverWait wait = new WebDriverWait(_driver, Long.valueOf(t));
		
		WebElement we = wait.until(ExpectedConditions.elementToBeClickable(obj));
		if(we.isEnabled())
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	    return false;
	}

}
