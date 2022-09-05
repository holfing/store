package br.com.produtos.produtos.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {


    @Bean
    public ModelMapper obterModelMapper() {
        return new ModelMapper();
    }
}
