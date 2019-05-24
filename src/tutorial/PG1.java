package tutorial;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//if using Firefox, use the below line instead:
//import org.openqa.selenium.chrome.ChromeDriver;

public class PG1 {
	public static void main(String[] args) {
		//declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		/*
		 * driver object is instantiated → a ChromeDriver class with no parameters
		 * means that thte default Chrome profile will be launched by the Java
		 * [has no extensions loaded]
		 */
	
		
		//for firefox, use below two lines instead
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
		//WebDriver driver = new FirefoxDriver();
		
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		
		//launch browser and direct it to the base URL
		driver.get(baseUrl);
		/*
		 * is used to launch a new browser session and directs it to the URL
		 * that you specify as its parameter
		 */
		
		//get the actual value of the title
		actualTitle = driver.getTitle();
		/*
		 * the WebDriver class has the getTitle() method that is always used to
		 * obtain the page title od the currently loaded page
		 */
		
		/*
		 * compare the actual title of the page with the expected on and print
		 * the result as "Passed" of "Failed"
		 */
		
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		}else {
			System.out.println("Test Failed");
		}
		
		//close the browser
		driver.close();
		/*
		 * using this command without closing all browser windows will end with
		 * the whole Java program ending while leaving the browser open
		 */
	}
}

//following tutorial: https://www.guru99.com/first-webdriver-script.html
