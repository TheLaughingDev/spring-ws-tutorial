package org.thelaughingdev.soap.server.webservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import org.thelaughingdev.soap.server.service.CountryService
import org.thelaughingdev.wsdl.*
import org.thelaughingdev.wsdl.Country as WsdlCountry

@Endpoint
open class CountryEndpoint @Autowired constructor(private val countryService: CountryService) {

	companion object {
		const val NAMESPACE_URI = "http://thelaughingdev.org/web-services"
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findCountryByNameRequest")
	@ResponsePayload
	fun findCountryByName(@RequestPayload request: FindCountryByNameRequest): FindCountryByNameResponse {
		val response = FindCountryByNameResponse()
		response.country = countryService.findCountryByName(request.name)
		return response
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	fun getCountry(@RequestPayload request: GetCountryRequest): GetCountryResponse {
		val response = GetCountryResponse()
		response.country = countryService.getCountry(request.id)
		return response
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountriesRequest")
	@ResponsePayload
	fun getAllCountries(): GetAllCountriesResponse {
		val response = GetAllCountriesResponse()
		response.country.addAll(0, countryService.listCountries())
		return response
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "modifyCountryRequest")
	@ResponsePayload
	fun modifyCountry(@RequestPayload request: ModifyCountryRequest): ModifyCountryResponse {
		val response = ModifyCountryResponse()
		response.id = countryService.modifyCountry(request.country)
		return response
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeCountryRequest")
	fun modifyCountry(@RequestPayload request: RemoveCountryRequest): Unit {
		countryService.removeCountry(request.id)
	}
}