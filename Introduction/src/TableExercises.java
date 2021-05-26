

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\61469\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		         //102-techniques used for table grid real time examples//
		
		/*selecting one whole table,creating a WebElement called parenttable for that,
		limiting our actions on that parenttable. so parenttable.findelements(elements here as there r several elements in this variable)*/
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/29798/stz-vs-gaw-24th-match-caribbean-premier-league-2020");
		
		WebElement parenttable=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int  noOfRowsCount= parenttable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
        //the idea is to get all the elements from that table in a string, go to 3rd elemrnt in all of those rows using loop, and add those values.
        //our focus is to get to 3rd element in all these rows
        
        int sum=0;
        int Count= parenttable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
                                                            //css parent to child:--parentcss <space> childtagname:nth-child(child no.)--
	    for(int i=0;i<Count-2;i++)
	    {
	    System.out.println(parenttable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());
	    String value=parenttable.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
	    //now everytime the value got here is string, we need to convert it to integer to have a sum. so the following step 
	    int integervalue=Integer.parseInt(value);
	    //now adding values in the form of integer
	    sum=sum+integervalue;
	    }
	    System.out.println("Sum is "+ sum);
	    
	  //now we have last one element in that row count to be added .bcoz it was different,we deal it seperately and add everything and comparing with total printed
	   System.out.println(parenttable.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
	   String extras=parenttable.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
	   int intextras= Integer.parseInt(extras);
	   int actualtotal= sum + intextras;
	   System.out.println("actualtotal is "+actualtotal);
	   String totalsumstring=parenttable.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
	   System.out.println("totalsum is "+totalsumstring);
	   int totalsum=Integer.parseInt(totalsumstring);
	   //lets see if actualsum is equal to the totalsum
	   if(actualtotal==totalsum)
	   {
		   System.out.println("actualtotal is equal to totalsum");
	   }
	   else
	   { 
		   System.out.println("actualtotal doesnot match with totalsum");
	   }
	   }
		   
	   
	    
	   
	   
	   
	}


