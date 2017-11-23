package org.thelaughingdev.soap.server.repository

import org.thelaughingdev.wsdl.Country
import org.thelaughingdev.wsdl.Currency
import org.springframework.stereotype.Repository

@Repository
open class CountryRepository {

	private val countries = HashMap<String, Country>()

	init {
		val spain = Country().apply {
			name = "Spain"
			capital = "Madrid"
			currency = Currency.EUR
			population = 46704314
		}
		countries[spain.name] = spain

		val poland = Country().apply {
			name = "Poland"
			capital = "Warsaw"
			currency = Currency.PLN
			population = 38186860
		}
		countries[poland.name] = poland

		val uk = Country().apply {
			name = "United Kingdom"
			capital = "London"
			currency = Currency.GBP
			population = 63705000
		}
		countries[uk.name] = uk
	}

	fun findCountry(name: String): Country? = countries[name]

}