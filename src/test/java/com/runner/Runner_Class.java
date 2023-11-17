package com.runner;

import com.base.Base_Class;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\parabank.feature",
        glue = "",monochrome = false,
        dryRun = false)


public class Runner_Class extends Base_Class {

    @BeforeClass
    public static void start()
    {
       driver = new ChromeDriver();

            }

}
