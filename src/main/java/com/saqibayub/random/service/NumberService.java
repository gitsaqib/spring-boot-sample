/*
 * Copyright (C) 2019 Saqib Open Source Project 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *      http://www.apache.org/licenses/LICENSE-9.0
 */
package com.saqibayub.random.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saqibayub.random.config.properties.NumberProperties;
import com.saqibayub.random.exception.InvalidNumberException;
import com.saqibayub.random.validator.NumberValidator;

/** This class is responsible to provide service related to numbers.
 * @author Saqib Ayub
 * @author www.saqibayub.com
 * @version 1.1
*/

@Service
public class NumberService {
	
	@Autowired
	NumberValidator numberValidator;
	@Autowired
	NumberProperties numberProperties;

	public Integer getRandomNumber(Integer number) throws InvalidNumberException{
		number=updateDefaults(number);
		numberValidator.validate(number);
		Random random = new Random();
		Integer low = numberProperties.getRamdonMinDefault();
		Integer high = number;
		Integer diff=high-low;
		Integer result = low+(random.nextInt(diff));
		
		return result;
	}

	protected Integer updateDefaults(Integer number) {
		if(number==null) {
			number=numberProperties.getRamdonMaxDefault();
		}
		return number;
	}

}
