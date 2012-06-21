package com.xebia.yakShop.keeper.impl;

import com.xebia.yakShop.keeper.YakKeeper;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.model.Yak;

/**
 * An implementation of Yakkeeper which milks the Yaks
 */
public class YakMilker implements YakKeeper {

    /**
     * Do the tasks relevant to yak milking
     * 
     * @param herd
     */
    @Override
    public void doYakKeeping(HerdProduct product, Herd herd) {
        milkYaks(product, herd);
    }

    private void milkYaks(HerdProduct product, Herd herd) {
        double milkProduced = 0.0;
        for (Yak yak : herd.getYaks()) {
            milkProduced += (50 - 0.03 * yak.getAgeInDays());
        }
        product.setMilkProduced(milkProduced);
    }
}
