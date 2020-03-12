package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.SeleniumActions;

public class HomePage extends SeleniumActions {


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private static WebElement Menu_Login;
	
	
	@FindBy(xpath = "//a[@title='Apply Loan Online']")
	private static WebElement Menu_Loan;
	
	@FindBy(xpath = "//a[@title='Apply Car Loan Online']")
	private static WebElement SubMenu_CarLoan;
	
	

	public void naviageToCarLoan() {
		isobjDisplayedWait(Menu_Loan);
		Actions atn = new Actions(_driver);
		atn.moveToElement(Menu_Loan).moveToElement(SubMenu_CarLoan).build().perform();
		SeleniumActions.ClickFeild(_driver, SubMenu_CarLoan);
	}
	
	public void naviageToLoginPage() {
		isobjDisplayedWait(Menu_Login);
		SeleniumActions.ClickFeild(_driver, Menu_Login);
	}
	
}