package tutorial;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	private static WebDriver driver = null;
	
	public static void T1() {
		//TODO Auto-generated method stub
		
		String homePage = "http://www.zlti.com";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(homePage);
		
		//Identify all links in a webpage and store them in List
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//Obtain iterator to traverse through the List
		Iterator <WebElement> it = links.iterator();
		
		while(it.hasNext()) {
			//in this part, we will check if URL belongs to Third party domain whether URL is empty/null
			//get href of anchor tag and store it in url variable
			url = it.next().getAttribute("href");
			System.out.println(url);
			//Check if URL is null or empty and skip the remaining steps if the condition is satisfied
			if(url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			
			//Check whether URL belongs to a main domain or third party. Skip the remaining steps if it belongs to third party domain
			if(!url.startsWith(homePage)) {
				System.out.println("URL belongs to anther domain, skipping it");
				continue;
			}
			
			try {
				//HTTPURLConnection class has methods to send HTTP request and capture HTTP response code.
				//So, output of openConnection() method (URLConnection) is type casted to HTTPURLConnection
				huc = (HttpURLConnection)(new URL(url).openConnection());
				//We can Request type as "HEAD" instead of "GET". So that only headers are returned and not document body
				huc.setRequestMethod("HEAD");
				//on invoking connect() method, actual connection to url is established and the request is sent
				huc.connect();
				//using getResponseCode() method we can get response code for the request
				respCode = huc.getResponseCode();
				//based on response code we will try to check link status
				//thus, we can obtain all links from web page and print whether links are valid or broken
				//hope this tutorial helps you in checking Broken links using selenium
				if(respCode>= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}
			} catch (MalformedURLException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void T2() {
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		
		String underConsTitle = "Under Construction: Mercury Tours";
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		
		//extract the link texts of each link element
		for (WebElement e : linkElements) {
			linkTexts[i] = e.getText();
			i++;
		}
		
		//test each link
		for (String t : linkTexts) {
			driver.findElement(By.linkText(t)).click();
			if (driver.getTitle().contentEquals(underConsTitle)) {
				System.out.println("\"" + t + "\"" + " is under construction.");
			} else {
				System.out.println("\"" + t + "\"" + " is working.");
			}
			driver.navigate().back();
		}
	}
	
	public static void main(String[] args) {
		T1();
		driver.close();
		T2();
		driver.quit();
	}
}
