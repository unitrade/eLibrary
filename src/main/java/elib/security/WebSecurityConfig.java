package elib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private DataSource dataSource;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("SELECT email, password, 'true' as enabled FROM client where email=?")
            .authoritiesByUsernameQuery("select u.email, r.role_name from client u inner join client_role ur on(u.user_id=ur.client_id) " +
                    "inner join role r on(ur.role_id=r.role_id) where u.email=?")
            .passwordEncoder(bCryptPasswordEncoder);


  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
              .antMatchers("/index", "/", "/user/create").permitAll()
              .antMatchers("/signup").permitAll()
              .antMatchers("/admin").hasAuthority("ADMIN")
            . anyRequest().authenticated()
              .and()
            .httpBasic()
              .and()
            .formLogin()
              .loginPage("/login")
              .defaultSuccessUrl("/index")
              .permitAll()
              .and()
            .logout()
              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
              .logoutSuccessUrl("/");

  }
}
