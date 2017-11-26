package org.thelaughingdev.soap.server.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.thelaughingdev.soap.server.repository.CountryRepository
import javax.transaction.Transactional
import org.thelaughingdev.wsdl.Country as WsdlCountry

interface CountryService {

	fun listCountries(): List<WsdlCountry>

	fun findCountryByName(name: String): WsdlCountry?

	fun getCountry(id: Long): WsdlCountry

	fun modifyCountry(wsdlCountry: WsdlCountry): Long

	fun removeCountry(id: Long): Unit

}

@Service
open class CountryServiceImpl @Autowired constructor(private val countryRepository: CountryRepository): CountryService {

	override fun listCountries(): List<org.thelaughingdev.wsdl.Country> = countryRepository.findAll().map {it.toDto()}

	override fun findCountryByName(name: String): org.thelaughingdev.wsdl.Country? = countryRepository.findFirstByName(name)?.toDto()

	override fun getCountry(id: Long): org.thelaughingdev.wsdl.Country = countryRepository.findOne(id)?.toDto() ?: throw DataException("Error finding country for id $id.")

	@Transactional
	override fun modifyCountry(wsdlCountry: org.thelaughingdev.wsdl.Country): Long {
		val country = wsdlCountry.toDomain()
		return countryRepository.save(country).id!!
	}

	@Transactional
	override fun removeCountry(id: Long): Unit = countryRepository.delete(id)
}