package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class ApiService {

    public static final String MULTIPART_CONTENT_TYPE = "multipart/form-data";
    public static final String JSON_CONTENT_TYPE = "application/json";

    private static RequestSpecification createRequestSpecification(RequestBuilder.Request request) {
        RequestSpecification requestSpecification = new RequestSpecBuilder().build();
        requestSpecification.baseUri(request.getBaseURI());
        requestSpecification.basePath(request.getBasePath());
        requestSpecification.contentType(request.getContentType());
        requestSpecification.params(request.getParameters());
        requestSpecification.headers(request.getHeaders());
        requestSpecification.body(request.getBody());
        return requestSpecification;
    }

    private static RequestSpecification createRequestSpecificationWithMultiPart(RequestBuilder.Request request, File file) {
        return createRequestSpecification(request).multiPart(file);
    }

    public static Response executeRequest(RequestBuilder.Request request, Method method) {
        RequestSpecification specification = createRequestSpecification(request);
        return RestAssured.given(specification).relaxedHTTPSValidation().request(method);
    }

    public static Response executeUploadRequest(RequestBuilder.Request request, File file) {
        RequestSpecification specification = createRequestSpecificationWithMultiPart(request, file);
        return RestAssured.given(specification).relaxedHTTPSValidation().request(Method.POST);
    }

    public static Response executeGetMethod(RequestBuilder.Request request) {
        return executeRequest(request,Method.GET);
    }

    public static Response executePostMethod(RequestBuilder.Request request) {
        return executeRequest(request,Method.POST);
    }

    public static Response executePutMethod(RequestBuilder.Request request) {
        return executeRequest(request,Method.PUT);
    }

    public static Response executeDeleteMethod(RequestBuilder.Request request) {
        return executeRequest(request,Method.DELETE);
    }
}
