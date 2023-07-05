package com.example.springbootwithjava.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.springbootwithjava.converters.Yaml2HttpMessageConverter;
import com.example.springbootwithjava.helpers.HttpHelper;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new Yaml2HttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        /**
         * Via EXTENSION. localhost:8080/person.x-yaml
         * configurer
         * .favorParameter(false)
         * .ignoreAcceptHeader(false)
         * .defaultContentType(MediaType.APPLICATION_JSON)
         * .mediaType("json", MediaType.APPLICATION_JSON)
         * .mediaType("xml", MediaType.APPLICATION_XML);
         */

        /**
         * Via QUERY PARAM. localhost:8080/person?mediaType=xml
         * configurer
         * .favorPathExtension(false)
         * .favorParameter(true)
         * .parameterName("mediaType")
         * .ignoreAcceptHeader(true)
         * .useRegisteredExtensionsOnly(false)
         * .defaultContentType(MediaType.APPLICATION_JSON)
         * .mediaType("json", MediaType.APPLICATION_JSON)
         * .mediaType("xml", MediaType.APPLICATION_XML);
         */

        configurer
            .favorParameter(false)
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML)
            .mediaType("x-yaml", HttpHelper.MEDIA_TYPE_YML);
    }
}
