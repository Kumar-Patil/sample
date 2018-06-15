package com.taxi.exception;

/**
 *
 * @author gokumar
 */
public class EmailException extends TaxiException {

    private static final long serialVersionUID = -8467292822587338980L;

    public EmailException(String message) {
        super(message);
    }

    public EmailException(String message, Exception ex) {
        super(message, ex);
    }
}
