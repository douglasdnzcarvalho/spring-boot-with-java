package com.example.springbootwithjava.converters;

import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.example.springbootwithjava.helpers.HttpHelper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Yaml2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

    public Yaml2HttpMessageConverter() {
        super(
            new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL),
            HttpHelper.MEDIA_TYPE_YML
        );
    }

}
