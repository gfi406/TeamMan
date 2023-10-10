package com.example.springdatabasicdemo;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@SpringBootApplication
public class SpringDataBasicDemoApplication {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        return modelMapper;
    }
//    @Bean
//    public FormattingConversionService conversionService() {
//        FormattingConversionService conversionService = new DefaultFormattingConversionService();
//        conversionService.addConverter(new TupleBackedMapToCountDtoConverter());
//        return conversionService;
//    }


    public static void main(String[] args) {
        SpringApplication.run(SpringDataBasicDemoApplication.class, args);
    }

}
