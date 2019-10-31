package mobile_farm;

import api.request.Platform;
import api.service.mobile_farm.MobileFarmService;
import business_objects.apibo.AvailableDevice;
import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import steps.*;
import utils.android_driver.AndroidDriverSingletone;
import utils.dependency_injection.ConfigurationModule;

import java.io.File;
import java.util.List;

import static api.request.Platform.ANDROID;

@Guice(modules = ConfigurationModule.class)
public class BaseTestClass {

    protected String udid;
    protected String deviceName;
    protected int platformVersion = 8;
    protected Platform platform = ANDROID;
    protected AndroidDriverSingletone instance;
    protected AppiumDriver driver;

    private static final String API_KEY = "d41951f2-00ae-4775-843a-9fb7ca4e30c3";
    private static final String APPIUM_HUB = "mobilecloud.epam.com";
    private static final String PLATFORM_NAME = "Android";

    @Inject
    protected BaseEmulatorPageSteps baseEmulatorPageSteps;
    @Inject
    protected HomePageSteps homePageSteps;
    @Inject
    protected NoteTypePopupSteps noteTypePopupSteps;
    @Inject
    protected NotePageSteps notePageSteps;
    @Inject
    protected EditNotePageSteps editNotePageSteps;

    @BeforeTest
    public void createInstance() {
        instance = AndroidDriverSingletone.createInstance(getAvailableDevices());
        driver = instance.getDriver();
    }

    public BaseTestClass() {
//        baseEmulatorPageSteps = new BaseEmulatorPageSteps();
//        homePageSteps = new HomePageSteps();
//        noteTypePopupSteps = new NoteTypePopupSteps();
//        notePageSteps = new NotePageSteps();
//        editNotePageSteps = new EditNotePageSteps();
    }

    public DesiredCapabilities getAvailableDevices() {
        List<AvailableDevice> availableDevices = MobileFarmService.getAvailableDevices(platform, platformVersion);
        udid = MobileFarmService.getRandomUdid(availableDevices);
        deviceName = MobileFarmService.getDeviceName(availableDevices, udid);
        String platformVersion = MobileFarmService.getPlatformVersion(availableDevices, udid);
        MobileFarmService.bookDevice(ANDROID, udid);
        MobileFarmService.installApk(udid, new File("C:\\HannasWorkshop\\mobApps\\TestApp.apk"));


        System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jdk1.8.0_221\\jre\\lib\\security\\cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("appPackage", "com.socialnmobile.dictapps.notepad.color.note");
        capabilities.setCapability("appActivity", "com.socialnmobile.colornote.activity.Main");
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return capabilities;
    }

    @AfterTest
    public void after() {
        instance.closeDriver();
    }
}
