package com.tvn.elements;

import com.tvn.BaseTest;
import com.tvn.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {
    TodoPage todoPage;

    @BeforeMethod
    void openPage(){
        todoPage = new TodoPage(driver);
        todoPage.open();
    }
    @Test
    void createNewTodoSuccessfully()  {
        int currentItemLeft = todoPage.getItemsLeft();
        todoPage.createNewToDo("Task 1");
        int afterItemLeft = todoPage.getItemsLeft();
        Assert.assertTrue(afterItemLeft-currentItemLeft==1);
        Assert.assertTrue(todoPage.isTodoDisplayed("Task 1")); //displayed on All
        todoPage.selectActiveTab();
        Assert.assertTrue(todoPage.isTodoDisplayed("Task 1"));//displayed on Active
    }

    @Test
    void markActiveTodoCompleted(){
        todoPage.createNewToDo("Task 1");
        int beforeItemsLeft =  todoPage.getItemsLeft();

        todoPage.selectActiveTab();
        todoPage.markTodoCompleted("Task 1");

        int afterCurrentItemsLeft = todoPage.getItemsLeft();

        Assert.assertEquals(afterCurrentItemsLeft+1,beforeItemsLeft);

        todoPage.selectCompletedTab();
        Assert.assertTrue(todoPage.isTodoDisplayed("Task 1"));

    }

    @Test
    void deleteTodo(){
        todoPage.createNewToDo("Task 1");
        int beforeItemsLeft =  todoPage.getItemsLeft();
        todoPage.deleteTodo("Task 1");
        int afterCurrentItemsLeft = todoPage.getItemsLeft();
        Assert.assertEquals(afterCurrentItemsLeft+1,beforeItemsLeft);
    }

    @Test
    void editTodo(){
        todoPage.createNewToDo("Task 1");
        todoPage.renameTodo("Task 1","Task 2");
        Assert.assertTrue(todoPage.isTodoDisplayed("Task 2"));
    }
}
