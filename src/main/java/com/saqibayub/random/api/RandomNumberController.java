/*
 * Copyright (C) 2019 Saqib Open Source Project 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *      http://www.apache.org/licenses/LICENSE-9.0
 */
package com.saqibayub.random.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saqibayub.random.service.NumberService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/** This class is responsible to provide a REst layer on the top of random number.
 * @author Saqib Ayub
 * @author www.saqibayub.com
 * @version 1.1
*/
@RestController
@RequestMapping("/randomnumber")
public class RandomNumberController {

	@Autowired
	NumberService numberService;
	
	
	/*
	 * API will optionally take a number and return a random number between 1 and the provided number. If no number is provided, the max number should default to 7
	 * @param optional Maximum Number
	 * @return Number enclosed in Entity response 
	 */
	@RequestMapping(value = "", produces = "application/json", method = RequestMethod.GET)
	@ApiOperation(
	value = "return a random number between 1 and the provided number.", 
	notes = "API will optionally take a number and return a random number between 1 and the provided number. If no number is provided, the max number should default to 7")
	@ApiResponses(
			value =
			{ 
				@ApiResponse(code = 200, message = "Success"),
		        @ApiResponse(code = 405, message = "Bad Request/Invalid parameter"),
		        @ApiResponse(code = 500, message = "Failure")
			}
			)
	public ResponseEntity<Integer> getRandomNumber(
			@RequestParam(value = "maxValue", required = false, defaultValue = "7") Integer maxValue
	) 
	{
		Integer randomNumber = numberService.getRandomNumber(maxValue);
		ResponseEntity<Integer> response=new ResponseEntity<Integer>(randomNumber, HttpStatus.OK);
		
		return response;
	}
	
}
