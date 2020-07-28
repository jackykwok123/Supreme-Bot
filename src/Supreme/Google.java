package Supreme;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Google{

	public WebDriver login (String username, String password) {
        
		String path = System.getProperty("user.dir");
		path = path.replace("\\", "\\\\");
        System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 3000000);
  
        driver.get("https://stackoverflow.com/users/signup?ssrc=head&returnurl=%2fusers%2fstory%2fcurrent%27");
        
        
        driver.findElement(By.xpath("//*[@id='openid-buttons']/button[1]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
        
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='passwordNext']")).click();
        
        By locator = By.xpath("/html/body/header/div/ol[2]/li[2]/a[1]");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        
        driver.get("https://www.supremenewyork.com/shop/all");
        
        return driver;
	}
}


