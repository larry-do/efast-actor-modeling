package com.efast.actor;

public interface Actor {
    String actorId();

    void receive(MailPackage mailPackage);

    void send(MailPackage mailPackage);
}
