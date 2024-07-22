package com.flipkart.exception;

// Class declaration - defines a custom exception named InvalidCredentialsException
// that extends the built-in Exception class

public class InvalidCredentialsException extends Exception{
    @Override
    public String getMessage(){
        // This method returns a custom error message when the exception is thrown
        return "Wrong credentials. Please enter correct credentials.";
    }
}
