package no.kraug.coffee.rest.model

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "external.api.gorest")
data class GoRestConfigurationProperties(
    var baseUrl: String = "",
    var listUsersEndpoint: String = ""
)
