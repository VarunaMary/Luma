package com.Luma;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pomclass.CheckoutPage;
import com.pomclass.HomePage;
import com.pomclass.MenPage;
import com.pomclass.SigninPage;
import com.pomclass.WomenPage;
import com.utilityfiles.UtilityFiles;

public class RunnerClass extends UtilityFiles {

	 public static WebDriver driver;
	 @BeforeClass
	 private void setUp() {
     driver=launchBrowser();
     getUrl("https://magento.softwaretestingboard.com/");
	}
	 @BeforeMethod
	 private void signin() {
       HomePage hp=new HomePage(driver);
       click(hp.getSignin());
       SigninPage sp=new SigninPage(driver);
       sendKeys(sp.getUser(), "varunavarghees1995@gmail.com");
       sendKeys(sp.getPsw(), "papputyson@10");
       click(sp.getLogin());
	}
	 @Test(priority = 2)
	 private void firstItem() throws InterruptedException {
		 HomePage hp=new HomePage(driver);
		 click(hp.getWomen());
		 WomenPage wp=new WomenPage(driver);
		 click(wp.getHoodies());
		 click(wp.getFirst());
		 waits();
		 click(wp.getBackpic());
		 click(wp.getDetails());
		 click(wp.getSpecifications());
		 click(wp.getSize());
		 click(wp.getColor());
		 click(wp.getQty());
		 click(wp.getAddToCart());
		 Thread.sleep(5000);
		 click(wp.getCart());
		 Thread.sleep(2000);
		 click(wp.getCheckout());
	}
	 @Test(priority = 1)
	 private void seconditem() throws InterruptedException {
		 HomePage hp=new HomePage(driver);
		 click(hp.getMen());
		 MenPage mn=new MenPage(driver);
		 click(mn.getJackets());
		 click(mn.getJack());
		 waits();
		 click(mn.getSize());
		 click(mn.getColor());
		 click(mn.getAddToCart());
		 Thread.sleep(5000);
		 click(mn.getCart());
		 Thread.sleep(2000);
		 click(mn.getCheckout());
	}
	 @AfterMethod
	 private void checkout() throws InterruptedException {
       CheckoutPage cp=new CheckoutPage(driver);
       waits();
//       sendKeys(cp.getCompany(), "ABC company");
//       sendKeys(cp.getAddress1(), "punnamoodu vilai");
//       sendKeys(cp.getAddress2(), "thumbacode");
//       sendKeys(cp.getAddress3(), "Kulasekharam");
//       sendKeys(cp.getCity(), "Kanyakumari");
//       selectByValue(cp.getState(), "4");
//       sendKeys(cp.getPostalCode(), "85039");
//       sendKeys(cp.getPhnno(), "343465464");
       click(cp.getRate());
       Thread.sleep(2000);
       click(cp.getNext());
       Thread.sleep(5000);
       click(cp.getOrder());
       click(cp.getCshop());
       HomePage hp=new HomePage(driver);
       click(hp.getAccbtn());
       click(hp.getSignout());
      }
	 @AfterClass
	 private void tearDown() {
       close();
	}
	 
}
