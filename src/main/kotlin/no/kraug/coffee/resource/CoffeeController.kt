package no.kraug.coffee.resource

import no.kraug.coffee.model.jpa.CoffeeEntity
import no.kraug.coffee.model.request.CoffeeRequestBody
import no.kraug.coffee.service.CoffeeService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/coffee")
class CoffeeController (val coffeeService: CoffeeService) {
    @GetMapping("/all")
    fun findAllCoffees(): List<CoffeeEntity> = coffeeService.findAllCoffeeTypes()

    @PostMapping("/new")
    fun createNewCoffee(@RequestBody coffee: CoffeeRequestBody) = coffeeService.saveNewCoffee(coffee)

    @DeleteMapping("/{id}")
    fun deleteCoffeeById(@PathVariable("id") coffeeId: UUID) = coffeeService.deleteCoffeeById(coffeeId)
}