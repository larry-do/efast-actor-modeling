package com.efast.actor;

import java.util.UUID;

public class MailPackage {
    private final String mailId;
    private final Message<?> message;
    private final String receiverId;

    public MailPackage(Message<?> message, String receiverId) {
        this.message = message;
        this.receiverId = receiverId;
        this.mailId = UUID.randomUUID().toString();
    }

    public String getReceiverId() {
        return receiverId;
    }

    Message<?> getMessage() {
        return message;
    }

    public final String getMailId() {
        return this.mailId;
    }
}
