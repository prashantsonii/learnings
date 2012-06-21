package com.xebia.yakShop.model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines the entire herd of yaks
 * 
 */
public class Herd {

    /**
     * Collection of yaks in Herd
     */
    private List<Yak> yaks;

    /**
     * Default constructor which creates an empty collection of yaks
     */
    public Herd() {
        yaks = new ArrayList<Yak>();
    }

    /**
     * Returns the collection of yaks
     */
    public List<Yak> getYaks() {
        return yaks;
    }

    /**
     * Set the yak collection
     */
    public void setYaks(List<Yak> yaks) {
        this.yaks.addAll(yaks);
    }

    /**
     * Add a yak to the herd
     */
    public void addYak(Yak yak) {
        this.yaks.add(yak);
    }

    /**
     * Remove a yak from the herd
     */
    public void removeYak(Yak yak) {
        this.yaks.remove(yak);
    }

    /**
     * Returns number of Yaks in the herd
     */
    public int getHerdSize() {
        if (yaks != null)
            return yaks.size();
        else
            return 0;
    }

    /**
     * Returns string representation of the herd
     */
    public String toString() {
        MessageFormat mFormat = new MessageFormat("Herd : \n{0}");
        StringBuffer herdString = new StringBuffer("");
        for (Yak yak : yaks)
            herdString.append("\t").append(yak).append("\n");
        return mFormat.format(new Object[] { herdString });
    }

}
