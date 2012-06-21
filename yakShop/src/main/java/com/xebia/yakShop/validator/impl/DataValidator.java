package com.xebia.yakShop.validator.impl;

import org.apache.commons.lang.StringUtils;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Yak;
import com.xebia.yakShop.validator.Validator;

/**
 * Performs various sorts of data validation. These dont specify the business
 * rules validation.
 */
public class DataValidator implements Validator {

    /**
     * Method that performs data validation.
     */
    public void validateYak(Yak yak) throws YakShopException {
        if (yak.getAgeInDays() == null)
            throw createYakShopException("Yaks with null ages not allowed");
        if (yak.getAgeInDays() < 0)
            throw createYakShopException("Yaks with negative ages not allowed");
        if (StringUtils.isEmpty(yak.getYakName()))
            throw createYakShopException("Yaks without names not allowed");
        if (yak.getGender() == null)
            throw createYakShopException("Yaks without genders not allowed");
    }

    private YakShopException createYakShopException(String message) {
        YakShopException yakShopException = new YakShopException(message);
        return yakShopException;
    }

    @Override
    public void validateDays(int days) throws YakShopException {
        if(days < 0 )
            throw new YakShopException("Days cannot be less than 1");
    }

}
