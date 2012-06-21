package com.xebia.yakShop.keeper;

import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.HerdProduct;

/**
 * Inteface which a class needs to implement if it wants to perform yak keeping.
 * 
 */
public interface YakKeeper {

    /**
     * Put the yak keeping implementation in this method
     */
    void doYakKeeping(HerdProduct product, Herd herd);

}
