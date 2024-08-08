package no.kraug.coffee.resource

import no.kraug.coffee.rest.external.model.CustomerApiResponse
import no.kraug.coffee.service.CoffeeCustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomersController (val customerService: CoffeeCustomerService) {
    @GetMapping("/all")
    fun findAllCoffeeCustomers(): List<CustomerApiResponse> = customerService.findAllCustomers()
}