package no.kraug.coffee.rest.model

data class CustomerApiResponse(
    val id: Long,
    val name: String,
    val email: String,
    val gender: String,
    val status: String
)
