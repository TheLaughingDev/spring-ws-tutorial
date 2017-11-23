package org.thelaughingdev.soap.server.webservice

import org.thelaughingdev.wsdl.GetCountryRequest
import org.thelaughingdev.wsdl.GetCountryResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import org.thelaughingdev.soap.server.repository.CountryRepository

@Endpoint
open class CountryEndpoint @Autowired constructor(private val countryRepository: CountryRepository) {

	companion object {
		const val NAMESPACE_URI = "http://thelaughingdev.org/web-services"
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	fun getCountry(@RequestPayload request: GetCountryRequest): GetCountryResponse {
		val response = GetCountryResponse().apply {
			country = countryRepository.findCountry(request.name)
		}
		return response
	}
}