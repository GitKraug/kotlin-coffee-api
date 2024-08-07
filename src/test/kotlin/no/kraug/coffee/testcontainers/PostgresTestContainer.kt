package no.kraug.coffee.testcontainers

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
class PostgresTestContainer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    companion object {
        @Container
        val postgresContainer = PostgreSQLContainer("postgres:16")
            .withDatabaseName("test_db")
            .withUsername("postgres")
            .withPassword("postgres")
            .withReuse(true)
            .withExposedPorts(5432)
            .withInitScript("init.sql")
    }

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        postgresContainer.start()

        TestPropertyValues.of(
            "spring.datasource.url=" + postgresContainer.jdbcUrl,
            "spring.datasource.username=" + postgresContainer.username,
            "spring.datasource.password=" + postgresContainer.password,
        ).applyTo(applicationContext)
    }
}