package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class FormFillPractice {
	public static void main(String[] args) {
		//declaration and instatiation of objects/variables
		System.setProperty("webdriver.chrome.driver",  "chromedriver");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://demo.guru99.com/test/login.html";
		driver.get(baseUrl);
		
		//Get the WebElement corresponding to the Email Address(TextField)
		WebElement email = driver.findElement(By.id("email"));
		
		//Get the WebElement corresponding to the Password Field
		WebElement password = driver.findElement(By.name("passwd"));
		
		email.sendKeys("abcd@gmail.com");
		password.sendKeys("abcdefghikjl");
		System.out.println("Text Field Set");
		
		//Deleting values in the text box
		email.clear();
		password.clear();
		System.out.println("Text Field Cleared");
		
		//Find the submit button
		WebElement login = driver.findElement(By.id("SubmitLogin"));
		
		//Using click method to submit form
		email.sendKeys("abcd@gmail.com");
		password.sendKeys("abcdefghikjl");
		login.click();
		System.out.println("Login Done with Click");
		
		//using submit method to submit the form. Submit used on password field
		driver.get(baseUrl);
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("abcdefghikjl");
		driver.findElement(By.id("SubmitLogin")).submit();
		System.out.println("Login Done with Submit");
		
		//driver.close();
		
	}

}
