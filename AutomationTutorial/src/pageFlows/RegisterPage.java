package pageFlows;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import data.Constants;
import infrastructure.Operations;
import pageObjects.RegisterObj;
import utils.ExcelUtils;

public class RegisterPage {

	 static Operations op = new Operations();

	public static void registerDetails(WebDriver driver) throws Exception{
		//Contact Info
		/*WebElement ele = driver.findElement(By.xpath(RegisterPageObj.textbox_FirstName));
		ele.sendKeys("First Name");
		*/
		
		//No need to call datapool here, directly call TestDataPool.tcData.get
		HashMap<String,String> tcData = ExcelUtils.getTestDataXls(Constants.DATAPOOL_PATH, "DemoAut", 0, 1);//comment this

		op.setText(driver, RegisterObj.textbox_FirstName, tcData.get("firstName"));//parameterize
		op.setText(driver, RegisterObj.textbox_LastName, tcData.get("lastName"));//param
		op.setText(driver, RegisterObj.textbox_Phone, tcData.get("phone"));
		op.setText(driver, RegisterObj.textbox_Email, tcData.get("email"));

		//Mailing Info
		op.setText(driver, RegisterObj.textbox_Address1, tcData.get("address1"));
		op.setText(driver, RegisterObj.textbox_City, tcData.get("city"));
		op.setText(driver, RegisterObj.textbox_State, tcData.get("state"));
		op.setText(driver, RegisterObj.textbox_PostalCode, tcData.get("postalcode"));
		
		/*WebElement ele = driver.findElement(By.xpath(RegisterPageObj.dropdown_Country));
		Select sel = new Select(ele);
		sel.selectByVisibleText("UNITED STATES");
		*/
		op.selectDropdown(driver, RegisterObj.dropdown_Country, "UNITED STATES");
		op.setText(driver, RegisterObj.textbox_UserName, "automationuser");
		op.setText(driver, RegisterObj.textbox_Password, "automationpass");
		op.setText(driver, RegisterObj.textbox_ConfirmPassword, "automationpass");

		op.clickLink(driver, RegisterObj.link_Submit);
	
		op.implicitWait(driver, 30);
		//Thread.sleep(20000);//static wait Not recommended
	}
	
}
