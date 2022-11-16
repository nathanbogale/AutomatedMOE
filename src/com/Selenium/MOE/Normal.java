package com.Selenium.MOE;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Normal {

    public static void main(String[] args) throws InterruptedException, IOException {

//READING FILES
//LOGIN
        List<String> loginFile = new ArrayList<String>(); // create array for employees
        Scanner loginsc = new Scanner(new FileReader("C:\\Users\\natha\\IdeaProjects\\SeleniumMOE\\out\\artifacts\\SeleniumMOE_jar\\un_pass.txt"));
        String loginstr;
        while (loginsc.hasNext()){
            loginstr = loginsc.next();
            loginFile.add(loginstr);
        }
        String[] loginarray = loginFile.toArray(new String[0]);
        String read_un = loginarray[0];//this is the name of the second employee in the array
        String read_pass = loginarray[1];//this is the name of the second employee in the array
        System.out.println(read_un);
        System.out.println(read_pass);

//INSTITUTION DATA
        List<String> instFile = new ArrayList<String>(); // create array for employees
        Scanner instscnr = new Scanner(new FileReader("C:\\Users\\natha\\IdeaProjects\\SeleniumMOE\\out\\artifacts\\SeleniumMOE_jar\\institution_name.txt"));
        String inststr;
        while (instscnr.hasNext()){
            inststr = instscnr.next();
            instFile.add(inststr);
        }
        String[] instarray = instFile.toArray(new String[0]);
        String iso = instarray[0];
        String regionname = instarray[1];
        String regioncode = instarray[2];
        String endorser = instarray[3];
        System.out.println(iso);
        System.out.println(regionname);
        System.out.println(regioncode);
        System.out.println(endorser);

//initial setup
        System.out.println("Lets start it up");
        WebDriver obj = new ChromeDriver();
        obj.manage().window().maximize();
        obj.manage().deleteAllCookies();
        obj.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        obj.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//pening the main page
        obj.get("https://qa.deid.moe.gov.et");

//Logging in
//MISTAKE
       // Thread.sleep(2000);
        WebElement username= obj.findElement(By.id("login_username"));
        username.sendKeys(read_un);
        obj.findElement(By.id("login_password")).sendKeys(read_pass);
        Thread.sleep(2000);
        obj.findElement(By.className("style_secondary__3WV1y")).click();
       //  Thread.sleep(2000);

      //   Thread.sleep(2000);
//going to insttutions
        obj.findElement(By.linkText("Institutions")).click(); //to click on a link
     //   Thread.sleep(2000);
        obj.findElement(By.className("ant-dropdown-trigger")).click();
        obj.findElement(By.linkText("Region")).click(); //to click on a link
//inserting insttution creation data
        obj.findElement(By.id("region_isoCode")).sendKeys(iso);
        obj.findElement(By.id("region_name")).sendKeys(regionname);
        obj.findElement(By.id("region_code")).sendKeys(regioncode);
        obj.findElement(By.id("region_category")).click();
        obj.findElement(By.xpath("//div[@title='Regional State']")).click();
        obj.findElement(By.id("region_endorserId")).sendKeys(endorser);

        //obj.findElement(By.className("ant-btn-default")).submit();
        // Thread.sleep(6000);
        //  obj.findElement(By.xpath("//contains[@value='Create']")).submit();
        //   obj.findElement(By.xpath("//contains[text()='Create']")).submit();
        //  obj.findElement(By.xpath("//input[@type='submit']")).submit();
        //   obj.findElement(By.cssSelector(".ant-btn .ant-btn-default .ant-btn-round")).submit();
        //  obj.findElement(By.cssSelector("button[type=submit]")).click();
        obj.findElement(By.id("region_name")).submit();

     //  Thread.sleep(2000);
        obj.findElement(By.className("style_Text__3N9Mn")).click();
       // Thread.sleep(2000);

        obj.findElement(By.className("style_Button__1iPLw")).click();
        obj.findElement(By.id("recover_adminCode")).sendKeys("I forgot to copy it!! ayayay");
        obj.findElement(By.id("recover_password")).sendKeys("I forgot to copy it!! ayayay");

        obj.findElement(By.className("style_Popover__1c6Zm")).click();
        obj.findElement(By.className("style_ProfileMenuItem__2vHPV")).click();
         obj.findElement(By.xpath("//span[@value='View my profile']")).click();
           obj.findElement(By.xpath("//span[@text='View my profile']")).click();

       // Thread.sleep(2000);

        obj.findElement(By.className("style_Popover__1c6Zm")).click();
        // obj.findElement(By.cssSelector("anticon-logout")).click();

        WebElement myElement = obj.findElement(By.className("anticon-logout"));
        WebElement parent = (WebElement) ((JavascriptExecutor) obj).executeScript(
                "return arguments[0].parentNode;", myElement);
        WebElement parent_element = obj.findElement(By.xpath("./.."));

        obj.findElement(By.className("style_Label__OdpkT")).click();

        //      System.out.println(parent_element);
    }
}
