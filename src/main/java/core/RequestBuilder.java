package core;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private Request request;

    public class Request {
        private String baseURI;
        private String basePath;
        private String contentType;
        private String body;
        private Map<String,?> parameters = new HashMap<>();
        private Map<String,String> headers = new HashMap<>();

        private Request() {
        }

        public String getBaseURI() {
            return baseURI;
        }

        public void setBaseURI(String baseURI) {
            this.baseURI = baseURI;
        }

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Map<String, ?> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, ?> parameters) {
            this.parameters = parameters;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "baseURI='" + baseURI + '\'' +
                    ", basePath='" + basePath + '\'' +
                    ", contentType=" + contentType +
                    ", body='" + body + '\'' +
                    ", parameters=" + parameters +
                    ", headers=" + headers +
                    '}';
        }
    }

    public RequestBuilder() {
        this.request = new Request();
    }

    public RequestBuilder withBaseURI(String baseURI) {
        request.setBaseURI(baseURI);
        return this;
    }

    public RequestBuilder withBasePath(String basePath) {
        request.setBasePath(basePath);
        return this;
    }

    public RequestBuilder withContentType(String contentType) {
        request.setContentType(contentType);
        return this;
    }

    public RequestBuilder withBody(String body) {
        request.setBody(body);
        return this;
    }

    public RequestBuilder withHeaders(Map<String, String> headers) {
        request.setHeaders(headers);
        return this;
    }

    public RequestBuilder withParameters(Map<String, Object> parameters) {
        request.setParameters(parameters);
        return this;
    }

    public Request build() {
        return request;
    }
}
