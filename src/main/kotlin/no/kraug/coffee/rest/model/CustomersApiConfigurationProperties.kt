package no.kraug.coffee.rest.model

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "external.api.customers")
data class CustomersApiConfigurationProperties(
    var baseUrl: String = "",
    var allCustomersEndpoint: String = ""
)
