
package com.id.wasta.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.id.nlp.service.NlpProcesssingService;
import com.id.nlp.service.OpticalCharacterRecognitionService;
import com.id.nlp.service.impl.GoogleOpticalCharacterRecognitionService;
import com.id.nlp.service.impl.NlpProcesssingServiceImpl;

@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories("com.id.wasta.data")
@ComponentScan(basePackages = "com.id.util,com.id.wasta.util,com.id.framework,com.id.wasta")
@EntityScan(basePackages="com.id.wasta.bean")
public class SpringBootWebApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Bean
	public NlpProcesssingService nlpProcesssingService() {
		return new NlpProcesssingServiceImpl();
    }
    
    @Bean
	public OpticalCharacterRecognitionService googleOpticalCharacterRecognitionService() {
		return new GoogleOpticalCharacterRecognitionService();
	}
}
