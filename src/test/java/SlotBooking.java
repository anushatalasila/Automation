import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlotBooking {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
    	System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get("https://webtrac.thorntonco.gov/wbwsc/webtrac.wsc/splash.html");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Actions a = new Actions(driver);
    	
    	WebElement r = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
    	a.moveToElement(r).click().perform();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	WebElement b = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]/span[1]"));
    	a.moveToElement(b).click().perform();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	WebElement tab = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/table[1]"));
    	List<WebElement> rows = tab.findElements(By.tagName("tr"));
    	WebElement columnList = null;
    	for (WebElement row : rows) {
    		WebDriverWait logWait = new WebDriverWait(driver, 10);
    		logWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("td")));  
            columnList = row.findElement(By.className("button-cell"));
            System.out.println(columnList.getText());
            
            
    	}
    	
    	
    	
    	
    	driver.close();
	}
}
