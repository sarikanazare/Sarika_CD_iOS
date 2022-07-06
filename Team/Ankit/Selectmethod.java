package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selectmethod {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");
		
		WebElement list= driver.findElement(By.xpath("//select[@id='first']"));
		Select s= new Select(list);
	//	s.selectByValue("Google");
		s.selectByVisibleText("Iphone");
		List<WebElement> l=new ArrayList<WebElement>();
		l=s.getOptions();
		for(WebElement e: l)
		{
			String value=e.getText();
			System.out.println(value);
		}
		
	

	}

}
