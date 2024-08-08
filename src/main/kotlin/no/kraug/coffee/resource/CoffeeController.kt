package no.kraug.coffee.resource

import no.kraug.coffee.model.jpa.CoffeeEntity
import no.kraug.coffee.model.request.CoffeeRequestBody
import no.kraug.coffee.rest.model.GoRestUser
import no.kraug.coffee.service.CoffeeCustomerService
import no.kraug.coffee.service.CoffeeService
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/new")
    fun createNewCoffee(@RequestBody coffee: CoffeeRequestBody)  {
        coffeeService.saveNewCoffee(coffee)
    }
}