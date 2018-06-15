package com.taxi.exception;

/**
 *
 * @author gokumar
 */
public class FileNotFoundException extends TaxiException {

    private static final long serialVersionUID = -8467292822587338980L;

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Exception ex) {
        super(message, ex);
    }
}
