package business_objects.apibo;

public class Device {

    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String udid;

    public Device() {
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getUdid() {
        return udid;
    }
}
