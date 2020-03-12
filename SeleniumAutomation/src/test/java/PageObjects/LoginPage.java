package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.SeleniumActions;

public class LoginPage extends SeleniumActions {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user.email']")
	private static WebElement input_Username;

	@FindBy(xpath = "//button[@id='signInNative']")
	private static WebElement btn_Login;

	@FindBy(xpath = "(//button[text()='Continue'])[last()]")
	private static WebElement btn_Continue;

	public void Login() {

		try {
			isobjDisplayedWait(input_Username);
			SeleniumActions.EnterTextFeild(_driver, input_Username, prop.getProperty("username"));
			isobjDisplayedWait(btn_Login);
			ClickFeild(_driver, btn_Login);
			Thread.sleep(60000); // 60s wait to allow user to put OTP
			isobjDisplayedWait(btn_Continue);
			ClickFeild(_driver, btn_Continue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}