package com.tvn.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TodoPage extends BasePage{
   private By newTodoTextBox = By.className("new-todo");
   private By activeTab =By.xpath("//a[text()='Active']");
   private By completedTab = By.xpath("//a[text()='Completed']");
   private By allTab = By.xpath("//a[text()='All']");
   private By itemLeftLabel =By.cssSelector(".todo-count > strong");

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://todomvc.com/examples/vanillajs");
    }

    public void createNewToDo(String name){
        driver.findElement(newTodoTextBox).sendKeys(name, Keys.ENTER);
    }

    public boolean isTodoDisplayed(String name){
      return getTodoByName(name).isDisplayed();
    }

    private WebElement getTodoByName(String name){
        return driver.findElement(By.xpath(String.format("//label[.='%s']",name)));
    }

    public void selectActiveTab(){
        driver.findElement(activeTab).click();
    }

    public void selectCompletedTab(){
        driver.findElement(completedTab).click();
    }


    public void selectAllTab(){
        driver.findElement(allTab).click();
    }
    public int getItemsLeft(){
        if(driver.findElement(itemLeftLabel).isDisplayed()){
            return Integer.parseInt(driver.findElement(itemLeftLabel).getText());
        }else return 0;
    }

    public void markTodoCompleted(String name){
        WebElement markCheckbox = driver.findElement(By.xpath(String.format("//label[.='%s']/preceding-sibling::input",name)));
        markCheckbox.click();
    }

    public void deleteTodo(String name){
        Actions action = new Actions(driver);
        action.moveToElement(getTodoByName(name)).perform();
        driver.findElement(By.xpath(String.format("//label[.='%s']/following-sibling::button",name))).click();
    }

    public void renameTodo(String oldName,String newName){
        WebElement todoToEdit = driver.findElement(By.xpath(String.format("//label[.='%s']/../..",oldName)));
        Actions actions = new Actions(driver);
        actions.doubleClick(todoToEdit).perform();

        WebElement todoEditInput = todoToEdit.findElement(By.cssSelector("input.edit"));
        executeScript("arguments[0].value = ''", todoEditInput);
        todoEditInput.sendKeys(newName+Keys.ENTER);
    }



    public List<WebElement> getAllTodos(){
        return driver.findElements(By.cssSelector(".todo-list > li"));
    }

//    public WebElement getTodoByName(String name){
//        return getAllTodos()
//                .stream()
//                .filter(todo -> todo.getText().equals(name))
//                .findFirst()
//                .orElseThrow();
//    }

}
