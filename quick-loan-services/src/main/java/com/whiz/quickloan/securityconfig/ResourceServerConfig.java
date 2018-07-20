package com.whiz.quickloan.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/*private static final String RESOURCE_ID = "my_rest_api";
    
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }*/
 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/**").permitAll();
        /*.authorizeRequests()
        .antMatchers("/api/customer/**").access("hasRole('CUSTOMER')")
        .antMatchers("/api/investor/**").access("hasRole('INVESTOR')")
        .antMatchers("/**").access("hasRole('USER')")
        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());*/
    }

}
