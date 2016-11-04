package Appium.com.khushi;

import org.testng.annotations.Test;

import com.pages.login;

public class LoginTest extends login {

  @Test(priority = 1)
  public void Login() {

    successful_login();
  }

}
