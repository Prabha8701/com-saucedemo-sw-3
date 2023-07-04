package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void closeDown() {
        closeBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Verify that six products are displayed on page
        List<WebElement> totalItem = driver.findElements(By.xpath("//img[@class='inventory_item_img']"));
        System.out.println(totalItem.size());
    }

}
