package no.kraug.coffee.model.jpa

import jakarta.persistence.*
import no.kraug.coffee.model.BeanType
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "coffee")
class CoffeeEntity {
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID? = null

    @Column(name = "title", nullable = false)
    val name: String = ""

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime? = null

    @Column(name = "bean_type", nullable = false)
    @Enumerated(EnumType.STRING)
    val beanType: BeanType = BeanType.roasted
}
