package org.thelaughingdev.soap.server.repository

import org.springframework.data.repository.Repository
import org.thelaughingdev.soap.server.domain.Country

interface CountryRepository: Repository<Country, Long> {

	fun findFirstByName(name: String): Country?

}