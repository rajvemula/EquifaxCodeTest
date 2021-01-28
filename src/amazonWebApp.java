import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class amazonWebApp {

	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//nagar//Downloads//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.click();
		searchBox.sendKeys("qa testing for beginners");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
		WebElement priceOfItem = driver.findElement(By.xpath("(//*[@class='a-offscreen'])[1]"));
		String priceinSearch = priceOfItem.getText();
		System.out.println("-------------------------" + priceinSearch);
		WebElement titleOfBook = driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]"));		
		titleOfBook.click();
		String priceInDetailPage = driver.findElement(By.xpath("(//*[@class='a-size-base mediaTab_subtitle'])[1]")).getText();
		assertEquals(priceinSearch, priceInDetailPage, "Price should match");
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.click();
		Thread.sleep(2000);
		WebElement proceedToCheckOut = driver.findElement(By.xpath("(//*[@class='a-button-inner'])[2]"));
		proceedToCheckOut.click();
		String priceInCheckOutPage = driver.findElement(By.xpath("(//*[@class='a-size-base mediaTab_subtitle'])[1]")).getText();
		assertEquals(priceinSearch, priceInCheckOutPage, "Price should match");
		driver.quit();
	}
}
