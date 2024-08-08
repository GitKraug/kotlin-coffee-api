package no.kraug.coffee.service

import no.kraug.coffee.rest.external.model.CustomerApiResponse
import no.kraug.coffee.rest.external.service.GoRestApiClientService
import org.springframework.stereotype.Service

@Service
class CoffeeCustomerService(val goRestApiClientService: GoRestApiClientService) {
    fun findAllCustomers(): List<CustomerApiResponse> = goRestApiClientService.callCustomerRestApi()
}