package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class autosuggestion {

	
		@Test
		void autosugg() throws InterruptedException
		{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");
		
		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("can");
		Thread.sleep(2000);
		
	List<WebElement> country=	driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
	//System.out.println(country);
	for(WebElement w: country)
	{
		String list=w.getText();
		System.out.println(list);
	}

	}

}
