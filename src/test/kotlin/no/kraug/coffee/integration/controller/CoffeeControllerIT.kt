package no.kraug.coffee.integration.controller

import no.kraug.coffee.testcontainers.WithPostgresTestContainers
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@WithPostgresTestContainers
class CoffeeControllerIT {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun `verify cors configuration works as expected`() {
        mvc.perform(options("/api/coffee/all")
            .header("Access-Control-Request-Method", "GET")
            .header("Origin", "http://www.someurl.com"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun `200 OK all coffee entities returned`() {
        mvc.perform(
            get("/api/coffee/all")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize<Any>(6)))
            .andExpect(jsonPath("$[*].name", containsInAnyOrder("KraugeBeans", "NetBeans", "ConfigurationBeans", "Beans", "Bønner fra KB", "Ukjente bønner fra shady kilde")))
    }
}