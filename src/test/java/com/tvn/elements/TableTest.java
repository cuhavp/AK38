package com.tvn.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest {
    List<Row> tables;
    WebDriver driver;

    @BeforeClass
    void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        tables = new ArrayList<>();

        for (int row = 1; row < totalRow + 1; row++) {
            String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, 2))).getText();
            String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, 1))).getText();
            String email = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, 3))).getText();
            String due = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, 4))).getText();
            String website = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, 5))).getText();
            tables.add(new Row(firstName, lastName, email, due, website));
        }
    }

    @Test
    void getLargestDuePerson() {
        Row maxDueRow = tables.stream()
                .max(Comparator.comparingDouble(Row::getDue))
                .get();

        Assert.assertEquals(maxDueRow.getName(), "Jason Doe");
    }

    @Test
    void verifyMinDuePersons(){
        double minDueValue = tables.stream().mapToDouble(Row::getDue).min().getAsDouble();
        List<String> minDuePersons = tables
                .stream()
                .filter(row -> row.getDue() == minDueValue)
                .map(Row::getName)
                .collect(Collectors.toList());

        Assert.assertEquals(minDuePersons, Arrays.asList("John Smith","Tim Conway"));
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
