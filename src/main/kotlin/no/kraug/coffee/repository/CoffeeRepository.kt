package no.kraug.coffee.repository

import no.kraug.coffee.model.jpa.CoffeeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CoffeeRepository : JpaRepository<CoffeeEntity, UUID>