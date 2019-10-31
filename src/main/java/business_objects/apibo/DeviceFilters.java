package business_objects.apibo;

import java.util.function.BiPredicate;

public class DeviceFilters {

    public static BiPredicate<Device, String> byManufacturer = (device, manufacturer) -> device.getDeviceName().trim().toLowerCase().startsWith(manufacturer);
    public static BiPredicate<Device, String> byDeviceName = (device, deviceName) -> device.getDeviceName().equalsIgnoreCase(deviceName);
    public static BiPredicate<Device, String> byBrowserName = (device, browserName) -> device.getDeviceName().equalsIgnoreCase(browserName);
}
