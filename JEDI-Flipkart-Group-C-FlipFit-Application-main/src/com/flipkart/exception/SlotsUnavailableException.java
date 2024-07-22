package com.flipkart.exception;

// Class declaration - defines a custom exception named SlotsUnavailableException
// that extends the built-in Exception class

public class SlotsUnavailableException extends Exception{
    @Override
    public String getMessage(){
        // This method returns a custom error message when the exception is thrown
        return "Slots unavailable. Please try another gym or different slot in the gym";
    }
}
