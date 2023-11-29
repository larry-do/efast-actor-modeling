package com.efast.actor;

public class MailPackage {
    private final Message<?> message;
    private final String receiverId;

    public MailPackage(Message<?> message, String receiverId) {
        this.message = message;
        this.receiverId = receiverId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    Message<?> getMessage() {
        return message;
    }
}
