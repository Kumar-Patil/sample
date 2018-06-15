
package com.taxi.exception;

/**
 *
 * @author 
 */
public class TaxiException extends Exception{

    private static final long serialVersionUID = -7908905882651157775L;

    public TaxiException(String message) {
        super(message);
    }

    public TaxiException(Exception e) {
        super(e);
    }

    public TaxiException(String message, Exception ex) {
        super(message, ex);
    }
}
