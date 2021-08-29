//About the code: End to end automation testing for a dummy project using selenium WebDriver based on java

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EtoE {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\61469\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		
 //1)auto suggest dropbox
				driver.findElement(By.id("autosuggest")).sendKeys("ind"); //sendkeys to type in that element
				Thread.sleep(3000);
				List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
				for (WebElement option :options)
				{
					if(option.getText().equalsIgnoreCase("india"))
					{
					 option.click();
					 break;
					}
				}

						        
 //2)looping concept:here adding no of adults
		        driver.findElement(By.id("divpaxinfo")).click();
		        Thread.sleep(2000L);
		     
		        //using for loop
				   for(int i=1;i<5;i++)
				   {
		            driver.findElement(By.id("hrefIncAdt")).click();
		           }
				driver.findElement(By.id("btnclosepaxoption")).click();
		        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); 
		        
		        /*using while loop:
			    int i=1;
			    while(i<5)
			    {
	              driver.findElement(By.id("hrefIncAdt")).click();//4 times
	              i++;
	             }
	             System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); */
	           
		        		
  //3)static dropdown
				Select s=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
				s.selectByVisibleText("AED");
		        //s.selectByValue("USD");
		        //can also use s.selectByIndex();
				
				
  //4)select round trip(radio button)
		        driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
		     	
		        
  //5)dynamic dropdown
		           // origin station
		        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		        driver.findElement(By.cssSelector("a[value='DEL']")).click();
		        System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).getAttribute("value"));
		           // Destination
		        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();     
		        driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();   
		        System.out.println( driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).getAttribute("value"));	

	

		        
		        
 //6)to select a check box and check if its selected
			  	System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
			  	driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
			  	System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
			  	//to get the num of check boxes in the page
			    //for that we need to get a common value from all/most of these check boxes and use that in locators which finds all the matching elements and counts
			  	System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());//findelements(not just findelement) to get all the elements,size to get the count
			  	
			
 //7)taking screenshot
			  	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(src, new File("C:\\Users\\61469\\screenshot.png"));
			  
	
 //8)search flights for the given options and exit
			  	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
			  	driver.quit();
			}
	
	}


