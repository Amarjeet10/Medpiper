    package com.medpiper.doc.config;

    import com.medpiper.doc.service.Impl.UserDetailsServiceImpl;
    import com.medpiper.doc.service.RegistrationService;
    import com.medpiper.doc.util.Constants;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
    import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
    import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
    import org.springframework.web.servlet.config.annotation.CorsRegistry;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter
    {

        @Bean
        public UserDetailsService userDetailsService()
        {
            return new UserDetailsServiceImpl();
        }
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsService());
            authProvider.setPasswordEncoder(passwordEncoder());

            return authProvider;
        }
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider());
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http.authorizeRequests()
                    .antMatchers(Constants.URL_V1).hasAnyAuthority("ROLE_DOCTOR","ROLE_ADMIN")
                    .antMatchers(Constants.URL_V1+"saveUser").hasAnyAuthority("ROLE_DOCTOR","ROLE_ADMIN")
                    .antMatchers(Constants.URL_V1+"login").hasAnyAuthority("ROLE_DOCTOR","ROLE_ADMIN")
                    .antMatchers(Constants.URL_V1+"verifyotp").hasAnyAuthority("ROLE_DOCTOR","ROLE_ADMIN")
                    .antMatchers(Constants.URL_V1+"doctor/**").hasAuthority("ROLE_DOCTOR")
                    .antMatchers(Constants.URL_V1+"hospital/**").hasAuthority("ROLE_HOSPITAL")
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling().accessDeniedPage("/403")
                    ;
        }

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
/*
        @Override
        public void addCorsMappings(CorsRegistry registry)
        {
            registry.addMapping("/**").allowedMethods("GET", "POST");
        }

        @Bean
        public ThreadPoolTaskExecutor mvcTaskExecutor()
        {
            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
            taskExecutor.setCorePoolSize(10);
            taskExecutor.setMaxPoolSize(10);
            return taskExecutor;
        }

        public void configureAsyncSupport(AsyncSupportConfigurer configurer)
        {
            configurer.setTaskExecutor(mvcTaskExecutor());
        }

     */
    }
