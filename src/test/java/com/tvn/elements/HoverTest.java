package com.tvn.elements;

import com.tvn.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest extends BaseTest {

    @BeforeMethod
    void open(){
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    void hoverToPerson1() {
        Actions mouse = new Actions(driver);
        mouse
                .moveToElement(driver.findElement(By.xpath("//div[@class='figure'][1]")))
                .perform();

        String caption = driver.findElement(By.xpath("//div[@class='figure'][1]/div[@class='figcaption']/h5")).getText();
        Assert.assertEquals(caption,"name: user1");
    }


}
