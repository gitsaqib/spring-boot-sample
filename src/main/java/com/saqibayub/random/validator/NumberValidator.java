package com.saqibayub.random.validator;

import org.springframework.stereotype.Component;

import com.saqibayub.random.exception.InvalidNumberException;

@Component
public class NumberValidator {

	public void validate(Integer number) throws InvalidNumberException{
		if(number==null || number<0) {
			throw new InvalidNumberException();
		}
		

		
	}

}
