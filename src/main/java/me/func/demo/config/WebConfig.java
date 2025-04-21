package me.func.demo.config;

import me.func.demo.converter.SafeByteArrayHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(clazz -> clazz instanceof ByteArrayHttpMessageConverter);
        converters.add(new SafeByteArrayHttpMessageConverter());
    }
}
