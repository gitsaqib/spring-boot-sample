package com.saqibayub.random.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "number")
public class NumberProperties {
	
	private Integer ramdonMaxDefault;
	private Integer ramdonMinDefault;


	public Integer getRamdonMaxDefault() {
		return ramdonMaxDefault;
	}

	public void setRamdonMaxDefault(Integer ramdonMaxDefault) {
		this.ramdonMaxDefault = ramdonMaxDefault;
	}

	public Integer getRamdonMinDefault() {
		return ramdonMinDefault;
	}

	public void setRamdonMinDefault(Integer ramdonMinDefault) {
		this.ramdonMinDefault = ramdonMinDefault;
	}
	
}
