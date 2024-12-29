package com.example.springsecurity.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
      MustacheViewResolver resolver = new MustacheViewResolver();

      log.debug("configureViewResolvers");

      resolver.setCharset("UTF-8");
      resolver.setContentType("text/html;charset=UTF-8");
      resolver.setPrefix("classpath:/templates/");
      resolver.setSuffix(".html");

      registry.viewResolver(resolver);
  }
}
