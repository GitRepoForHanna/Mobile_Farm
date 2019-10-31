package api.request;

public enum Headers {

    AUTHORIZATION("Authorization"),
    CONTENT_TYPE("Content-Type");

    private String header;

    Headers(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
