package testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.CarLoanApp;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import basePackage.ReadExcelDataProvider;
import basePackage.SeleniumActions;

public class MainTest extends SeleniumActions {
	
	@DataProvider(name="carLoanData")
	public Object[][] data_CarLoanApplication() throws Exception {
		Object[][] arrayObject = ReadExcelDataProvider.getExcelData(prop.getProperty("tesData"),"TestData");
		return arrayObject;
	}
	
	@Test(dataProvider="carLoanData")
	public void TestCreateCarLoanApplication(String TypeofCar, String PreferredCar, String YearOfManuf, String LiveIn, String MoveToCity_YYYY, String MoveToCity_MMM,String  MoveToResidence_YYYY,String MoveToResidence_MMM, String ResidenceType, String YourAge ,String  DOB_MM_YYYY ,String DOB_MM_DD	,String TypeOfEmployment,String TotalEMIs) throws Exception
	{
		homePage = new HomePage(_driver);
		carLoanApp = new CarLoanApp(_driver); 
		loginPage = new LoginPage(_driver);
		
		homePage.naviageToLoginPage();
		loginPage.Login();
		homePage.naviageToCarLoan();
		carLoanApp.CreateCarLoanApp(TypeofCar,  PreferredCar, YearOfManuf, LiveIn,  MoveToCity_YYYY,  MoveToCity_MMM,  MoveToResidence_YYYY, MoveToResidence_MMM, ResidenceType, YourAge,  DOB_MM_YYYY , DOB_MM_DD	, TypeOfEmployment, TotalEMIs);
	}
}