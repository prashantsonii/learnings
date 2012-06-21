package com.xebia.yakShop.validator;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Yak;

/**
 * Interface which defines method signature for validation purpose
 */
public interface Validator {
    /**
     * Method signature for the yak validation purpose
     */
    void validateYak(Yak yak) throws YakShopException;
    /**
     * Method signature for validating the days
     */
    void validateDays(int days) throws YakShopException;
}
