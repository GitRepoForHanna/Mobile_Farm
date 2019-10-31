package api.service.mobile_farm;

import api.request.Headers;
import api.request.Parameters;
import api.request.Platform;
import business_objects.apibo.AvailableDevice;
import business_objects.apibo.Device;
import core.ApiService;
import core.RequestBuilder;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import utils.serialization.DeserializationUtils;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

import static api.request.Platform.ANDROID;
import static api.service.mobile_farm.MobileFarmConstants.*;
import static core.ApiService.JSON_CONTENT_TYPE;
import static core.ApiService.MULTIPART_CONTENT_TYPE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class MobileFarmService {

    public static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(Headers.AUTHORIZATION.getHeader(), AUTHORISATION_KEY);
        headers.put(Headers.CONTENT_TYPE.getHeader(), JSON_CONTENT_TYPE);
        return headers;
    }

    public static Map<String, String> getDefaultMultipartHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(Headers.AUTHORIZATION.getHeader(), AUTHORISATION_KEY);
        headers.put(Headers.CONTENT_TYPE.getHeader(), MULTIPART_CONTENT_TYPE);
        return headers;
    }

    public static RequestBuilder.Request createRequest(String basePath) {
        return new RequestBuilder()
                .withBaseURI(BASE_URI)
                .withBasePath(basePath)
                .withHeaders(getDefaultHeaders())
                .withBody("")
                .build();
    }

    public static RequestBuilder.Request createRequest(String basePath, String contentType) {
        RequestBuilder.Request request = createRequest(basePath);
        request.setContentType(contentType);
        return request;
    }

    public static RequestBuilder.Request createRequest(String basePath, Platform platform, Map<String, String> headers) {
            String path = StringUtils.join(basePath, "/", platform.getPlatform());
            return new RequestBuilder()
                    .withBaseURI(BASE_URI)
                    .withBasePath(path)
                    .withContentType(JSON_CONTENT_TYPE)
                    .withHeaders(headers)
                    .withBody("")
                    .build();
    }

    public static RequestBuilder.Request createRequest(String basePath, Platform platform) {
        return createRequest(basePath, platform, getDefaultHeaders());
    }

    public static RequestBuilder.Request createAndroidRequest(String basePath) {
        return createRequest(basePath, ANDROID, getDefaultHeaders());
    }

    public static RequestBuilder.Request createUploadRequest(String basePath) {
        return new RequestBuilder().withBaseURI(BASE_URI)
                .withBasePath(basePath)
                .withHeaders(getDefaultMultipartHeaders())
                .withBody("")
                .withContentType(MULTIPART_CONTENT_TYPE)
                .build();
    }

    private static void validateStatusCode(Response response, int statusCode, String errorMessage) {
        if(response.statusCode() != statusCode) {
            throw new RuntimeException(errorMessage);
        }
    }

    public static List<AvailableDevice> getAvailableDevices(Platform platform, int platformVersion) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put(Parameters.VERSION.getParameter(), platformVersion);
        RequestBuilder.Request request = createRequest(DEVICE_PATH, platform);
        request.setParameters(parameters);
        Response response = ApiService.executeGetMethod(request);
        validateStatusCode(response, OK.value(), "Get available devices request was not successful!");
        Logger.getLogger(MobileFarmService.class).info("Available Devices are got");
        return Arrays.asList(DeserializationUtils.deserializeObject(response.getBody().print(), AvailableDevice[].class));
    }

    public static void bookDevice(Platform platform, String udid) {
        String basePath = StringUtils.join(DEVICE_PATH, "/" + udid);
        RequestBuilder.Request request = createRequest(basePath, JSON_CONTENT_TYPE);
        Response response = ApiService.executePostMethod(request);
        validateStatusCode(response, OK.value(), String.format("Attempt to book device with udid %s was not successful for some reason",udid));
        Logger.getLogger(MobileFarmService.class).info("Device was booked");
    }

    public static void installApk(String udid, File file) {
        String basePath = StringUtils.join(STORAGE_PATH, INSTALL_PATH, "/", udid);
        RequestBuilder.Request request = createUploadRequest(basePath);
        Response response = ApiService.executeUploadRequest(request, file);
        validateStatusCode(response, CREATED.value(), "Apk was not installed");
        Logger.getLogger(MobileFarmService.class).info("Apk was installed");
    }

    public static String getRandomUdid(List<AvailableDevice> devices) {
        return devices.stream()
                .map(AvailableDevice::getDesiredCapabilities)
                .map(Device::getUdid)
                .limit(1)
                .findAny().get();
    }

    public static String getUdid(List<AvailableDevice> devices, BiPredicate predicate, String value) {
        return devices.stream()
                .map(AvailableDevice::getDesiredCapabilities)
                .filter(device -> predicate.test(device, value))
                .map(Device::getUdid)
                .limit(1)
                .findAny().get();
    }

    public static String getDeviceName(List<AvailableDevice> devices, String udid) {
        return devices.stream()
                .map(AvailableDevice::getDesiredCapabilities)
                .filter(device -> device.getUdid().equalsIgnoreCase(udid))
                .map(Device::getDeviceName)
                .findAny().get();
    }

    public static String getPlatformVersion(List<AvailableDevice> devices, String udid) {
        return devices.stream()
                .map(AvailableDevice::getDesiredCapabilities)
                .filter(device -> device.getUdid().equalsIgnoreCase(udid))
                .map(Device::getPlatformVersion)
                .findAny().get();
    }
}
