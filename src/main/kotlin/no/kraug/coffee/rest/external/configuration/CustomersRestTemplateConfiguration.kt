package no.kraug.coffee.rest.external.configuration

import no.kraug.coffee.rest.external.model.CustomersApiConfigurationProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory

@Configuration
class CustomersRestTemplateConfiguration {
    @Bean
    fun customerRestApiConfigProps(): CustomersApiConfigurationProperties = CustomersApiConfigurationProperties()

    @Bean
    fun customerRestTemplate(): RestTemplate = RestTemplateBuilder()
        .uriTemplateHandler(DefaultUriBuilderFactory(customerRestApiConfigProps().baseUrl))
        .build()
}