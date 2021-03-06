package br.com.erudio.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		configurer.favorParameter(false).ignoreAcceptHeader(false).defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML);

		/*
		 * configurer.favorPathExtension(false) .favorParameter(true)
		 * .parameterName("mediaType") .ignoreAcceptHeader(true)
		 * .useRegisteredExtensionsOnly(true)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
		 */

	}

}
