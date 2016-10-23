/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.spring.config;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;


/**
 *
 * @author Optimus
 */
@Configuration
@ConditionalOnClass(Gson.class)
public class GsonConfiguration {
    
    
    @Bean
    @ConditionalOnMissingBean
    public Gson gson() {
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes field) {
                return field.getName().equals("echantillonList")||field.getName().equals("cofisemUserList")
                        ||field.getName().equals("spiUserList")||field.getName().equals("userRoleSet")||field.getName().equals("password"); 
            }

            @Override
            public boolean shouldSkipClass(Class<?> arg0) {
                return false;
            }
        }).serializeNulls().setDateFormat("dd/MM/yyyy").create();
        return  gson;
    }
    
    @Bean
    @ConditionalOnMissingBean
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson) {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }
    
}
