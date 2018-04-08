package org.thelaughingdev.soap.server.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.thelaughingdev.wsdl.Currency
import org.springframework.stereotype.Repository
import org.thelaughingdev.soap.server.domain.Country

@Repository
interface CountryRepository : JpaRepository<Country, Long> {

	fun findByName(name: String): Country?

}