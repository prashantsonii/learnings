package com.xebia.yakShop.validator.impl;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Yak;
import com.xebia.yakShop.validator.Validator;

/**
 * Implementation of Validator interface to perform validation of business rules
 * 
 */
public class BusinessRulesValidator implements Validator {

    /**
     * Method that performs business rules validation
     */
    @Override
    public void validateYak(Yak yak) throws YakShopException {
    }

    @Override
    public void validateDays(int days) throws YakShopException {
        // TODO Auto-generated method stub
        
    }

}
