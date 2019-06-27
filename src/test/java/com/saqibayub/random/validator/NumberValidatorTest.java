package com.saqibayub.random.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.saqibayub.random.exception.InvalidNumberException;

public class NumberValidatorTest {

	private NumberValidator numberValidator;
	
	@Rule
    public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUpBefore() throws Exception {
		numberValidator=new NumberValidator();
	}
	
	@Test
	public void testValidateNullInput(){
		expectedException.expect(InvalidNumberException.class);
		numberValidator.validate(null);
	}
	@Test
	public void testValidateNegativeInput(){
		expectedException.expect(InvalidNumberException.class);
		numberValidator.validate(-12);
	}
	@Test
	public void testValidatePositiveInput(){
		numberValidator.validate(12);
	}
}
