package org.thelaughingdev.soap.server.domain

import org.thelaughingdev.wsdl.Currency
import org.thelaughingdev.wsdl.Country as CountryDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Country(
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	val id: Long? = null,
	val name: String = "",
	val population: Int = 0,
	val capital: String = "",
	val currency: String = ""
) {

	companion object {
		fun fromDto(dto: CountryDto) = Country(id = dto.id, name = dto.name,
			population = dto.population, capital = dto.capital, currency = dto.capital)
	}

	fun toDto() = CountryDto().apply {
		name = this@Country.name
		population = this@Country.population
		capital = this@Country.capital
		currency = Currency.valueOf(this@Country.currency)
	}

}
