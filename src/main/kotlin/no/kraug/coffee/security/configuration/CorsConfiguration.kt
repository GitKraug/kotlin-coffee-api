package no.kraug.coffee.security.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration


@Configuration
@EnableWebSecurity
class CorsConfigurationSourceImpl {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors { cors ->
                cors.configurationSource { _ ->
                    CorsConfiguration().apply {
                        addAllowedOriginPattern("*")
                        addAllowedMethod("*")
                        addAllowedHeader("*")
                        allowCredentials = true
                    }
                }
            }
            .csrf { it.disable() }
            .authorizeHttpRequests { authorize ->
                authorize.anyRequest().permitAll()
            }

        return http.build()
    }
}