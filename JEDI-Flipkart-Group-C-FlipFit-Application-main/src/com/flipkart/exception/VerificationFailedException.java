package com.flipkart.exception;

// Class declaration - defines a custom exception named VerificationFailedException
// that extends the built-in Exception class

public class VerificationFailedException extends Exception{
    @Override
    public String getMessage(){
        // This method returns a custom error message when the exception is thrown
        return "Verification Failed.";
    }
}
