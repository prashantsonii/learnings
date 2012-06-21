package com.xebia.yakShop.model;

import java.text.MessageFormat;

/**
 * Container class for the Product produced by Yak
 */
public class HerdProduct {
    private double milkProduced;
    private int woolProduced;

    /**
     * Set the milk quantity
     */
    public void setMilkProduced(double milkProduced) {
        this.milkProduced = milkProduced;
    }

    /**
     * Returns the milk produced
     */
    public Double getMilkProduced() {
        return milkProduced;
    }

    /**
     * Sets the wool quantity
     */
    public void setWoolProduced(int woolProduced) {
        this.woolProduced = woolProduced;
    }

    /**
     * Returns the wool quantity
     */
    public Integer getWoolProduced() {
        return woolProduced;
    }

    /**
     * Returns the String representation.
     */
    public String toString() {
        MessageFormat mformat = new MessageFormat("In Stock : \n\t{0} litres of milk \n\t{1} skils of wool \n");
        return mformat.format(new Object[] { milkProduced, woolProduced });
    }
}
