package SeleniumPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class totalDetailsOfCompany {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		System.out.println("Launch the app");
		driver.manage().window().maximize();
		System.out.println("Windows maximize");
		
		List<WebElement>list2=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		int size=list2.size();
		System.out.println(size);
		
		HashSet <ArrayList> namesOfCompany= new HashSet();
		for (int i=1; i<=size; i++) {
			String company=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[1]")).getText();
			String group=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[2]")).getText();
			String p_Close=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
			String C_Close=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[4]")).getText();
			String changes=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[5]")).getText();
			
			ArrayList<String> a1= new ArrayList();
			a1.add(company);
			a1.add(group);
			a1.add(p_Close);
			a1.add(C_Close);
			a1.add(changes);
			
			namesOfCompany.add(a1);
				
		}
		System.out.println(namesOfCompany);
		System.out.println(namesOfCompany.size());
		

	}

}
