package com.xebia.yakShop.keeper.impl;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.keeper.YakKeeper;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.processor.DataProcessor;
import com.xebia.yakShop.processor.impl.XMLDataProcessor;

public class YakShaverTest {

    private DataProcessor dataProcessor;
    private YakKeeper yakShaver;
    private HerdProduct herdProduct;
    private Herd herd;

    @Before
    public void setUp() throws YakShopException {
        dataProcessor = new XMLDataProcessor();
        yakShaver = new YakShaver();
        herdProduct = new HerdProduct();
        herd = dataProcessor.convertYakDataToHerd(new File("src/test/resources/herd.xml"));
    }

    @Test
    public void shouldShaveShavableYaksOnly() {
        herd.getYaks().get(0).setShavable(true);
        herd.getYaks().get(1).setShavable(false);
        herd.getYaks().get(2).setShavable(true);
        yakShaver.doYakKeeping(herdProduct, herd);
        assertEquals(new Integer(2), herdProduct.getWoolProduced());
    }
}
