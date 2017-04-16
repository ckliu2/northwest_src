package com.base.except;

public class SessionTimeoutException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for DataAccessException.
     * @param msg message
     */
    public SessionTimeoutException(String msg) 
    {
        super(msg);
    } 

    /**
     * Constructor for DataAccessException.
     * @param msg message
     * @param ex root cause (usually from using a underlying
     * data access API such as JDBC)
     */
    public SessionTimeoutException(String msg, Throwable ex) 
    {
        super(msg, ex);
    }
}
