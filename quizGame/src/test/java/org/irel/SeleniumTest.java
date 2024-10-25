package org.irel;

import org.openqa.selenium.Dimension;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class SeleniumTest {
	
	    @Test
	    public void shouldAnswerWithTrue() 
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\irisf\\WorkDir\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
	    	WebDriver driver = new ChromeDriver(options);    
	    	System.out.println("Driver found, now searching for target page");
			driver.get("http://localhost:8080/"); 
			
		        try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
		        
		     // SUCCESSFULL LOGIN TEST
		     // Step # | name | target | value
		        // 1 | open | / | 
		        driver.get("http://localhost:8080/");
		        // 2 | setWindowSize | 1188x794 | 
		        driver.manage().window().setSize(new Dimension(1188, 794));
		        
		        // 3 | click | id=username | 	      
		        WebElement idField = driver.findElement(By.id("username"));
		        idField.click();
		        // 4 | type | id=username | Elon
		        idField.sendKeys("Elon");
		        
		        WebElement idPass = driver.findElement(By.id("password"));
		        // 5 | click | id=password | 
		        idPass.click();
		        // 6 | type | id=password | space
		        idPass.sendKeys("space");
		        // 7 | click | css=input:nth-child(9) | 
		        // Make sure the button will be found in several cases 
		        WebElement submitBtn = null;
		        if(submitBtn == null) {
		        	submitBtn = driver.findElement(By.cssSelector("input:nth-child(9)"));
		        }
		        if(submitBtn == null) {
			        driver.findElement(By.xpath("//input[@value=\'Submit\']"));
		        }
		        submitBtn.click();

		        
			 System.out.println("Execution of successful login test was successful");
	     
	    }
	}

