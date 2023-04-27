package br.com.sisnema.banco.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Autowired
    private JwtTokenStore tokenStore;

    private static final String[] PUBLIC = { "/", "/oauth/token", "/h2/**", "/swagger-ui/**", "/v3/api-docs/**" };

    private static final String[] OPERATOR_STUDENT_ADMIN = { "/v1/clientes/**", "/v1/enderecos/**", "/v1/contas/**", "/v1/tipocontas/**" };

    private static final String[] ADMIN = { "/v1/usuarios/**", "/v1/funcoes/**" };

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // Liberação do H2
        if (Arrays.asList(environment.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        // Autorizações das rotas
        http.authorizeRequests().antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR_STUDENT_ADMIN).permitAll()
                .antMatchers(OPERATOR_STUDENT_ADMIN).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();
    }

}
