package api.request;

public enum Platform {
    ANDROID("android"),
    IOS("ios");

    private String platform;

    Platform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}
