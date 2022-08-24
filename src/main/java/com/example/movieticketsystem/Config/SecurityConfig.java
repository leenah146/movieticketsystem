package com.example.movieticketsystem.Config;
import com.example.movieticketsystem.Services.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/movie/register","/api/v1/movie/show","/api/v1/movie/days","/api/v1/movie/genre").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/movie/userad").hasAuthority("Admin")
                .antMatchers(HttpMethod.POST,"/api/v1/movie/mov","/api/v1/meal").hasAuthority("Admin")
                .antMatchers(HttpMethod.PUT,"/api/v1/movie/mov","/api/v1/meal").hasAuthority("Admin")
                .antMatchers(HttpMethod.DELETE,"/api/v1/movie/mov","/api/v1/meal","/api/v1/movie/user").hasAuthority("Admin")
                .antMatchers(HttpMethod.POST,"/api/v1/book").hasAuthority("User")
                .antMatchers(HttpMethod.PUT,"/api/v1/book").hasAuthority("Admin")
                .antMatchers(HttpMethod.DELETE,"/api/v1/book").hasAuthority("User")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
