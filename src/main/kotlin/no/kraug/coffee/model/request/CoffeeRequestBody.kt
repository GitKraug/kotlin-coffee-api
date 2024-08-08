package no.kraug.coffee.model.request

import no.kraug.coffee.model.BeanType

data class CoffeeRequestBody(
    val name: String = "",
    val beanType: BeanType = BeanType.roasted
)
