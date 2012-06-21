package com.xebia.yakShop.model;

import static com.xebia.yakShop.constants.Constants.DAYS_IN_YAK_YEAR;

import java.text.MessageFormat;

import com.xebia.yakShop.constants.Gender;

/**
 * Represents the Yak
 */
public class Yak {
    private String yakName;
    private Integer ageInDays;
    private Gender gender;

    private int shaveInterval;
    private boolean shavable;

    /**
     * Returns the Yak Name
     */
    public String getYakName() {
        return yakName;
    }

    /**
     * Sets the yak name
     */
    public void setYakName(String yakName) {
        this.yakName = yakName;
    }

    /**
     * Returns the age of Yak in days
     */
    public Integer getAgeInDays() {
        return ageInDays;
    }

    /**
     * Sets the age of yak in days
     */
    public void setAgeInDays(Integer ageInDays) {
        this.ageInDays = ageInDays;
    }

    /**
     * Returns the gender of Yak
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of Yak
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Returns string representation of Yak
     */
    public String toString() {
        MessageFormat mFormat = new MessageFormat("{0} {1} years old");
        return mFormat.format(new Object[] { yakName, ((double) ageInDays) / DAYS_IN_YAK_YEAR });
    }

    /**
     * Sets the shave interval
     */
    public void setShaveInterval(int shaveInterval) {
        this.shaveInterval = shaveInterval;
    }

    /**
     * Returns the shave interval
     */
    public int getShaveInterval() {
        return shaveInterval;
    }

    /**
     * Set if a Yak can be shaved
     */
    public void setShavable(boolean shavable) {
        this.shavable = shavable;
    }

    /**
     * returns if a Yak can be shaved
     */
    public boolean isShavable() {
        return shavable;
    }

}
