package no.kraug.coffee.rest.external.service

import no.kraug.coffee.rest.external.model.CustomersApiConfigurationProperties
import no.kraug.coffee.rest.external.model.CustomerApiResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.GET
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.UnknownHttpStatusCodeException

@Service
class GoRestApiClientService(
    @Qualifier("customerRestTemplate") val restTemplate: RestTemplate,
    @Qualifier("customerRestApiConfigProps") val apiProperties: CustomersApiConfigurationProperties
) {
    fun callCustomerRestApi(): List<CustomerApiResponse> {
        try {
            val respType = object: ParameterizedTypeReference<List<CustomerApiResponse>>(){}
            return restTemplate.exchange(apiProperties.allCustomersEndpoint, GET, createHeaders(), respType).body.orEmpty()
        } catch (cee: HttpClientErrorException) {
            throw cee
        } catch (see: HttpServerErrorException) {
            throw see
        } catch (use: UnknownHttpStatusCodeException) {
            throw use
        } catch (e: Exception) {
            throw e
        }
    }

    fun createHeaders(): HttpEntity<String> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        return HttpEntity(null, headers)
    }
}