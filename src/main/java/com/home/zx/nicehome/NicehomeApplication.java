package com.home.zx.nicehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@SpringBootApplication
public class NicehomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NicehomeApplication.class, args);
	}
	
	@Bean
	public TemplateResolver resolver(){
		TemplateResolver resoler=new TemplateResolver();
		resoler.setPrefix("classpath:templates");
		resoler.setTemplateMode("HTML5");
		resoler.setSuffix(".html");
		return resoler;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine engine=new SpringTemplateEngine();
		engine.setTemplateResolver(resolver());
		return engine;
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver(){
		ThymeleafViewResolver solver=new ThymeleafViewResolver();
		solver.setTemplateEngine(templateEngine());
		return solver;
	}
}
