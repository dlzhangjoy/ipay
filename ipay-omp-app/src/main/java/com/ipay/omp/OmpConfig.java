package com.ipay.omp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties() 
public class OmpConfig {
	@Value("${spring.application.name}")
    private String springApplicationName;

	public String getSpringApplicationName() {
		return springApplicationName;
	}

	public void setSpringApplicationName(String springApplicationName) {
		this.springApplicationName = springApplicationName;
	}
     
}
