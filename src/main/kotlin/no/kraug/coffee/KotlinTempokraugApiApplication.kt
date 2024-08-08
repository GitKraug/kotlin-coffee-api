package no.kraug.coffee

import no.kraug.coffee.model.rest.GoRestConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(GoRestConfigurationProperties::class)
class KotlinTempokraugApiApplication

fun main () {
    runApplication<KotlinTempokraugApiApplication>()
}
