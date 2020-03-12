package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.SeleniumActions;

public class CarLoanApp extends SeleniumActions{
	
	public CarLoanApp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='NEW']")
	private static WebElement rb_NewCar;
	
	@FindBy(xpath = "//input[@value='OLD']")
	private static WebElement rb_OldCar;
	
	@FindBy(xpath = "//div[contains(@class,'ControlNext')]")
	private static WebElement slider_Next;
	
	@FindBy(xpath = "//input[@placeholder='Select model']")
	private static WebElement input_SelectModel;
	
	@FindBy(xpath = "//input[@placeholder='ENTER MODEL NAME']")
	private static WebElement input_EnterModelName;
	
	@FindBy(xpath = "//input[@placeholder='Select city']")
	private static WebElement input_SelectCity;

	@FindBy(xpath = "//input[@placeholder='ENTER CITY NAME']")
	private static WebElement input_EnterCityName;
	
	@FindBy(xpath = "//div[@class='rangeslider__handle-label']")
	private static WebElement slider_Age;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private static WebElement btn_Continue;
	
	@FindBy(xpath = "//input[@name='emiPerMonth']")
	private static WebElement input_TotalEMIs;
	
	@FindBy(xpath = "//a[text()='View FREE Offers']")
	private static WebElement Btn_ViewFreeOffers;

	
	public void CreateCarLoanApp(String TypeofCar, String PreferredCar, String YearOfManuf, String LiveIn, String MoveToCity_YYYY, String MoveToCity_MMM,String  MoveToResidence_YYYY,String MoveToResidence_MMM, String ResidenceType, String YourAge,String  DOB_MM_YYYY ,String DOB_MM_DD	,String TypeOfEmployment,String TotalEMIs) {
		try {
		
		if(TypeofCar.equalsIgnoreCase("NEW")) {
			isobjDisplayed(rb_NewCar);
			SeleniumActions.ClickFeild(_driver, rb_NewCar);
		}
		
		else if(TypeofCar.equalsIgnoreCase("OLD")) {
			isobjDisplayed(rb_OldCar);
			rb_OldCar.click();
		}
		isobjDisplayedWait(input_SelectModel);
		SeleniumActions.ClickFeild(_driver, input_SelectModel);
		isobjDisplayedWait(input_EnterModelName);
		SeleniumActions.EnterTextFeild(_driver, input_EnterModelName, PreferredCar);
		WebElement ModelNameele = _driver.findElement(By.xpath("//a[text()='"+PreferredCar+"']"));
		SeleniumActions.ClickFeild(_driver, ModelNameele);
		
		if(TypeofCar.equalsIgnoreCase("OLD")) {
			
			WebElement ManuYearele = _driver.findElement(By.xpath("//a[text()='"+YearOfManuf+"']"));
			SeleniumActions.ClickFeild(_driver, ManuYearele);
			
		}
		
		isobjDisplayedWait(input_SelectCity);
		SeleniumActions.ClickFeild(_driver, input_SelectCity);
		isobjDisplayedWait(input_EnterCityName);
		SeleniumActions.EnterTextFeild(_driver, input_EnterCityName, LiveIn);
		WebElement CityNameele = _driver.findElement(By.xpath("//a[text()='"+LiveIn+"']"));
		SeleniumActions.ClickFeild(_driver, CityNameele);
		
		WebElement MovedToCity_YYYY = _driver.findElement(By.xpath("//span[contains(text(),'When did you move to')]/parent::div/parent::div//a[text()='"+MoveToCity_YYYY+"']"));
		SeleniumActions.ClickFeild(_driver, MovedToCity_YYYY);
		
		WebElement MovedToCity_MMM = _driver.findElement(By.xpath("//span[contains(text(),'When did you move to')]/parent::div/parent::div//a[text()='"+MoveToCity_MMM+"']"));
		SeleniumActions.ClickFeild(_driver, MovedToCity_MMM);
		
		WebElement MovedToCurrent_YYYY = _driver.findElement(By.xpath("//span[text(),'When did you move to current residence?']/parent::div/parent::div//a[text()='"+MoveToResidence_YYYY+"']"));
		SeleniumActions.ClickFeild(_driver, MovedToCurrent_YYYY);
		
		WebElement MovedToCurrent_MMM = _driver.findElement(By.xpath("//span[text(),'When did you move to current residence?']/parent::div/parent::div//a[text()='"+MoveToResidence_MMM+"']"));
		SeleniumActions.ClickFeild(_driver, MovedToCurrent_MMM);
		
		WebElement ResidenceTypeele = _driver.findElement(By.xpath("//input[@value='"+ResidenceType+"']"));
		SeleniumActions.ClickFeild(_driver, ResidenceTypeele);
		
		isobjDisplayedWait(slider_Age);
		SeleniumActions.ClickFeild(_driver, slider_Age);
		
		WebElement Age_MonthYearele = _driver.findElement(By.xpath("//a[text()='"+DOB_MM_YYYY+"']"));
		SeleniumActions.ClickFeild(_driver, Age_MonthYearele);
		
		WebElement Age_Dayele = _driver.findElement(By.xpath("//a[text()='"+DOB_MM_DD+"']"));
		SeleniumActions.ClickFeild(_driver, Age_Dayele);
		
		isobjDisplayedWait(btn_Continue);
		SeleniumActions.ClickFeild(_driver, btn_Continue);
		
		WebElement EmpType = _driver.findElement(By.xpath("//input[@value='"+TypeOfEmployment+"']"));
		SeleniumActions.ClickFeild(_driver, EmpType);
		
		isobjDisplayedWait(input_TotalEMIs);
		SeleniumActions.EnterTextFeild(_driver, input_TotalEMIs, TotalEMIs);
		
		isobjDisplayedWait(btn_Continue);
		SeleniumActions.ClickFeild(_driver, btn_Continue);
		
		isobjDisplayedWait(Btn_ViewFreeOffers);
		SeleniumActions.ClickFeild(_driver, Btn_ViewFreeOffers);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}