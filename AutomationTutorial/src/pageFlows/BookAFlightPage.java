package pageFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import infrastructure.Operations;
import pageObjects.BookAFlightObj;

public class BookAFlightPage {
 Operations op = new Operations();
	public void summary(WebDriver driver){
		System.out.println("\n ##### BookAFlightPage - summary #####\n");
	//String departPrice = 	driver.findElement(By.xpath(BookAFlightObj.table_DepartPrice)).getText();
	String departPrice = op.getText(driver, BookAFlightObj.table_DepartPrice);
	String returnPrice = op.getText(driver, BookAFlightObj.table_ReturnPrice);
	String noOfPassengers = op.getText(driver, BookAFlightObj.table_NoOfPassengers);
	
	String taxes = op.getText(driver, BookAFlightObj.table_taxes);
	String totalPrice = op.getText(driver, BookAFlightObj.table_TotalPrice);

	taxes = taxes.substring(1); //$96
	System.out.println("Modified tax = "+taxes);
	
	totalPrice = totalPrice.replaceAll("[$]", ""); //1264
	System.out.println("Modified total price = "+totalPrice);
	
	// Parsing
	int departPriceInt = Integer.parseInt(departPrice);
	int returnPriceInt = Integer.parseInt(returnPrice);
	int noOfPassengersInt = Integer.parseInt(noOfPassengers);
		
	int taxesInt = Integer.parseInt(taxes);
	int totalPriceInt = Integer.parseInt(totalPrice);
	//double taxesDouble = Double.parseDouble(taxes);
	//long totalPriceLong = Long.parseLong(totalPrice);
	
	//Validation
	int expectedTotalPrice = (departPriceInt+returnPriceInt)*noOfPassengersInt + taxesInt  ; //Requirement : totalprice= (departprice+returnprice)*totalnoofpassengers+taxes
	int actualTotalPrice = totalPriceInt;
	
	if(expectedTotalPrice == actualTotalPrice )
		System.out.println("Pass - expectedTotalPrice == actualTotalPrice");
	else
		System.out.println("Fail - expectedTotalPrice NOT equal to actualTotalPrice");

	
	}
}
