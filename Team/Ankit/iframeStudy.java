package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeStudy {
WebDriver driver;
	@BeforeMethod
	void LaunchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		 driver= new ChromeDriver();
	   driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");
		
		
	}
	
	@Test
	void action()
	{
		//driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
		driver.switchTo().frame("courses-iframe");
		String value=driver.findElement(By.xpath("(//a[text()='Practice'])[1]")).getText();
		System.out.println("text on iframe "+value);
		//driver.switchTo().parentFrame(); //go to immediate parrent
		driver.switchTo().defaultContent(); //go to main page
		String value1=driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).getText();
		System.out.println("text on main page "+value1);
		
	
	}
	
	@AfterMethod
	void closeBrowser()
	{
		driver.quit();
	}
}
