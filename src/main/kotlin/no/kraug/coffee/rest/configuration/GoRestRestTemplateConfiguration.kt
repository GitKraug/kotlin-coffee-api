package no.kraug.coffee.rest.configuration

import no.kraug.coffee.rest.model.GoRestConfigurationProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory

@Configuration
class GoRestRestTemplateConfiguration {
    @Bean
    fun goRestConfiguration(): GoRestConfigurationProperties = GoRestConfigurationProperties()

    @Bean
    fun goRestTemplate(): RestTemplate = RestTemplateBuilder()
        .uriTemplateHandler(DefaultUriBuilderFactory(goRestConfiguration().baseUrl))
        .build()

}