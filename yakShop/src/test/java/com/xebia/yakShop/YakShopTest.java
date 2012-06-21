package com.xebia.yakShop;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.processor.DataProcessor;
import com.xebia.yakShop.processor.impl.XMLDataProcessor;

public class YakShopTest {

    private YakShop yakShop;
    private DataProcessor dataProcessor;

    @Before
    public void setUp() throws YakShopException {
        dataProcessor = new XMLDataProcessor();
        yakShop = new YakShop();
        yakShop.setHerd(dataProcessor.convertYakDataToHerd(new File("src/test/resources/herd.xml")));
    }

    @Test
    public void shouldCalculateMilkHerdOutput1() throws YakShopException {
        HerdProduct product = yakShop.getHerdTotalOutput(13);
        assertEquals(new Double(1104.480), product.getMilkProduced());
    }

    @Test
    public void shouldCalculateMilkHerdOutput2() throws YakShopException {
        HerdProduct product = yakShop.getHerdTotalOutput(14);
        assertEquals(new Double(1188.810), product.getMilkProduced());
    }

    @Test
    public void shouldCalculateWoolHerdOutput1() throws YakShopException {
        HerdProduct product = yakShop.getHerdTotalOutput(13);
        assertEquals(new Integer(3), product.getWoolProduced());
    }

    @Test
    public void shouldCalculateWoolHerdOutput2() throws YakShopException {
        HerdProduct product = yakShop.getHerdTotalOutput(14);
        assertEquals(new Integer(4), product.getWoolProduced());
    }

    @Test
    public void shouldProcessAgingCattleDiscardingDeads() throws YakShopException {
        yakShop.setHerd(dataProcessor.convertYakDataToHerd(new File("src/test/resources/herd-age-milk-test.xml")));

        // Elapse 4 days, so that another yak is dead
        HerdProduct herdProduct = yakShop.getHerdTotalOutput(4);
        assertEquals(2, yakShop.getHerd().getHerdSize());

        // For initial 3 days, it will milk all Yak, on 4th day one Yak dies, so
        // it will milk only 3 Yaks
        assertEquals(new Double(315.73), herdProduct.getMilkProduced());

    }

}
