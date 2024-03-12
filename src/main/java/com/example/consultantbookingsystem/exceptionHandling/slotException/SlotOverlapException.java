package com.example.consultantbookingsystem.exceptionHandling.slotException;

public class SlotOverlapException extends RuntimeException{
    public SlotOverlapException() {
        super("The new time slot overlaps with an existing one.");
    }

    public SlotOverlapException(String message) {
        super(message);
    }

    public SlotOverlapException(String message, Throwable cause) {
        super(message, cause);
    }
}
