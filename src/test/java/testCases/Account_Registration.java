package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.Baseclass;

public class Account_Registration extends Baseclass {
	@Test
	public void registration() throws InterruptedException {
		logger.info("***starting registration***"); 
		//click on my account menu 
		HomePage hp=new HomePage(driver);
		logger.info("***clicking on my account menu***");
		hp.ClickMyAccount();
		
		logger.info("***clicking on register***");
		hp.ClickRegister();
		//enter all the fields
		
		//create object of registration page
		logger.info("***entering all fields***");
		RegistrationPage rp=new RegistrationPage(driver);
		rp.sendFirstname(randomeString());
		rp.sendLastname(randomeString());
		rp.sendEmail(randomeString()+"@gmail.com");
		rp.sendPassword(randomAlphaNumeric());
		Thread.sleep(2000);
		rp.selectAgree();
		Thread.sleep(2000);
		rp.ClickContinue();
		String act_text=rp.textVerify();  //to get actual text
		Assert.assertEquals(act_text, "Your Account Has Been Created!","registration is not succesful");
		logger.info("***account registration completed***");
		
	}


}
