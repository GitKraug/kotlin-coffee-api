package no.kraug.coffee.resource

import no.kraug.coffee.model.jpa.CoffeeEntity
import no.kraug.coffee.model.rest.GoRestUser
import no.kraug.coffee.service.CoffeeCustomerService
import no.kraug.coffee.service.CoffeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/coffee")
class CoffeeController (
    val coffeeService: CoffeeService,
    val customerService: CoffeeCustomerService
) {
    @GetMapping("/all")
    fun findAllCoffees(): List<CoffeeEntity> = coffeeService.findAllCoffeeTypes()

    @GetMapping("/customers/all")
    fun findAllCoffeeCustomers(): List<GoRestUser> = customerService.findAllCustomers()
}