package org.thelaughingdev.soap.server.domain

import org.thelaughingdev.wsdl.Currency
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class CurrencyConverter: AttributeConverter<Currency, String> {
	override fun convertToDatabaseColumn(currency: Currency): String = currency.toString()

	override fun convertToEntityAttribute(dbData: String): Currency = Currency.valueOf(dbData)

}