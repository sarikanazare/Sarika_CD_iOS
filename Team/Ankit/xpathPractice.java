package SeleniumPractice;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.redbus.in/online-booking/msrtc?gclid=Cj0KCQjwhqaVBhCxARIsAHK1tiNUBRzlVbNdmuyDkY1dnnNE3uw6JHQ8f6GuDoNAWNSvOtzACBwToEUaAsm5EALw_wcB");
		driver.manage().window().maximize();
		String s = driver.findElement(By.xpath("//h2[text()=' Search MSRTC Bus Tickets ']")).getText();
		System.out.println(s);
		String s1 = driver.findElement(By.xpath("//a[@title='Nasik to Pune']//following::td[1]")).getText();
		System.out.println(s1);
		String s2 = driver.findElement(By.xpath("(//div[@class='D103_p']/p)[1]")).getText();
		System.out.println(s2);

		String splitstring[] = s2.split(" ");
		int len = splitstring.length;
		System.out.println(len);
		String s5 = splitstring[len - 1].replace(",", "");
		System.out.println("==================");
		System.out.println(s5);
		System.out.println("==================");
		int s6 = Integer.parseInt(s5);
		System.out.println("After convert to int " + s6);

	}

}

// System.out.println(Arrays.toString(splitstring));
// splitstring[splitstring.length-1]=splitstring[splitstring.length-1].replace(",",
// "");
// System.out.println(splitstring[splitstring.length-1]);
// int x=Integer.parseInt(splitstring[splitstring.length-1]);
// System.out.println(x);

// ================================================================================

// driver.get("https://bnt-soft.com/");
// driver.manage().window().maximize();

// String s = driver.findElement(By.xpath("//li[contains
// (@id,'menu-item-2890')]")).getText();
// String s = driver.findElement(By.xpath("(//a[text()='Home'])[1]")).getText();
// String s = driver.findElement(By.xpath("(//a[text()='About
// Us'])[1]")).getText();
// String s = driver.findElement(By.xpath("//li[contains
// (@id,'menu-item-3308')]")).getText();
// String s = driver.findElement(By.xpath("//li[contains
// (@id,'menu-item-2890')]")).getText();
// System.out.println(s);