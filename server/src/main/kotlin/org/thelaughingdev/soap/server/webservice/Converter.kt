package org.thelaughingdev.soap.server.webservice

import com.sun.xml.internal.ws.api.server.SDDocument
import org.thelaughingdev.soap.server.domain.Country
import org.thelaughingdev.wsdl.Country as WsdlCountry

fun WsdlCountry.toDomain(): Country {
	val c = Country()
	c.capital = capital
	c.currency = currency
	c.name = name
	c.population = population

	return c
}

fun Country.toDto(): WsdlCountry {
	val c = WsdlCountry()
	c.capital = capital
	c.currency = currency
	c.name = name
	c.population = population

	return c
}