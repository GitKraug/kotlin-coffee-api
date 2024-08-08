package no.kraug.coffee.service

import no.kraug.coffee.model.jpa.CoffeeEntity
import no.kraug.coffee.model.request.CoffeeRequestBody
import no.kraug.coffee.repository.CoffeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class CoffeeService (@Autowired val db: CoffeeRepository) {
    fun findAllCoffeeTypes(): List<CoffeeEntity> = db.findAll()
    fun saveNewCoffee(coffee: CoffeeRequestBody) = db.save(CoffeeEntity(UUID.randomUUID(), coffee.name, coffee.beanType, LocalDateTime.now()))
    fun deleteCoffeeById(id: UUID) = db.deleteById(id)
}