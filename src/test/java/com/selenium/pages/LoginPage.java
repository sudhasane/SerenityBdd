package com.selenium.pages;


import net.thucydides.core.annotations.DefaultUrl;
import org.fluentlenium.core.wait.FluentWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


@DefaultUrl("https://www.facebook.com")
public class LoginPage extends PageObjectClient {


    @FindBy(id = "#email")
    private WebElement email;

    @FindBy(id="#pass")
    private WebElement password;

    @FindBy(id="#loginbutton")
    private WebElement loginButton;

    public void gToHomePage(){
        getDriver().get("https://www.facebook.com/");
    }

    public void enterUnAndPw(String Uname, String Pword){

        sendText(email, Uname);
        sendText(password, Pword);

    }

    public void clickLogin(){
        clickButton(loginButton);

    }



    public void printList(){
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(0);
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(30);


        List<Integer> l2 = l1.stream().map(I -> I*2).collect(Collectors.toList());
        System.out.println(l2);
        List<Integer> l3 = l1.stream().filter(I->I%2 ==0).collect(Collectors.toList());
        System.out.println(l3);
    }



}
