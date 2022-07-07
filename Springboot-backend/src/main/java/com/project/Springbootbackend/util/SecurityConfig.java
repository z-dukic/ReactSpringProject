package com.project.Springbootbackend.util;



//@EnableWebSecurity
public class SecurityConfig {
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http //
            .authorizeRequests() //
            .antMatchers("/delete/**").hasRole("MANAGER") //
            .antMatchers("/add").hasRole("MANAGER") //
            .antMatchers("/api/v1/employees").hasRole("MANAGER") //
            .antMatchers("/api/v1/email").hasRole("MANAGER")
            .antMatchers("/api/v1/security").hasRole("MANAGER")
                .antMatchers("/api/v1/roles/**").hasRole("MANAGER")
                .antMatchers("/api/v1/roles").hasRole("MANAGER")
            .anyRequest().authenticated() //
            .and() //
            .formLogin().permitAll().and() //
            .logout().permitAll();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails basicUser = User.withDefaultPasswordEncoder() //
            .username("user") //
            .password("user") //
            .roles("USER") //
            .build();

        UserDetails adminUser = User.withDefaultPasswordEncoder() //
            .username("admin") //
            .password("admin") //
            .roles("USER", "MANAGER") //
            .build();

        return new InMemoryUserDetailsManager(basicUser, adminUser);
    }

     */
}
