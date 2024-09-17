package wdu;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDu {

	WebDriver driver;
	@BeforeClass
	public void LauncBrowser() {

		driver = new ChromeDriver();
		driver.get("https://webdriveruniversity.com/index.html");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

	@Test
	public void TC001() throws InterruptedException {

		driver.findElement(By.xpath("//h1[contains(text(),'CONTACT US')]")).click();
		Thread.sleep(1000);

		Set<String> s1=driver.getWindowHandles();
		Iterator<String>it=s1.iterator();

		String ParentWindow=it.next();
		String ChildWindow=it.next();

		driver.switchTo().window(ChildWindow);

		driver.findElement(By.xpath("//input[1]")).sendKeys("Hanish");
		driver.findElement(By.xpath("//input[2]")).sendKeys("Pinja");
		driver.findElement(By.xpath("//input[3]")).sendKeys("hanishpinja123@gmail.com");
		driver.findElement(By.xpath("//textarea")).sendKeys("We'll see ");
		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();		
		System.out.println("ContactUs has passed");

		driver.close();

		driver.switchTo().window(ParentWindow);
		Thread.sleep(2000);
	}

	@Test
	public void TC002() throws InterruptedException {

		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);//PAGE.SCROLL.DOWN
		Thread.sleep(2000);


		driver.findElement(By.xpath("//div[@class='section-title']//h1[text()='LOGIN PORTAL']")).click();
		Thread.sleep(1000);

		Set<String> s1=driver.getWindowHandles();//SWITCHING-WINDOW
		Iterator<String>it=s1.iterator();

		String ParentWindow=it.next();
		String ChildWindow=it.next();

		driver.switchTo().window(ChildWindow);//SWITCHING

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));   //WAIT.TILL.ELEMENT.TO.BE.DISPLAYED    
		WebElement Validation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']")));

		boolean Object=Validation.isDisplayed();  //BOOLEAN.USAGE
		if(Object) {
			System.out.println("LoginPortal has also PASSED");
		}else {
			System.out.println("LoginPortal has failed");
		}

		driver.findElement(By.xpath("//input[@id='text']")).sendKeys("Hanish");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Secure123");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Login']")).click();
//		Thread.sleep(2000);

		driver.close();

		driver.switchTo().window(ParentWindow);
		Thread.sleep(2000);

	}
	@Test
	public void TC003() throws InterruptedException {

		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);


		driver.findElement(By.xpath("//h1[text()='BUTTON CLICKS']")).click();
		Thread.sleep(1000);

		Set<String>s1=driver.getWindowHandles();
		Iterator<String>it=s1.iterator();

		String ParentWindow=it.next();
		String ChildWindow=it.next();

		driver.switchTo().window(ChildWindow);
		driver.findElement(By.xpath("//span[@id='button1']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(1000);
		
		driver.close();

		driver.switchTo().window(ParentWindow);
		Thread.sleep(2000);

	}

	@Test
	public void TC004() throws InterruptedException {


		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);

		driver.findElement(By.xpath("//div/h1[contains(text(),'TO DO')]")).click();
		Thread.sleep(2000);

		Set<String>s1=driver.getWindowHandles();
		Iterator<String>it=s1.iterator();

		String ParentWindow=it.next();
		String ChildWindow=it.next();

		driver.switchTo().window(ChildWindow);

		driver.findElement(By.xpath("//li[contains(text(),'potion class')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[2]/span/i[@class='fa fa-trash']")).click();
//		Actions action = new Actions(driver);	
//	    driver.findElement(By.xpath(""))  -- Have to Mouse Over
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Striking options");
		Thread.sleep(2000);
		driver.switchTo().window(ParentWindow);

	}

	  @Test
	  public void TC005() {
		  
		  driver.findElement(By.xpath("//h1[contains(text(),'PAGE OBJECT')]")).click();
		  
		  WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(10));
//		  WebElement Move=waitt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class="\glyphicon glyphicon-chevron-right\"]")));
//		  Move.click();
	  }



}
