package no.kraug.coffee.model.jpa

import jakarta.persistence.*
import no.kraug.coffee.model.BeanType
import org.hibernate.annotations.JdbcType
import org.hibernate.dialect.PostgreSQLEnumJdbcType
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "coffee")
class CoffeeEntity (
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID? = UUID.randomUUID(),

    @Column(name = "title", nullable = false)
    val name: String,

    @Column(name = "bean_type", nullable = false)
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType::class)
    val beanType: BeanType,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime? = LocalDateTime.now()
)
