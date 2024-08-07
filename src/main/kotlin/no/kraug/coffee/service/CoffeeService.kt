package no.kraug.coffee.service

import no.kraug.coffee.model.jpa.CoffeeEntity
import no.kraug.coffee.repository.CoffeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CoffeeService (@Autowired val db: CoffeeRepository) {
    fun findAllCoffeeTypes(): List<CoffeeEntity> = db.findAll()
}