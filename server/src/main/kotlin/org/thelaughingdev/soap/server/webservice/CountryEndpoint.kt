package org.thelaughingdev.soap.server.webservice

import org.thelaughingdev.wsdl.GetCountryRequest
import org.thelaughingdev.wsdl.GetCountryResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import org.thelaughingdev.soap.server.repository.CountryRepository
import org.thelaughingdev.wsdl.FindCountryByNameRequest
import org.thelaughingdev.wsdl.GetAllCountriesResponse

@Endpoint
open class CountryEndpoint @Autowired constructor(private val countryRepository: CountryRepository) {

	companion object {
		const val NAMESPACE_URI = "http://thelaughingdev.org/web-services"
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountries")
	@ResponsePayload
	fun getAllCountries(): GetAllCountriesResponse {
		return GetAllCountriesResponse().apply {
			countryRepository.findAll().map{it.toDto()}.forEach {countries.add(it)};
		}
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	fun getCountry(@RequestPayload request: GetCountryRequest): GetCountryResponse {
		val response = GetCountryResponse().apply {
			country = countryRepository.findById(request.id).orElseThrow { Exception("Can't find country for id ${request.id}") }.toDto()
		}
		return response
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findCountryByNameRequest")
	@ResponsePayload
	fun findCountryByNameRequest(@RequestPayload request: FindCountryByNameRequest): GetCountryResponse {
		val response = GetCountryResponse().apply {
			country = countryRepository.findByName(request.name)?.toDto() ?: throw Exception("Can't find country for name ${request.name}")
		}
		return response
	}
}