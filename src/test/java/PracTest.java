import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PracTest {
	WebDriver d;
	@Test(priority=1)
	public void privacy_policy() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
	    d.get("https://netbanking.hdfcbank.com/netbanking/");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		d.switchTo().frame(1);
		d.findElement(By.xpath("/html/body/form/p/a[2]")).click();	
		Set<String> id=d.getWindowHandles();
		Iterator<String> it=id.iterator();
		String main=it.next();
		String first=it.next();
		String third = it.next();
		d.switchTo().window(third);
		Thread.sleep(5000);
		d.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div[2]/ul[1]/li[1]/a")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[3]/div/div/div/div/div/div/div/div[1]/div[2]/ul/li[9]/div/a/button")).click();
		String getTitle=d.getTitle();
		if(d.getTitle().equals("HDFC Bank � Personal Banking & Netbanking Services")) {
			System.out.println("title verified");
		}
		Thread.sleep(5000);
		d.close();
		d.switchTo().window(main);
		d.switchTo().frame(0);
	}
		@Test(priority=2)
		public void login(){
		d.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[2]/span/input")).sendKeys("4443");
		d.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td[2]/a/img")).click();
		d.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[4]/td[2]/span/input")).sendKeys("abcdefg");
		//driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td/table/tbody/tr[7]/td[3]/span[2]/input")).sendKeys("dasdasd");
		//driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td/table/tbody/tr[13]/td/a/img")).click();
		d.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td/table/tbody/tr[7]/td/a/img")).click();
	}
}
	
	

