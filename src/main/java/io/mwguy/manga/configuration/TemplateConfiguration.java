package io.mwguy.manga.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class TemplateConfiguration {
    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    @Value("${spring.mvc.view.suffix}")
    private String suffix;

    @Bean
    public ViewResolver viewResolver(ApplicationContext context) {
        // NOTE: override default jsp view resolver with spring context

        var resolver = new InternalResourceViewResolver();
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setApplicationContext(context);
        resolver.setPrefix(prefix);
        resolver.setSuffix(suffix);

        return resolver;
    }
}
