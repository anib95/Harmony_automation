package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.GuiControl;
import util.XMLReader;

import java.util.Map;

/**
 * Created by sharvari on 20/6/17.
 */
public class DesignModule extends GuiControl{
    Map<String,String> designmap = new XMLReader().getObjectRepoData("treeEditorheaderfooter");
    Map<String,String> treemap = new XMLReader().getObjectRepoData("treeEditor");

    public void changeTitle(String nodetitle){
        waitForSeconds(3);
        getWebElement(designmap.get("changenodetitle")).click();
        getWebElement(designmap.get("titletext")).sendKeys(nodetitle);
        getWebElement(designmap.get("titleok")).click();
    }
    public void addChild(String childname){
        try {
            Thread.sleep(2000);
            getWebElement(treemap.get("addchild")).click();
            getWebElement(treemap.get("childname")).sendKeys(childname);
            getWebElement(treemap.get("buttonok")).click();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void navigateUp(){
        getWebElement(designmap.get("navigateup")).click();
    }
    public void navigateDown(){
        getWebElement(designmap.get("navigatebottom")).click();
    }
    public void navigateLeft(){
        getWebElement(designmap.get("navigateleft")).click();
    }
    public void navigateRight(){
        getWebElement(designmap.get("navigateright")).click();
    }

    public void addParent(String parentname){
        waitForSeconds(3);
        getWebElement(treemap.get("addparent")).click();
        getWebElement(treemap.get("parentname")).sendKeys(parentname);
        getWebElement(treemap.get("okbutton")).click();
    }
    public void saveChanges(){
        getWebElement(designmap.get("savebutton")).click();
        waitForSeconds(1);
    }
    //Element not clickable error

    public void navigateNodeDetails(){
        Actions act = new Actions(getWebDriver());
        act.moveToElement(getWebElement(designmap.get("nodeDetails"))).click().build().perform();

    }
    public void deleteChildNode(){
        getWebElement(treemap.get("deletenode")).click();
        waitForSeconds(1);
    }
    public void deleteParentNodeMultipleChild(){
        getWebElement(treemap.get("deletenode")).click();
        alertPopup();
    }
    public void deleteParentSingleChild(){
        getWebElement(treemap.get("deletenode")).click();
        getWebElement(treemap.get("yesparent")).click();
        waitForSeconds(2);
    }
    public void deleteParentReplaceChild(){
        getWebElement(treemap.get("deletenode")).click();
        getWebElement(treemap.get("noparent")).click();
        waitForSeconds(1);
    }
    public void undoAction(){
        getWebElement(designmap.get("undoaction")).click();
        waitForSeconds(1);
    }
    public void redoAction(){
        getWebElement(designmap.get("redoaction")).click();
        waitForSeconds(1);
    }
    public void navigateDesignModule(){
        getWebElement(treemap.get("navigatedesign")).click();
    }

}
