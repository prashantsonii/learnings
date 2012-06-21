package com.xebia.yakShop.keeper.impl;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.processor.DataProcessor;
import com.xebia.yakShop.processor.impl.XMLDataProcessor;

public class YakMilkerTest {

    private DataProcessor dataProcessor;
    private YakMilker milker;
    private HerdProduct herdProduct;
    private Herd herd;

    @Before
    public void setUp() throws YakShopException {
        dataProcessor = new XMLDataProcessor();
        milker = new YakMilker();
        herdProduct = new HerdProduct();
        herd = dataProcessor.convertYakDataToHerd(new File("src/test/resources/herd.xml"));
    }

    @Test
    public void shouldCalculateMilkProduced() {
        milker.doYakKeeping(herdProduct, herd);
        assertEquals(new Double(85.5), herdProduct.getMilkProduced());
    }

}
