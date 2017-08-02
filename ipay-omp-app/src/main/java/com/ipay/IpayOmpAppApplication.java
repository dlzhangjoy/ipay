package com.ipay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.ipay.omp.OmpConfig;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class IpayOmpAppApplication {
	@Bean(name="localeResolver")
    public LocaleResolver localeResolverBean() {
        return  new CookieLocaleResolver();
    }
	@Bean(name="ompConfig")
    public OmpConfig localeOmpConfig() {
        return  new OmpConfig();
    }
	public static void main(String[] args) {
		SpringApplication.run(IpayOmpAppApplication.class, args);
	}

 	
}
