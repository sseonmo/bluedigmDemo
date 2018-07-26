package com.bluedigm.demo.common.exception;

/**
 * The type Base service exception.
 */
public class BaseServiceException extends RuntimeException {
    private static final long serialVersionUID = 3307741382365655760L;

    /**
     * Instantiates a new Base service exception.
     *
     * @param message the message
     */
    public BaseServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Base service exception.
     *
     * @param message the message
     * @param error   the error
     */
    public BaseServiceException(String message, Throwable error) {
        super(message, error);
    }

    /**
     * Instantiates a new Base service exception.
     *
     * @param e the e
     */
    public BaseServiceException(Throwable e) {
        super(e);
    }
}
