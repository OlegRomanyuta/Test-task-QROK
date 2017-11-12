package ua.oleg.romanyuta.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import ua.oleg.romanyuta.dao.AccountRepository;
//import ua.oleg.romanyuta.domain.Account;
//import ua.oleg.romanyuta.domain.Role;


@SpringBootApplication(scanBasePackages = {"ua.oleg.romanyuta.api"})
@EnableJpaRepositories(basePackages = "ua.oleg.romanyuta.dao")
@EntityScan("ua.oleg.romanyuta.domain")
//@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


//    @EnableWebSecurity
//    @Configuration
//    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
////            http.authorizeRequests()
//////                    .antMatchers("**/add/*").hasRole(Role.ADMIN.name())
//////                    .antMatchers("/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
////                    .anyRequest().authenticated();
////            http.antMatcher("/**").authorizeRequests().antMatchers("/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
////                    .and().csrf().disable();
//
//
////            http.authorizeRequests().anyRequest().fullyAuthenticated()
////                    .antMatchers(HttpMethod.POST, "/**").hasRole(Role.ADMIN.name())
////                    .antMatchers("/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
////                    .and().httpBasic()
////                    .and().csrf().disable();
//
//            http
//                    .httpBasic().and()
//                    .authorizeRequests()
//                    .antMatchers("/**").hasRole(Role.ADMIN.name())
//                    .and().csrf().disable();
//        }
//    }
//
//    @Configuration
//    public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//        @Autowired
//        AccountRepository accountRepository;
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userDetailsService());
//        }
//
//        @Bean
//        UserDetailsService userDetailsService() {
//            return username -> {
//                Account account = accountRepository.findByUsername(username);
//                if(account != null) {
//                    return new User(account.getUsername(), account.getPassword(), true, true, true, true,
//                            AuthorityUtils.createAuthorityList(account.getRole().name()));
//                } else {
//                    throw new UsernameNotFoundException("could not find the user '"
//                            + username + "'");
//                }
//            };
//        }
//    }


}
