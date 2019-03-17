package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generted method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\farid\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		System.out.println(driver.getTitle()); //validate current pages
		System.out.println(driver.getCurrentUrl());// validate correct url
       // System.out.println(driver.getPageSource());
		driver.get("http://yahoo.com");
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.close();
		//driver.quit();
	}

}
