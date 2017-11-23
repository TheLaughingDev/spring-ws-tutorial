package org.thelaughingdev.soap.server.config

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition
import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.xml.xsd.XsdSchema

@EnableWs
@Configuration
open class MainConfig: WsConfigurerAdapter() {

	@Bean
	open fun messageDispatchServlet(context: ApplicationContext): ServletRegistrationBean {
		val servlet = MessageDispatcherServlet().apply {
			setApplicationContext(context)
			isTransformWsdlLocations = true
		}
		return ServletRegistrationBean(servlet, "/ws/*")
	}

	@Bean
	open fun countriesSchema(): XsdSchema = SimpleXsdSchema(ClassPathResource("countries.xsd"))

	@Bean
	open fun countries(schema: XsdSchema): DefaultWsdl11Definition {
		return DefaultWsdl11Definition().apply {
			setPortTypeName("CountriesPort")
			setLocationUri("/ws")
			setTargetNamespace("http://thelaughingdev.org/web-services")
			setSchema(schema)
		}
	}
}