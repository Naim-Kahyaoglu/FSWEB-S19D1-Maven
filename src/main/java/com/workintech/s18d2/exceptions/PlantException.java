package com.workintech.s18d2.exceptions;

/**
 * Custom exception to be thrown when there's an error with plant-related operations.
 */
public class PlantException extends RuntimeException {

    /**
     * Constructs a new PlantException with the specified detail message.
     * @param message the detail message.
     */
    public PlantException(String message) {
        super(message);
    }

    /**
     * Constructs a new PlantException with the specified detail message and cause.
     * @param message the detail message.
     * @param cause the cause.
     */
    public PlantException(String message, Throwable cause) {
        super(message, cause);
    }
}
