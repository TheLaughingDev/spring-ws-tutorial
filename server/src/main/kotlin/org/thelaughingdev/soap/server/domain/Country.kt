package org.thelaughingdev.soap.server.domain

import org.thelaughingdev.wsdl.Currency
import javax.persistence.*

@Entity
data class Country(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Long? = null,

	@Column(unique = true, nullable = false)
	var name: String = "",

	@Column(nullable = false)
	var population: Int = 0,

	@Column(nullable = false)
	var capital: String = "",

	@Column(nullable = false)
	@Convert(converter = CurrencyConverter::class)
	var currency: Currency = Currency.EUR
)
