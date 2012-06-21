package com.xebia.yakShop.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakShop.constants.Constants;
import com.xebia.yakShop.constants.Gender;
import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.Yak;
import com.xebia.yakShop.processor.impl.XMLDataProcessor;

public class XMLDataProcessorTest {

    private File xmlFile;
    private DataProcessor dataProcessor;

    @Before
    public void setUp() throws Exception {
        xmlFile = new File("src/test/resources/herd.xml");
        dataProcessor = new XMLDataProcessor();
    }

    @Test
    public void shouldCorrectlyParseXML() throws YakShopException {
        Herd herd = dataProcessor.convertYakDataToHerd(xmlFile);
        assertNotNull(herd);
    }

    @Test(expected = YakShopException.class)
    public void shouldThrowExceptionForInvalidXML() throws YakShopException {
        xmlFile = new File("src/test/resources/herd-invalid-xml.xml");
        dataProcessor.convertYakDataToHerd(xmlFile);
    }

    @Test(expected = YakShopException.class)
    public void shouldThrowExceptionForInvalidData() throws YakShopException {
        xmlFile = new File("src/test/resources/herd-invalid-age.xml");
        dataProcessor.convertYakDataToHerd(xmlFile);
    }

    @Test
    public void shouldProperlyExtractHerd() throws YakShopException {
        Herd herd = dataProcessor.convertYakDataToHerd(xmlFile);
        assertNotNull(herd);
        assertEquals(3, herd.getYaks().size());
        Yak yak = herd.getYaks().get(0);
        assertEquals("Betty-1", yak.getYakName());
        assertEquals(new Integer(4 * Constants.DAYS_IN_YAK_YEAR), yak.getAgeInDays());
        assertSame(Gender.F, yak.getGender());
        assertNotSame(Gender.M, yak.getGender());
    }

}
