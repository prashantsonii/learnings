package com.xebia.yakShop.processor;

import java.io.File;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Herd;

/**
 * Represents the interface for the dataprocessing implementations
 */
public interface DataProcessor {

    /**
     * Method to transform the provided data to Herd of yaks
     */
    Herd convertYakDataToHerd(File file) throws YakShopException;

}
