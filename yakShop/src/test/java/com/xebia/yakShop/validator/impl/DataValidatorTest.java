package com.xebia.yakShop.validator.impl;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakShop.constants.Gender;
import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Yak;
import com.xebia.yakShop.validator.Validator;

public class DataValidatorTest {

    private Validator dataValidator;

    @Before
    public void setUp() {
        dataValidator = new DataValidator();
    }

    @Test(expected = YakShopException.class)
    public void shouldThowYakShopExceptionForNullName() throws YakShopException {
        Yak yak = createYak("", 100, Gender.F);
        dataValidator.validateYak(yak);
    }

    @Test(expected = YakShopException.class)
    public void shouldThrowYakShopExceptionForNoGender() throws YakShopException {
        Yak yak = createYak("yakName", 100, null);
        dataValidator.validateYak(yak);
    }

    @Test(expected = YakShopException.class)
    public void shouldThrowYakShopExceptionForNullAge() throws YakShopException {
        Yak yak = createYak("yakName", null, null);
        dataValidator.validateYak(yak);
    }

    @Test(expected = YakShopException.class)
    public void shouldThrowYakShopExceptionForNegativeAge() throws YakShopException {
        Yak yak = createYak("yakName", -100, null);
        dataValidator.validateYak(yak);
    }

    @Test(expected = YakShopException.class)
    public void shouldThrowYakShopExceptionForNegativeDays() throws YakShopException{
        dataValidator.validateDays(-1);
    }    
    
    private Yak createYak(String name, Integer days, Gender gender) {
        Yak yak = new Yak();
        yak.setYakName(null);
        yak.setAgeInDays(days);
        yak.setGender(gender);
        return yak;
    }
}
