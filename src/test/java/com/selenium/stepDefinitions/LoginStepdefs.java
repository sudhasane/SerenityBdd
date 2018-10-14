package com.selenium.stepDefinitions;

import com.selenium.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by sudha on 08/10/2018.
 */
public class LoginStepdefs {
    private LoginPage loginPage;

    @Given("^I am on face book home page$")
    public void  I_am_on_face_book_home_page(){
        loginPage.open();
    }


    @And("^I enter username and password$")
    public void iEnterUsernameAndPassword() throws Throwable {
        //loginPage.enterUnAndPw("sudha","123");
        loginPage.printList();
    }


    @And("^I select Login$")
    public void iSelectLogin() throws Throwable {
        loginPage.clickLogin();
    }
}
