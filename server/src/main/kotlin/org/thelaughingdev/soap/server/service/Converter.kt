package org.thelaughingdev.soap.server.service

import org.thelaughingdev.soap.server.domain.Country
import org.thelaughingdev.wsdl.Country as WsdlCountry

fun WsdlCountry.toDomain(): Country {
	val c = Country()
	c.id = id
	c.capital = capital
	c.currency = currency
	c.name = name
	c.population = population

	return c
}

fun Country.toDto(): WsdlCountry {
	val c = WsdlCountry()
	c.id = id
	c.capital = capital
	c.currency = currency
	c.name = name
	c.population = population

	return c
}