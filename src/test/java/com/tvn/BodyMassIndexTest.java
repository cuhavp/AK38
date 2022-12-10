package com.tvn;

import com.tvn.pages.BodyMassIndexPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BodyMassIndexTest extends BaseTest {
    BodyMassIndexPage bodyMassIndexPage;

    @BeforeMethod
    void clearCache(){
        bodyMassIndexPage = new BodyMassIndexPage(driver);
        bodyMassIndexPage.open();
        bodyMassIndexPage.clearCache();
    }

    // Data Driven Test
    @DataProvider
    Object[][] bmiData(){
        return new Object[][]{
                {"35", "male", "173", "64","BMI = 21.4 kg/m2   (Normal)"},
                {"35", "male", "173", "80","BMI = 26.7 kg/m2   (Overweight)"},
                {"35", "male", "173", "160","BMI = 26.7 kg/m2   (Overweight)"},
        };
    }
    @Test(dataProvider = "bmiData")
    void validateResult(String age,String gender,String height,String weight,String expectedResult) {
        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.fillForm(age, gender, height, weight);
        Assert.assertEquals(bodyMassIndexPage.getResult(), expectedResult);
    }
}
