package com.flipkart.exception;

// Class declaration - defines a custom exception named RegistrationFailedException
// that extends the built-in Exception class

public class RegistrationFailedException extends Exception{
    @Override
    public String getMessage(){
        // This method returns a custom error message when the exception is thrown
        return "Registration Failed. Please try again";
    }
}
