package com.xebia.yakShop;

import java.io.File;

import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.HerdProduct;
import com.xebia.yakShop.processor.DataProcessor;
import com.xebia.yakShop.processor.impl.XMLDataProcessor;

/**
 * Executable class to perform operation on Yaks
 */
public class Application {
    /**
     * Entry method
     */
    public static void main(String[] args) {
        //Log log = LogFactory.getLog(Application.class);
        
        if (args.length < 2) {
            printUsage();
            System.exit(1);
        }
        YakShop yakShop = new YakShop();
        DataProcessor xmlDataprocessor = new XMLDataProcessor();
        try {
            yakShop.setHerd(xmlDataprocessor.convertYakDataToHerd(new File(args[0])));
            HerdProduct herdProduct = yakShop.getHerdTotalOutput(Integer.parseInt(args[1]));
            System.out.println(herdProduct);
            System.out.println(yakShop.getHerd());
        } catch (YakShopException e) {
            System.out.println("Exception : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Exception : Not a valid day count " + args[1]);
        }
    }

    private static void printUsage() {
        System.out.println("Application <xml-file> <elapsedDays>");
    }

}
