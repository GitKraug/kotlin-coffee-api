package no.kraug.coffee.model.rest

data class GoRestUser(
    val id: Long,
    val name: String,
    val email: String,
    val gender: String,
    val status: String
)
