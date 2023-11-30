package com.efast.actor;

public interface MailboxActor extends Actor {
    void receive(MailPackage mailPackage);

    void send(MailPackage mailPackage);

    MailPackage takeMailOut();

    MailPackage peekMail();

    String actorId();
}
