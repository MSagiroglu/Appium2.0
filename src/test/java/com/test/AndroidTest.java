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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
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
        longPress(driver, el4, 2);


    }

    @Test
    public void zoom() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("Android-Mustafa-Device");
        options.setApp(System.getProperty("user.dir") + "/App/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]"))
                .click();
        WebElement drawingArea = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]"));
        zoomMove(driver, drawingArea);

    }


    @Test
    void swipeOrScroll() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("Android-Mustafa-Device");
        options.setApp(System.getProperty("user.dir") + "/App/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();

        swipe(driver, 2);


        //Assertion
    }

    @Test
    void dragAndDrop() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("Android-Mustafa-Device");
        options.setApp(System.getProperty("user.dir") + "/App/ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
        driver.findElement(AppiumBy.xpath(".//*[@text='Drag and Drop']")).click();

        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

        Point centerOfSource = getCentesrOfElement(source.getLocation(), source.getSize());
        Point centerOfTarget = getCentesrOfElement(target.getLocation(), target.getSize());

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfSource))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), centerOfTarget))
                        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    private void swipe(AndroidDriver driver, int time) {
        for (int i = 0; i < time; i++) {
            Dimension size = driver.manage().window().getSize();
            int startX = size.getWidth() / 2;
            int startY = size.getHeight() / 2;
            int endX = startX;
            int endY = (int) (size.getHeight() * 0.25);
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));
        }
    }

    private Point getCentesrOfElement(Point location, Dimension size) {//--> elementin merkez noktasını bulan method
        Point point = new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
        return point;
    }


    private void zoomMove(AndroidDriver driver, WebElement element) throws InterruptedException {
        Point centerOfElement = getCentesrOfElement(element.getLocation(), element.getSize());
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        Sequence sequence1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200),
                        PointerInput.Origin.viewport(), centerOfElement.getX() + 100,
                        centerOfElement.getY() - 100))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200),
                        PointerInput.Origin.viewport(), centerOfElement.getX() - 100,
                        centerOfElement.getY() + 100))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Thread.sleep(2000);
        driver.perform(Arrays.asList(sequence1, sequence2));
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

    private void longPress(AndroidDriver driver, WebElement element, int time) {//--> elementin üstüne belirli bir süre basmaya yarayan method
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
