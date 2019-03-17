package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import data.Constants;
import pageFlows.BookAFlightPage;
import pageFlows.FlightFinderPage;
import pageFlows.HomePage;
import pageFlows.RegisterConfirmPage;
import pageFlows.RegisterPage;
import pageFlows.SelectFlightPage;
import setup.TestRunSetup;

public class DemoAutTest_ModularizedFramework {

	public static void main(String[] args){
		WebDriver driver = null;
		try {
			System.out.println("######## Test Case Starts - DemoAutTest_ModularizedFramework #########");
			//Global Variables
			String browser =  Constants.BROWSER_TYPE;
			String url = Constants.BASE_URL;

			//Setup
			driver = TestRunSetup.launch(browser, url);	

			//Home Page - Registration click
			new HomePage().registration(driver);

			//Register - Filling in the registration details
			RegisterPage.registerDetails(driver);

			//Register - Confirmation Validation - Dear statementy
			new RegisterConfirmPage().registerConfirm_Dear(driver);

			//Homework: Capture and Validation - Note: Your user name is automationuser.
			new RegisterConfirmPage().registerConfirm_Note(driver);

			//Flight Reservation
			new FlightFinderPage().clickFlights(driver);
			new FlightFinderPage().flightDetails(driver);
			new FlightFinderPage().preferences(driver);
			new FlightFinderPage().continueButton(driver);

			//Select Flight
			new  SelectFlightPage().departReturnFlight(driver);

			//TODO Book A Flight
			new BookAFlightPage().summary(driver);
			//TODO Flight Confirmation
			//TODO Validation

			//TODO Sign out




		} catch (Exception e) {
			e.printStackTrace();
			//throw e;// Stop the execution
		}

		finally{
			//driver.close();
			System.out.println("######## Test Case Ends - DemoAutTest_ModularizedFramework #########");

		}


	}

}
