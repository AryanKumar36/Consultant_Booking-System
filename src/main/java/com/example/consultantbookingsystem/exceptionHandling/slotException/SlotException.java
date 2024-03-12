package com.example.consultantbookingsystem.exceptionHandling.slotException;

public class SlotException extends RuntimeException{
    public SlotException(String message) {
        super(message);
    }

    public SlotException(String message, Throwable cause) {
        super(message, cause);
    }

    public SlotException(Throwable cause) {
        super(cause);
    }
}
