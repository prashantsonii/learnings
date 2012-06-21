package com.xebia.yakShop.keeper.impl;

import com.xebia.yakShop.keeper.YakKeeper;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.model.Yak;

/**
 * Implementation of YakKeeper to perform Yak shaving
 * 
 */
public class YakShaver implements YakKeeper {
    /**
     * Defines the tasks for yak shaving
     */
    @Override
    public void doYakKeeping(HerdProduct product, Herd herd) {
        shaveYaks(product, herd);
    }

    private void shaveYaks(HerdProduct product, Herd herd) {
        int shaveCount = 0;
        product.setWoolProduced(0);
        for (Yak yak : herd.getYaks()) {
            if (yak.isShavable()) {
                shaveCount = shaveYak(shaveCount, yak);
            }
        }
        product.setWoolProduced(shaveCount);
    }

    private int shaveYak(int shaveCount, Yak yak) {
        // Do other tasks to shave Yaks
        return shaveCount + 1;
    }
}
