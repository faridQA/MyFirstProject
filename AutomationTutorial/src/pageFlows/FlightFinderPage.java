package pageFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infrastructure.Operations;
import pageObjects.FlightFinderObj;

public class FlightFinderPage {
	
	Operations op = new Operations();
	public void clickFlights(WebDriver driver){
		op.clickLink(driver, FlightFinderObj.link_Flights);
	}
	
	public void flightDetails(WebDriver driver){
	boolean flag = driver.findElement(By.xpath(FlightFinderObj.radiobutton_RoundTrip)).isSelected();
	
		if(!flag)
		op.clickRadiobutton(driver, FlightFinderObj.radiobutton_RoundTrip);
		
		op.selectDropdown(driver, FlightFinderObj.dropdown_Passengers, "2");
		op.selectDropdown(driver, FlightFinderObj.dropdown_DepartingFrom, "New York");
		op.selectDropdown(driver, FlightFinderObj.dropdown_DepartingOnMonth, "March");
		op.selectDropdown(driver, FlightFinderObj.dropdown_DepartingOnDate, "20");

		op.selectDropdown(driver, FlightFinderObj.dropdown_ArrivingIn, "Paris");
		op.selectDropdown(driver, FlightFinderObj.dropdown_ReturningOnMonth, "April");
		op.selectDropdown(driver, FlightFinderObj.dropdown_ReturningOnDate, "24");

	}

	public void preferences(WebDriver driver){
		op.clickRadiobutton(driver, FlightFinderObj.radiobutton_FirstClass);
		
	}
	
	public void continueButton(WebDriver driver){
		op.clickLink(driver, FlightFinderObj.button_Continue);
		
		op.implicitWait(driver, 30);

	}
}
