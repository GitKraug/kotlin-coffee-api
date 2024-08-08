package no.kraug.coffee.testcontainers

import org.springframework.test.context.ContextConfiguration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@ContextConfiguration(initializers = [(PostgresTestContainer::class)])
annotation class WithPostgresTestContainers