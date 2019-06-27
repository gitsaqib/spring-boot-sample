package com.saqibayub.random.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.assertj.core.util.introspection.FieldUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

import com.saqibayub.random.config.properties.NumberProperties;
import com.saqibayub.random.validator.NumberValidator;

public class NumberServiceTest {

	
	NumberService numberService;
	NumberValidator numberValidator;

	NumberProperties numberProperties;
	
	@Before
	public void setUpBefore() throws Exception {
		numberService=new NumberService();
		numberProperties=new NumberProperties();
		numberProperties.setRamdonMinDefault(1);
		numberProperties.setRamdonMaxDefault(7);
		ReflectionTestUtils.setField(numberService, "numberProperties", numberProperties);
		
		numberValidator=new NumberValidator();
		ReflectionTestUtils.setField(numberService, "numberValidator", numberValidator);

	}
	
	@Test
	public void testUpdateDefaults() {
		Integer expected=numberProperties.getRamdonMaxDefault();
		Integer actual=numberService.updateDefaults(null);
		assertEquals("Default value is not set properly ", expected, actual);
	}
	@Test
	public void testUpdateDefaultsDefaultValueIsNotRequired() {
		Integer passingParameter=100;
		Integer actual=numberService.updateDefaults(passingParameter);
		assertEquals("Default value is not set properly ", passingParameter, actual);
	}
	@Test
	public void testgetRandomNumber() {
		Integer passingParameter=100;
		Integer actual=numberService.getRandomNumber(passingParameter);
		boolean test=actual>1 && actual<passingParameter;
		
		assertTrue("Random Number is not properly generated ", test);
	}
	
}
