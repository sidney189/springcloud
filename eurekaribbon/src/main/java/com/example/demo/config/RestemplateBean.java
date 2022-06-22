package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableOAuth2Client
public class RestemplateBean {

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }

    @Autowired
    private OAuth2ClientContext oauth2Context;

    @Bean
    public OAuth2ProtectedResourceDetails credentials() {

        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri("https://localhost:9007/oauth/token");
        details.setClientId("client");
        details.setClientSecret("secret");
        details.setGrantType("password");

        return details;
    }

    @Bean
    @LoadBalanced
    public OAuth2RestTemplate externalServiceRestTemplate() {
        return new OAuth2RestTemplate(credentials(), oauth2Context);
    }


}
