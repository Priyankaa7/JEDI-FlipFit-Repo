package com.flipkart.exception;

// Class declaration - defines a custom exception named SlotInsertionFailedException
// that extends the built-in Exception class

public class SlotInsertionFailedException extends Exception{
    @Override
    public String getMessage(){
        //This method returns a custom error message when the exception is thrown
        return "Slot Insertion Failed";
    }
}
