package no.kraug.coffee.rest.service

import no.kraug.coffee.rest.model.GoRestConfigurationProperties
import no.kraug.coffee.rest.model.GoRestUser
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
    @Qualifier("goRestTemplate") val restTemplate: RestTemplate,
    @Qualifier("goRestConfiguration") val apiProperties: GoRestConfigurationProperties
) {
    fun callGoRestApi(): List<GoRestUser> {
        try {
            val respType = object: ParameterizedTypeReference<List<GoRestUser>>(){}
            return restTemplate.exchange(apiProperties.listUsersEndpoint, GET, createHeaders(), respType).body.orEmpty()
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