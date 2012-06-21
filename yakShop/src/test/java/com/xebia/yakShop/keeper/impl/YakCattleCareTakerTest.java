package com.xebia.yakShop.keeper.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.Yak;
import com.xebia.yakShop.processor.DataProcessor;
import com.xebia.yakShop.processor.impl.XMLDataProcessor;

public class YakCattleCareTakerTest {

    private DataProcessor dataProcessor;
    private YakCattleCareTaker careTaker;
    private Herd herd;

    @Before
    public void setUp() throws YakShopException {
        dataProcessor = new XMLDataProcessor();
        careTaker = new YakCattleCareTaker();
        herd = dataProcessor.convertYakDataToHerd(new File("src/test/resources/herd-age-milk-test.xml"));
    }

    @Test
    public void shouldDiscardDeadYaks() {
        assertEquals(4, herd.getHerdSize());

        careTaker.updateLiveCattleStock(herd);
        assertEquals(3, herd.getHerdSize());
    }

    @Test
    public void shouldUpdateAgeOfCattle() {
        List<Yak> yaks = herd.getYaks();
        assertEquals(4, yaks.size());
        assertEquals(new Integer(400), yaks.get(0).getAgeInDays());
        assertEquals(new Integer(800), yaks.get(1).getAgeInDays());
        assertEquals(new Integer(998), yaks.get(2).getAgeInDays());

        careTaker.updateAgeOfCattleStock(herd);
        assertEquals(new Integer(401), yaks.get(0).getAgeInDays());
        assertEquals(new Integer(801), yaks.get(1).getAgeInDays());
        assertEquals(new Integer(999), yaks.get(2).getAgeInDays());
    }

    @Test
    public void shouldDiscardUnderAgedAndOverAgedCattle() throws YakShopException {
        herd = dataProcessor.convertYakDataToHerd(new File("src/test/resources/herd-age-wool-test.xml"));
        careTaker.updateLiveCattleStock(herd);
        assertEquals(4, herd.getHerdSize());
        assertEquals(3, getShavableYaksCount());

        // Elapse 3 days
        for (int i = 0; i < 3; i++) {
            careTaker.updateAgeOfCattleStock(herd);
            careTaker.updateLiveCattleStock(herd);
        }
        assertEquals(3, herd.getHerdSize());
        assertEquals(0, getShavableYaksCount());

        for (int i = 0; i < 2; i++) {
            careTaker.updateAgeOfCattleStock(herd);
            careTaker.updateLiveCattleStock(herd);
        }

        assertEquals(3, herd.getHerdSize());
        assertEquals(1, getShavableYaksCount());

    }

    @Test
    public void shouldShaveYaks() throws YakShopException {
        herd = dataProcessor.convertYakDataToHerd(new File("src/test/resources/herd.xml"));
        careTaker.updateLiveCattleStock(herd);

        // Shave all Yaks on firstDay
        assertEquals(3, getShavableYaksCount());

        // Elapse time by 12 days
        for (int i = 0; i < 12; i++) {
            careTaker.updateAgeOfCattleStock(herd);
            careTaker.updateLiveCattleStock(herd);
            assertEquals(0, getShavableYaksCount());
        }

        // Elapse 13th day
        careTaker.updateAgeOfCattleStock(herd);
        careTaker.updateLiveCattleStock(herd);
        assertEquals(1, getShavableYaksCount());

        // Elapse 14th, 15th and 16th days

        for (int i = 0; i < 3; i++) {
            careTaker.updateAgeOfCattleStock(herd);
            careTaker.updateLiveCattleStock(herd);
            assertEquals(0, getShavableYaksCount());
        }

        // Elapse 17th day
        careTaker.updateAgeOfCattleStock(herd);
        careTaker.updateLiveCattleStock(herd);
        assertEquals(1, getShavableYaksCount());

        // Elapse 18th day
        careTaker.updateAgeOfCattleStock(herd);
        careTaker.updateLiveCattleStock(herd);
        assertEquals(0, getShavableYaksCount());

        // Elapse 19th day..
        careTaker.updateAgeOfCattleStock(herd);
        careTaker.updateLiveCattleStock(herd);
        assertEquals(1, getShavableYaksCount());
    }

    private int getShavableYaksCount() {
        int shavableYaksCount = 0;
        for (Yak yak : herd.getYaks())
            if (yak.isShavable())
                shavableYaksCount++;
        return shavableYaksCount;
    }

}
