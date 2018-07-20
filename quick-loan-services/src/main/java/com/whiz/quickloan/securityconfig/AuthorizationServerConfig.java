package com.whiz.quickloan.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.whiz.quickloan.user.services.QuickLoanUserDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static String REALM="MY_OAUTH_REALM";
    
    @Autowired
    private TokenStore tokenStore;
 
    @Autowired
    private UserApprovalHandler userApprovalHandler;
    
    @Autowired 
	private QuickLoanUserDetailsService crmUserDetailsService;
 
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
 
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
 
        clients.inMemory()
            .withClient("myapp")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("read", "write", "trust")
            .secret("secret")
            .accessTokenValiditySeconds(600).//Access token is only valid for 2 minutes.
            refreshTokenValiditySeconds(24*60*60);//Refresh token is only valid for 10 minutes.
    }
 
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager)
                .userDetailsService(crmUserDetailsService);
    }
 
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    	oauthServer.allowFormAuthenticationForClients();
    	//oauthServer.realm(REALM+"/client");
    }

}
