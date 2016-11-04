package com.pages;

import org.openqa.selenium.By;

import com.pageelements.Loginpageelements;

import junit.framework.Assert;

public class login extends Testbase {

  public void successful_login() {

    System.out.println("Inside sum");

    entertext(Loginpageelements.email, "akshay.khadse@arrkgroup.com");
    entertext(Loginpageelements.password, "admin@123");
    click(Loginpageelements.signin);

    String result = driver.findElement(By.id("com.example.akshayk.myapplication:id/textView2")).getText();
    System.out.println(result);
    Assert.assertTrue(result.contains("Hello"));

  }
}
