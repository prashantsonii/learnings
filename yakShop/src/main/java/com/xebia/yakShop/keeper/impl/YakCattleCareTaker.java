package com.xebia.yakShop.keeper.impl;

import java.util.ArrayList;
import java.util.List;

import com.xebia.yakShop.keeper.YakKeeper;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.model.Yak;

/**
 * Performs Yak care taking, functions include - removal of aged (dead) yaks,
 * updating the age of yaks, marking yaks as shavable
 */
public class YakCattleCareTaker {

    private List<YakKeeper> yakKeepers;

    /**
     * Default constructor which initializes the list of Keepers
     */
    public YakCattleCareTaker() {
        yakKeepers = new ArrayList<YakKeeper>();
    }

    /**
     * Updates the age of yaks
     */
    public void updateAgeOfCattleStock(Herd herd) {
        for (Yak yak : herd.getYaks()) {
            yak.setAgeInDays(yak.getAgeInDays() + 1);
        }
    }

    /**
     * Add Keepers (YakMilker and YakShaver) to the keepers list
     */
    public void addYakKeepers(YakKeeper keeper) {
        yakKeepers.add(keeper);
    }

    /**
     * Remove Keepers (YakMilker and YakShaver) from keepers list
     */
    public void removeYakKeepers(YakKeeper keeper) {
        yakKeepers.remove(keeper);
    }

    /**
     * Ask YakKeepers to perform YakKeeping activity
     */
    public void keepYaks(HerdProduct product, Herd herd) {
        for (YakKeeper yakKeeper : yakKeepers)
            yakKeeper.doYakKeeping(product, herd);
    }

    /**
     * Finds out dead yaks, removes them from herd marks yaks as shavable.
     */
    public void updateLiveCattleStock(Herd herd) {
        List<Yak> deadYaks = new ArrayList<Yak>();
        for (Yak yak : herd.getYaks()) {
            if (yak.getAgeInDays() > 1000)
                deadYaks.add(yak);
        }
        herd.getYaks().removeAll(deadYaks);
        updateShavableYaks(herd);
    }

    private void updateShavableYaks(Herd herd) {
        for (Yak yak : herd.getYaks()) {
            if (yak.getShaveInterval() == 0 && yak.getAgeInDays() >= 100) {
                yak.setShavable(true);
                yak.setShaveInterval((int) Math.ceil(8 + yak.getAgeInDays() * 0.01));
            } else {
                yak.setShavable(false);
                if (yak.getAgeInDays() >= 100)
                    yak.setShaveInterval(yak.getShaveInterval() - 1);
            }
        }
    }
}
