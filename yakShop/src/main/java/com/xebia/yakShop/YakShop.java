package com.xebia.yakShop;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.keeper.YakKeeper;
import com.xebia.yakShop.keeper.impl.YakCattleCareTaker;
import com.xebia.yakShop.keeper.impl.YakMilker;
import com.xebia.yakShop.keeper.impl.YakShaver;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.validator.Validator;
import com.xebia.yakShop.validator.impl.DataValidator;

/**
 * Represents the shop of the shepherd
 */
public class YakShop {

    private Herd herd;

    private YakCattleCareTaker yakCattleCareTaker;
    
    private Validator dataValidator;

    /**
     * Default constructor which instantiates the
     */
    public YakShop() {
        yakCattleCareTaker = new YakCattleCareTaker();
        YakKeeper yakMilker = new YakMilker();
        YakKeeper yakShaver = new YakShaver();
        yakCattleCareTaker.addYakKeepers(yakMilker);
        yakCattleCareTaker.addYakKeepers(yakShaver);
        dataValidator = new DataValidator();
    }

    public Herd getHerd() {
        return herd;
    }

    public void setHerd(Herd herd) {
        this.herd = herd;
    }

    /**
     * Calcuates the total milk and wool output of the herd in specified number of days
     * @throws YakShopException 
     */
    public HerdProduct getHerdTotalOutput(int days) throws YakShopException {
        dataValidator.validateDays(days);
        HerdProduct totalHerdProduct = new HerdProduct();
        for (int i = 0; i < days; i++) {
            HerdProduct product = new HerdProduct();
            yakCattleCareTaker.updateLiveCattleStock(herd);
            yakCattleCareTaker.keepYaks(product, herd);
            yakCattleCareTaker.updateAgeOfCattleStock(herd);
            totalHerdProduct.setMilkProduced(totalHerdProduct.getMilkProduced() + product.getMilkProduced());
            totalHerdProduct.setWoolProduced(totalHerdProduct.getWoolProduced() + product.getWoolProduced());
        }
        return totalHerdProduct;
    }
}
