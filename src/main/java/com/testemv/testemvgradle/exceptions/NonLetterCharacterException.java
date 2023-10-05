package com.testemv.testemvgradle.exceptions;
public class NonLetterCharacterException extends RuntimeException{
    public NonLetterCharacterException (String message){
        super(message);
    }
}
