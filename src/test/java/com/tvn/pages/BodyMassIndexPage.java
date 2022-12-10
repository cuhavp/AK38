package com.tvn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BodyMassIndexPage extends BasePage {

    By metricUnitTab = By.xpath("//a[text()='Metric Units']");
    By ageTextBox = By.id("cage");
    By maleCheckBox = By.id("csex1");
    By femaleCheckBox = By.id("csex2");
    By heightTextBox = By.id("cheightmeter");
    By wightTextBox = By.id("ckg");
    By calculateButton = By.xpath("//input[@alt='Calculate']");
    By resultLabel = By.className("bigtext");
    By clearButton = By.className("clearbtn");

    public BodyMassIndexPage(WebDriver driver) {
        super(driver);
    }


    public void selectMetricTab() {
        click(metricUnitTab);
    }

    public void fillForm(String age, String gender, String height, String weight) {
        fill(ageTextBox, age);
        if (gender.equals("male")) check(maleCheckBox);
        else check(femaleCheckBox);
        fill(heightTextBox, height);
        fill(wightTextBox, weight);
        click(calculateButton);
    }

    public String getResult() {
        return text(resultLabel);
    }

    public void clearCache() {
        click(clearButton);
    }

    @Override
    public void open() {
        visit("https://www.calculator.net/bmi-calculator.html");

    }
}
