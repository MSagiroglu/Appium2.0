package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class AndroidTest {

    //https://github.com/saucelabs/my-demo-app-rn/releases --> application
    //appium --use-plugins=element-wait
    //appium --allow-cors
    @Test
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Android-Mustafa-Device");
        options.setApp(System.getProperty("user.dir") + "/App/Android-MyDemoAppRN.1.3.0.build-244.apk");
        //Thread.sleep(4000) ;
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        //Thread.sleep(4000) ;
        WebElement el1 = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
        el1.click();
        //Thread.sleep(3000);
        WebElement el2 = (WebElement) driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        el2.click();
        //Thread.sleep(3000);
        WebElement el3 = (WebElement) driver.findElement(AppiumBy.accessibilityId("Username input field"));
        el3.click();
        //Thread.sleep(3000);
        el3.sendKeys("Mustafa");
        WebElement el4 = (WebElement) driver.findElement(AppiumBy.accessibilityId("Password input field"));
        el4.click();
        el4.sendKeys("Mustafa");
        driver.navigate().back();
        WebElement el5 = (WebElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]/android.widget.TextView"));
        el5.click();
    }

    @Test
    public void tap() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Android-Mustafa-Device");
        options.setApp(System.getProperty("user.dir") + "/App/Android-MyDemoAppRN.1.3.0.build-244.apk");
        //Thread.sleep(4000) ;
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        //Thread.sleep(4000) ;
        WebElement openMenu = (WebElement) driver.findElement(AppiumBy.accessibilityId("open menu"));
        tap(driver, openMenu, 200);

    }
    @Test
    public void doubleTap() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Android-Mustafa-Device");
        options.setApp(System.getProperty("user.dir") + "/App/Android-MyDemoAppRN.1.3.0.build-244.apk");
        //Thread.sleep(4000) ;
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        //Thread.sleep(4000) ;
        WebElement openMenu = (WebElement) driver.findElement(AppiumBy.accessibilityId("open menu"));
        doubleTap(driver, openMenu);

    }
    @Test
    public void longPress() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Android-Mustafa-Device");
        options.setApp(System.getProperty("user.dir") + "/App/ApiDemos-debug.apk");
        //Thread.sleep(4000) ;
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebElement el1 = driver.findElement(AppiumBy.accessibilityId("Views"));
        el1.click();
        WebElement el2 = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
        el2.click();
        WebElement el3 = driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));
        el3.click();
        WebElement el4 = driver.findElement(AppiumBy.xpath("//*[@text='People Names']"));
        longPress(driver,el4,2);


    }

    private void tap(AndroidDriver driver, WebElement element, int time) {//--> elementin üstüne belirli bir süre basmaya yarayan method
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCentesrOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(time)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }

    private Point getCentesrOfElement(Point location, Dimension size) {//--> elementin merkez noktasını bulan method
        Point point = new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
        return point;
    }

    private void doubleTap(AndroidDriver driver, WebElement element) {//--> elementin üstüne çift tıklamaya yarayan method
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCentesrOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }
    private void longPress(AndroidDriver driver, WebElement element,int time) {//--> elementin üstüne belirli bir süre basmaya yarayan method
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerOfElement = getCentesrOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(time)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }
}
