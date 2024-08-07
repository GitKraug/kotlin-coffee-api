package no.kraug.coffee.service

import no.kraug.coffee.model.BeanType
import no.kraug.coffee.repository.CoffeeRepository
import no.kraug.coffee.testcontainers.WithPostgresTestContainers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@WithPostgresTestContainers
class CoffeeControllerTest {
    @Autowired
    private val coffeeRepository: CoffeeRepository? = null

    @Test
    fun `all coffee entities returned`() {
        val existingBeans = coffeeRepository?.findAll()
        assertEquals(6, existingBeans?.size)
    }

    @Test
    fun `4 coffee types with beans not roasted and 2 with beans roasted`() {
        val existingBeans = coffeeRepository?.findAll()

        assertEquals(4, existingBeans?.filter { BeanType.not_roasted == it.beanType }?.toList()?.size)
        assertEquals(2, existingBeans?.filter { BeanType.roasted == it.beanType }?.toList()?.size)
    }
}