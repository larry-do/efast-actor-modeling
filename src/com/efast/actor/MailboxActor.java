package com.efast.actor;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class MailboxActor implements Actor {
    private final String id;
    private final ConcurrentLinkedQueue<MailPackage> mailbox;

    {
        mailbox = new ConcurrentLinkedQueue<>();
    }

    public MailboxActor(String id) {
        this.id = id;
    }

    @Override
    public void receive(MailPackage message) {
        mailbox.add(message);
    }

    @Override
    public void send(MailPackage mailPackage) {
        ActorOrchestration.sendMail(mailPackage);
    }

    public MailPackage takeMailOut() {
        return mailbox.poll();
    }

    public MailPackage peekMail() {
        return mailbox.peek();
    }

    public String actorId() {
        return id;
    }
}
