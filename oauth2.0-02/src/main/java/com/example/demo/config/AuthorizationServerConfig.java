package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManagerBean;
    @Autowired
    private UserDetailsService userDetailsServiceBean;

    //配置客户端详情信息
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //内存存储
        clients.inMemory()
                //client_id
                .withClient("client")
                //client_secret
                .secret("secret")
                //授权类型
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                //授权范围
                //配置申请的权限范围
                .scopes("webclient", "mobileclient");
    }

    //配置授权以及令牌的访问端点和令牌服务
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManagerBean)
                .userDetailsService(userDetailsServiceBean);
    }
}
