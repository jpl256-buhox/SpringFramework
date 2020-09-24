package mx.com.cfe.cfecontigo.auth.server.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import mx.com.cfe.cfecontigo.auth.server.service.UserDetailsServiceImpl;

@Configuration
@EnableAuthorizationServer
public class SecurityOAuth2Configuration extends AuthorizationServerConfigurerAdapter {



	public static final String RESOURCEID = "auth-server";
	public static final String APPCLIENT = "cfe-contigo-client";
	public static final String APPSECRET = "cf3-contigo-s3cr3t";

	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	
	
	
	
	@Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                   .checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
                clients.inMemory()
               .withClient(APPCLIENT)
                       .secret(APPSECRET)
                       .accessTokenValiditySeconds(15768000)        // expire time for access token
                       .refreshTokenValiditySeconds(17064000)         // expire time for refresh token
               .scopes("read", "write", "trust")                         // scope related to resource server
                       .authorizedGrantTypes("password", "refresh_token");      // grant type
    }
	
	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
        .userDetailsService(userDetailsServiceImpl)
		.tokenStore(tokenStore());
    }
	
	
	
}
