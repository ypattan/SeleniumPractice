package tutorial;

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.text.NumberFormat;

public class DynamicWebTables {
	public static String baseUrl = "http://demo.guru99.com/test/web-table-element.php";
	public static WebDriver wd = new ChromeDriver();
	
	public static void rowAndCell() {
		wd.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
		WebElement baseTable = wd.findElement(By.tagName("table"));
		
		//To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
		String rowtext = tableRow.getText();
		System.out.println("Third row of table : " + rowtext);
		
		//to get 3rd row's 2nd column data
		WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed);
	}
	
	/*
	 * max from table does not work because the xpath does not work, cant figure it out but
	 * if it is necessary for future projects, i'll figure it out then
	/*
	public static void maxFromTable() throws ParseException {
		double m = 0, r = 0;
		String max;
		
		//no. of columns
		List col = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("Total No of columns are : " + col.size());
		
		//no. of rows
		List rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("Total No of rows are : " + rows.size());
		for (int i = 1; i < rows.size(); i++) {
			max= wd.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
			NumberFormat f = NumberFormat.getNumberInstance();
			Number num = f.parse(max);
			max = num.toString();
			m = Double.parseDouble(max);
			if(m>r) {
				r=m;
			}
		}
		
		System.out.println("Maximum current price is : " + r);
	}
	*/
	
	public static void NoRowsCol() throws ParseException {
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wd.get(baseUrl);
		
		//To locate table
		List <WebElement> mytable = wd.findElements(By.tagName("tr"));
		
		//To locate rows of table
		List <WebElement> rows_table = wd.findElements(By.tagName("tr"));
		
		//To calculate no of rows in table
		int rows_count = rows_table.size();
		
		//Loop will execute till the last row of table
		for (int row = 0; row < rows_count; row++) {
			//To locate columns(cells) of that specific row
			List <WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			//To calculate no of columns (cells) in that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);
			
			//Loop will execute till the last cell of that specific row
			for (int column = 0; column < columns_count; column++) {
				//to retrieve text from that specific cell
				String celtext = Columns_row.get(column).getText();
				System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
			}
			
			System.out.println("-----------------------------------------------------------");
		}
	}
	
	public static void main(String[]args) throws ParseException {
		wd.get(baseUrl);
		rowAndCell();
		
		//baseUrl = "http://demo.guru99.com/test/web-table-element.php";
		//wd.get(baseUrl);
		//maxFromTable();
		
		baseUrl = "http://demo.guru99.com/test/table.html";
		//wd.get(baseUrl);
		NoRowsCol();
		
		wd.quit();
	}
}
