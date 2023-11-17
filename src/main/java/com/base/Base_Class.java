package com.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Base_Class {

    public static WebDriver driver;

    public static void confirmalert_accept(WebDriver driver) {

        Alert a = driver.switchTo().alert();
        a.accept();
    }

    public static void confirmalert_dismiss(WebDriver driver) {
        Alert a = driver.switchTo().alert();
        a.dismiss();
    }

    public static void prompt_alert(WebDriver driver, String value) {
        Alert a = driver.switchTo().alert();
        a.sendKeys(value);
    }

    public static void switch_frame_by_webelement(WebDriver driver, WebElement ele) {
        driver.switchTo().frame(ele);
    }

    public static void switch_parent_frame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public void switch_default_content(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static void actions_click(WebDriver driver, WebElement ele) {
        Actions a = new Actions(driver);
        a.click(ele).build().perform();
    }

    public static void actions_rightclick(WebDriver driver, WebElement ele) {
        Actions a = new Actions(driver);
        a.contextClick(ele).build().perform();
    }

    public static void actions_doubleclick(WebDriver driver, WebElement ele) {
        Actions a = new Actions(driver);
        a.doubleClick(ele).build().perform();
    }

    public static void actions_dragdrop(WebDriver driver, WebElement src, WebElement des) {
        Actions a = new Actions(driver);
        a.dragAndDrop(src, des).build().perform();
    }

    public static void actions_dragmove(WebDriver driver, WebElement src, WebElement des) {
        Actions a = new Actions(driver);
        a.clickAndHold(src).moveToElement(des).release().build().perform();
    }

    public static void robot() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
    }

    public static void select_byindex(WebElement ele, int value) {
        Select s = new Select(ele);
        s.selectByIndex(value);
    }

    public static void select_byvalue(WebElement ele, String value) {
        Select s = new Select(ele);
        s.selectByValue(value);
    }

    public static void select_byvisibletext(WebElement ele, String value) {
        Select s = new Select(ele);
        s.selectByVisibleText(value);
    }

    public static void select_alloptions(WebElement ele) {
        Select s = new Select(ele);
        java.util.List<WebElement> options = s.getOptions();
        for (WebElement o : options) {
            System.out.println(o.getText());
        }

    }

    public static void deselect_byindex(WebElement ele, int value) {
        Select s = new Select(ele);
        s.deselectByIndex(value);
    }

    public static void deselect_byvalue(WebElement ele, String value) {
        Select s = new Select(ele);
        s.deselectByValue(value);
    }

    public static void deselect_byvisibletext(WebElement ele, String value) {
        Select s = new Select(ele);
        s.deselectByVisibleText(value);
    }

    public static void select_selectedoptions(WebElement ele) {
        Select s = new Select(ele);
        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
        for (WebElement o : allSelectedOptions) {
            System.out.println(o.getText());
        }
    }

    public static void switch_windowhandle(WebDriver driver) {
        String parent = driver.getWindowHandle();
        Set<String> all = driver.getWindowHandles();
        for (String o : all) {
            if (o.equals(parent)) {
                continue;
            }
            else {
                driver.switchTo().window(o);
            }
        }

    }

    public static void chromeoptions_incognito(String value, String link) {
        ChromeOptions o = new ChromeOptions();
        o.addArguments(value);
        WebDriver driver = new ChromeDriver(o);
        driver.get(link);
    }

    public static void screenshot(WebDriver driver, String path) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File(path);
        FileUtils.copyFile(src, des);
    }

    public static void scrollIntoView(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()", ele);
    }

    public static void scrolldown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public static void scrollup(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)");
    }

    public static void javascript_click(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", ele);
    }



    public static void implicit_wait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void pageloadout_wait(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }





}
