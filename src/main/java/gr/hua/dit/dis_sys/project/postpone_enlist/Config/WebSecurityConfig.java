package gr.hua.dit.dis_sys.project.postpone_enlist.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Give authorities to users
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username, password, 'true' as enabled from user where username=?")
                .authoritiesByUsernameQuery("select username, role from authorities as a join user as u on a.ADT = u.ADT where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/**").hasRole("ADMIN")
                //Give access to roles to specific URL's
                .antMatchers("/").permitAll()
                .antMatchers("/empl").hasRole("EMPL")
                .antMatchers("/aks").hasRole("AKS")
                .antMatchers("/cit").hasRole("USER")
                .and().csrf().disable().headers().frameOptions().disable()

                //Allow Everyone to login and logout
                .and().formLogin().permitAll().and().logout().permitAll();
    }

    //Ignore authentication the specified URL's
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/");
    }

    //Encoder for the passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
