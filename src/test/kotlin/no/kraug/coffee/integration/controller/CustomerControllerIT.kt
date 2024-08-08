package no.kraug.coffee.integration.controller

import no.kraug.coffee.wiremock.WireMockSetup
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class CustomerControllerIT : WireMockSetup() {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun `200 OK all customers returned`() {
        addWireMockApiStubbing("wiremock/200_ok_customers_external_api.json")

        mvc.perform(
            MockMvcRequestBuilders.get("/api/customers/all")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize<Any>(2)))
            .andExpect(jsonPath("$[*].name", containsInAnyOrder("Mr. Goswamee Verma", "Tanushri Banerjee")))
            .andExpect(jsonPath("$[*].email", containsInAnyOrder("mr_goswamee_verma@herzog.test", "banerjee_tanushri@abbott-mohr.example")))
            .andExpect(jsonPath("$[*].gender", containsInAnyOrder("male", "male")))
            .andExpect(jsonPath("$[*].status", containsInAnyOrder("active", "inactive")))
    }
}