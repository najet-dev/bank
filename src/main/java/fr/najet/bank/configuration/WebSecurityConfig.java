package fr.najet.bank.configuration;

import fr.najet.bank.jwt.AuthEntryPointJwt;
import fr.najet.bank.jwt.AuthTokenFilter;
import fr.najet.bank.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired(required=true)
  UserDetailsServiceImpl userDetailsService;

  @Autowired(required=true)
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
      throws Exception {
    authenticationManagerBuilder.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers("/api/auth/signin").permitAll()
        //.antMatchers("/transfer").permitAll()
        //.authorizeRequests().antMatchers("/api/auth/**").permitAll()
        .antMatchers("/api/test/**").permitAll()
        .antMatchers("/api/auth/signup").permitAll()
        .antMatchers("/{accountId}/pageOperations").permitAll()
        .antMatchers("/accounts").permitAll()
        .antMatchers("/credit").permitAll()
        .antMatchers("/account/user/{id}").permitAll()
        .antMatchers("/{account}/{id}").permitAll()
        .antMatchers("/transfer").permitAll()
        .anyRequest().authenticated();

    http.addFilterBefore(authenticationJwtTokenFilter(),
        UsernamePasswordAuthenticationFilter.class);
  }

}



