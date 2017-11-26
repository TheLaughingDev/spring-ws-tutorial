package org.thelaughingdev.soap.server.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.thelaughingdev.soap.server.domain.Country

interface CountryRepository: JpaRepository<Country, Long> {

	fun findFirstByName(name: String): Country?

}