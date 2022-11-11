package com.optimagrowth.licensingservice.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.web.DefaultSecurityFilterChain

@EnableWebSecurity
class SecurityConfig : WebSecurityConfiguration() {
    @Bean
    fun filterChain(http: HttpSecurity): DefaultSecurityFilterChain? {
        http.antMatcher("/v2/**").authorizeRequests()
            .anyRequest().permitAll()
        return http.build()
    }
}