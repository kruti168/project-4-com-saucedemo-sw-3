package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends Utility {

String baseurl = "https://www.saucedemo.com/";

@Before
    public void setUp(){

    openBrowser(baseurl);

}
@Test
public void userSholdLoginSuccessfullyWithValidCredentials() {
    //Enter “standard_user” username
    sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");

//Enter “secret_sauce” password
    sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");

//Click on ‘LOGIN’ button
    clickOnElement(By.xpath("//input[@id='login-button']"));

// Verify the text “PRODUCTS”

    String expectedMessage = "Products";
    String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
    Assert.assertEquals(expectedMessage, actualMessage);

}
@Test
public void verifyThatSixProductsAreDisplayedOnPage(){
    //Enter “standard_user” username
    sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");

//Enter “secret_sauce” password
    sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");

//Click on ‘LOGIN’ button
    clickOnElement(By.xpath("//input[@id='login-button']"));

    List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item_desc']"));
    int actualNumber = number.size();
    int expectedNumber = 6;

    //checking actual and expected result
    Assert.assertEquals("6 product not displayed", expectedNumber, actualNumber);
    System.out.println("No of Product : " + actualNumber);


}

@After
    public void teatDown(){

   closeBrowser();
}
}
