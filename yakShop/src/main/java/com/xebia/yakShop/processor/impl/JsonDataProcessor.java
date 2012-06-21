package com.xebia.yakShop.processor.impl;

import java.io.File;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.processor.DataProcessor;

/**
 * Implementation of DataProcessor interface to parse the JSON data and convert
 * it to Herd
 */
public class JsonDataProcessor implements DataProcessor {

    @Override
    public Herd convertYakDataToHerd(File file) throws YakShopException {
        // Future extension point, if needed to process JSON Data Input file
        return null;
    }

}
