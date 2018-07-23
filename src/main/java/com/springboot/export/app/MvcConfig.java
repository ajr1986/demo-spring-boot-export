package com.springboot.export.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.export.app.view.XmlViewComponent;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(new Class[] {XmlViewComponent.class});
		return jaxb2Marshaller;
	}
}
