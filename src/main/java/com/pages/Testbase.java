package com.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.util.Propertyloader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class Testbase {
  // WebDriver driver;
  AndroidDriver<MobileElement> driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {

    String device_name = Propertyloader.loadProperty("device_name");
    String android_version = Propertyloader.loadProperty("android_version");
    String apk_path = Propertyloader.loadProperty("apk_path");
    String app_package = Propertyloader.loadProperty("app_package");
    String app_activity = Propertyloader.loadProperty("app_activity");
    String remote_url = Propertyloader.loadProperty("remote_url");

    // Created object of DesiredCapabilities class.
    DesiredCapabilities capabilities = new DesiredCapabilities();

    // Set android deviceName desired capability. Set your device name.
    capabilities.setCapability("deviceName", device_name);

    // Set BROWSER_NAME desired capability. It's Android in our case here.
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

    // Set android VERSION desired capability. Set your mobile device's OS
    // version.
    capabilities.setCapability(CapabilityType.VERSION, android_version);

    // Set android platformName desired capability. It's Android in our case
    // here.
    capabilities.setCapability("platformName", "Android");

    // Set android appPackage desired capability. It is
    // com.android.calculator2 for calculator application.
    // Set your application's appPackage if you are using any other app.
    capabilities.setCapability("app", apk_path);
    capabilities.setCapability("appPackage", app_package);

    // Set android appActivity desired capability. It is
    // com.android.calculator2.Calculator for calculator application.
    // Set your application's appPackage if you are using any other app.
    capabilities.setCapability("appActivity", app_activity);

    // Created object of RemoteWebDriver will all set capabilities.
    // Set appium server address and port number in URL string.
    // It will launch calculator app in android device.
    // driver = new RemoteWebDriver(new URL(remote_url), capabilities);
    driver = new AndroidDriver<MobileElement>(new URL(remote_url), capabilities);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

  }

  public void click(By locator) {

    driver.findElement(locator).click();
  }

  public void entertext(By locator, String text) {

    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

}
