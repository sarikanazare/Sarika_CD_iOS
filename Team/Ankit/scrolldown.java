package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class scrolldown {
WebDriver driver;
@BeforeTest
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		// 1.scrolling by pixel
		//js.executeScript("window.scrollBy(0,1000)","");
		
		//2.scrolling page till find element
		
	//WebElement Element=driver.findElement(By.xpath("//div[@class='mouse-hover']"));
		//js.executeScript("arguments[0].scrollIntoView();", Element);
		
		//3.scroll page till bottom
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	}


