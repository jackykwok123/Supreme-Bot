package Supreme;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SupremeWebsite {
	
	public Boolean isAlive(WebDriver driver) {
	    try {
	        driver.getCurrentUrl();//or driver.getTitle();
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}
	
	public void sendK(String keysToSend,WebElement element){
        for(char c:keysToSend.toCharArray()){
            element.sendKeys(Character.toString(c));
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

	public void main(Buyer buyer, Buying item, WebDriver driver) throws InterruptedException {
       
		 // item = new Buying("Bowling","shirts","blue",1000, "Large");
	     // buyer = new Buyer("Jay Patel","jaypatel10673@gmail.com","6015191839","abc best drive","123","L4B 2A4","My city", "ON", "4234123412341234","06","2024","888","Canada");

		if(!isAlive(driver)) {
		String path = System.getProperty("user.dir");
		path = path.replace("\\", "\\\\");
        System.setProperty("webdriver.chrome.driver",path+"\\chromedriver.exe");
        driver = new ChromeDriver();
		}
		
        WebDriverWait wait = new WebDriverWait(driver, 3000000);
        String catagory = item.catagory;
        driver.get("https://www.supremenewyork.com/shop/all/"+catagory);

        //List<WebElement>textDemo= driver.findElements(By.xpath("//*[contains(text(),'"+item.name+"'")]"));
        //textDemo.get(0).click();
        long time = (item.timeInMilli == 0) ? 4000 : item.timeInMilli ;
        boolean foundItem = false;
        while(!foundItem) {
            long starttime = System.currentTimeMillis();
            By reload = By.className("inner-article");
            wait.until(ExpectedConditions.visibilityOfElementLocated(reload));
            List<WebElement> Elements = driver.findElements(By.className("inner-article"));
            
            for (int Counter = 0; Counter < Elements.size(); Counter++) {
                if (Elements.get(Counter).getText().toLowerCase().contains((item.name).toLowerCase()) && Elements.get(Counter).getText().toLowerCase().contains((item.color).toLowerCase())) {
                    Elements.get(Counter).click();
                    foundItem = true;
                    break;
                }
            }
            
            long endTime = System.currentTimeMillis();
            if(!foundItem){
                driver.navigate().refresh();
                System.out.println("finding item"+item.toString());
                System.out.println("trying again");
            }
            System.out.println(endTime-starttime);
        }
        //Thread.sleep(2000);
        By by7 = By.xpath("//*[@id=\"s\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by7));
        Select dropdown = new Select(driver.findElement(By.id("s")));
        dropdown.selectByVisibleText(item.size);

        //click add to card
        driver.findElement(By.cssSelector("input[type='submit'][value='add to cart']")).click();
        System.out.println("before xpath");
        By submitButton = By.xpath("//*[@id=\"cart\"]/a[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        System.out.println("after xpath");

        driver.findElement( By.xpath("//*[@id=\"cart\"]/a[2]")).click();

        By checkoutPageLoad = By.xpath("//*[@id=\"pay\"]/input");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPageLoad));
        
        Select dropdownCountry = new Select(driver.findElement(By.name("order[billing_country]")));
        dropdownCountry.selectByVisibleText(buyer.country.toUpperCase());
        
        driver.findElement(By.id("order_billing_name")).sendKeys(buyer.name);
        driver.findElement(By.id("order_email")).sendKeys(buyer.email);
        WebElement tel = driver.findElement(By.name("order[tel]"));
        new SupremeWebsite().sendK(buyer.tel, tel);
        
        driver.findElement(By.name("order[billing_address]")).sendKeys(buyer.address);
        driver.findElement(By.name("order[billing_address_2]")).sendKeys(" ");
        driver.findElement(By.name("order[billing_city]")).sendKeys(buyer.city);

        Select dropdownState = new Select(driver.findElement(By.id("order_billing_state")));
        dropdownState.selectByVisibleText(buyer.State);
        
        driver.findElement(By.name("order[billing_zip]")).sendKeys(buyer.zip);

        WebElement cc = driver.findElement(By.name("riearmxa"));
        new SupremeWebsite().sendK(buyer.cardNumber, cc);

        Select expMonth = new Select(driver.findElement(By.id("credit_card_month")));
        expMonth.selectByVisibleText(buyer.expMonth);

        Select expYear = new Select(driver.findElement(By.id("credit_card_year")));
        expYear.selectByVisibleText(buyer.expYear);

        driver.findElement(By.name("credit_card[meknk]")).sendKeys(buyer.cvv);

        driver.findElement(By.xpath("//*[@id=\"cart-cc\"]/fieldset/p[2]/label/div/ins")).click();
        Thread.sleep(item.timeInMilli);
        
        driver.findElement(By.cssSelector("input[type='submit'][value='process payment']")).click(); 
    }
}


