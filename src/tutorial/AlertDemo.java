package tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;

import java.util.Iterator;
import java.util.Set;

public class AlertDemo {
	public static String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
	public static WebDriver driver = new ChromeDriver();
	
	public static void singleAlert()  throws NoAlertPresentException, InterruptedException {
		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).submit();
		
		//Switching to Alert
		Alert alert = driver.switchTo().alert();
		
		//Capturing alert message
		String alertMessage = driver.switchTo().alert().getText();
		
		//Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(5000);
		
		//Accepting alert
		alert.accept();
	}
	
	public static void windowHandle() throws InterruptedException {
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		String MainWindow = driver.getWindowHandle();
		
		//To handle all new opened window
		Set<String> s1 = driver.getWindowHandles();
		Iterator <String> i1 = s1.iterator();
		
		while(i1.hasNext()) {
			String ChildWindow = i1.next();
			if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
				//Switching to Child window
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
				
				driver.findElement(By.name("btnLogin")).click();
				
				//Closing the Child Window
				driver.close();
			}
		}
		//switching to parent window i.e. main window
		driver.switchTo().window(MainWindow);
	}
	
	public static void pathForTable() {
		baseUrl = "http://demo.guru99.com/test/write-xpath-table.html";
		driver.get(baseUrl);
		String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		System.out.println(innerText);
		
		baseUrl = "http://demo.guru99.com/test/accessing-nested-table.html";
		driver.get(baseUrl);
		innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText();
		System.out.println(innerText);
		
		baseUrl = "http://demo.guru99.com/test/newtours/";
		driver.get(baseUrl);
		innerText = driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[4]/td")).getText();
		System.out.println(innerText);
		
		baseUrl = "http://demo.guru99.com/test/newtours/";
		driver.get(baseUrl);
		innerText = driver.findElement(By.xpath(
				"//table/tbody/tr/td[2]"
				+ "//table/tbody/tr[4]/td/"
				+ "table/tbody/tr/td[2]/"
				+ "table/tbody/tr[2]/td[1]/"
				+ "table[2]/tbody/tr[3]/td[2]/font")).getText();
		System.out.println(innerText);
		driver.quit();
	}
	
	public static void main(String[] args) throws NoAlertPresentException, InterruptedException {
		driver.get(baseUrl);
		singleAlert();
		baseUrl = ("http://demo.guru99.com/popup.php");
		driver.get(baseUrl);
		windowHandle();
		pathForTable();
		driver.quit();
	}

}


//in my fathers house by box? butterfield
