package com.xebia.yakShop.exception;

/**
 * Defines the application specific exception
 */

public class YakShopException extends Exception {

    private static final long serialVersionUID = -7665441400477911016L;

    /**
     * Default constructor for YakShopException
     */

    public YakShopException() {
    }

    /**
     * Creates YakShopException for an exception message
     */

    public YakShopException(String message) {
        super(message);
    }

    /**
     * Creates YakShopException wrapper for root exception
     */

    public YakShopException(Exception exception) {
        super(exception);
    }
}
