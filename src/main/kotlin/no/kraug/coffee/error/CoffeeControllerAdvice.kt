package no.kraug.coffee.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class CoffeeControllerAdvice {
    @ExceptionHandler(value = [(CoffeeException::class)])
    fun handleCoffeeException(ex: CoffeeException, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(message = ex.message?: "Unknown coffee-exception occurred.", code = 500)
        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [(Exception::class)])
    fun handleUnknownException(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(message = ex.message?: "Unknown, internal server error occurred.", code = 500)
        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}