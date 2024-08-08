package no.kraug.coffee

import no.kraug.coffee.rest.external.model.CustomersApiConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(CustomersApiConfigurationProperties::class)
class KotlinTempokraugApiApplication

fun main () {
    runApplication<KotlinTempokraugApiApplication>()
}
