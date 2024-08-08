package no.kraug.coffee.wiremock

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.springframework.core.io.ClassPathResource
import org.testcontainers.shaded.org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class WireMockSetup {
    val server = WireMockServer(options()
        .port(9090))

    @BeforeAll
    fun setup() = server.start()

    @BeforeEach
    fun resetWireMockConfig() = server.resetAll()

    @AfterAll
    fun tearDown() = server.stop()

    fun addWireMockApiStubbing(stubbingFile: String) = server.addStubMapping(buildStubMapping(stubbingFile))

    fun buildStubMapping(path: String): StubMapping {
        val resource = ClassPathResource(path)
        val json = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

        return StubMapping.buildFrom(json);
    }
}