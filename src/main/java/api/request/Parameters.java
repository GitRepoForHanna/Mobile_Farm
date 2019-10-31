package api.request;

public enum Parameters {
    VERSION("version"),
    MODEL("model"),
    TYPE("type"),
    MANUFACTURER("manufacturer"),
    WEB("web"),
    OWNER("owner");

    private String parameter;

    Parameters(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
