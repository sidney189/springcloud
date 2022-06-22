package com.example.demo;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ServiceHiZuulFallbackProvider implements ZuulFallbackProvider {


    @Override
    public String getRoute() {
        // 注意： 这里是route的名称，而不是服务的名称
        // 如果这里写成大写USERSERVICE，则将无法起到回退作用
        return "service-hi";
    }
    @Override
    public ClientHttpResponse fallbackResponse() {
        // 创建一个Fallback响应
        return new ClientHttpResponse() {
            // 实现响应的状态、状态码的定义
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }
            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }
            @Override
            public void close() {
            }
            // 针对回退，构建了一个Fake用户信息
            @Override
            public InputStream getBody() throws IOException {
                String mockUserJson = "{\n" +
                        "  \"id\": -3, \n" +
                        "  \"nickname\": \"fakeUser\", \n" +
                        "  \"avatar\": \"/users/avatar/user.png\"\n" +
                        "}";
                return new ByteArrayInputStream(mockUserJson.getBytes());
            }
            @Override
            public HttpHeaders getHeaders() {
                // 需要将返回的格式设置为JSON
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
