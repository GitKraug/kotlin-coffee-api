package no.kraug.coffee.error

import java.time.LocalDateTime

data class ErrorDetails(
    val message: String,
    val code: Int,
    val timestamp: LocalDateTime = LocalDateTime.now(),
)
