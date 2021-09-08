package io.carwash.admin;

import io.carwash.admin.service.AdminService;
//import io.carwash.admin.service.JwtFilterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class security extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminService userDetailsService;

//    @Autowired
//    private JwtFilterReq jwtFilterReq;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("*.js")
                .antMatchers("*.css");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/admin/test").fullyAuthenticated()
                .anyRequest().permitAll().and().httpBasic();
//                .antMatchers("/admin/authenticate").permitAll()
//                .antMatchers("/admin/test").permitAll()
//                .antMatchers("/admin/create").permitAll()
//                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                .anyRequest().authenticated().and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       // http.addFilterBefore(jwtFilterReq, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Administrator").password("CarWashAdmin").roles("ADMIN");
    }



}