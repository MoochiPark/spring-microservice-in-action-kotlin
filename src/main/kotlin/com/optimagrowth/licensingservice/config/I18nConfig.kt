package com.optimagrowth.licensingservice.config

import java.util.Locale
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver

@Configuration
class I18nConfig {
    @Bean
    fun localeResolver(): LocaleResolver =
        SessionLocaleResolver().apply {
            setDefaultLocale(Locale.US)
        }

    @Bean
    fun messageSource(): MessageSource =
        ResourceBundleMessageSource().apply {
            setUseCodeAsDefaultMessage(true)
            setBasenames("messages")
        }
}