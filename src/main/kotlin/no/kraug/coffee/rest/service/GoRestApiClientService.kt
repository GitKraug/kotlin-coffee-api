package no.kraug.coffee.rest.service

import no.kraug.coffee.model.rest.GoRestConfigurationProperties
import no.kraug.coffee.model.rest.GoRestUser
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.UnknownHttpStatusCodeException
import java.net.URI

@Service
class GoRestApiClientService(
    @Qualifier("goRestTemplate") val restTemplate: RestTemplate,
    @Qualifier("goRestConfiguration") val apiProperties: GoRestConfigurationProperties
) {
    fun callGoRestApi(): List<GoRestUser> {
        try {
            val request = RequestEntity<Any>(GET, URI.create(apiProperties.listUsersEndpoint))
            val respType = object: ParameterizedTypeReference<List<GoRestUser>>(){}

            return restTemplate.exchange(request, respType).body.orEmpty()
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
}