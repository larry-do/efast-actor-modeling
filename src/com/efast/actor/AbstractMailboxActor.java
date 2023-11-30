package com.efast.actor;

import com.efast.actor.agency.PostOffice;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public abstract class AbstractMailboxActor implements MailboxActor {
    private static final Logger LOGGER = Logger.getLogger(AbstractMailboxActor.class.getName());
    private final String id;
    private final ConcurrentLinkedQueue<MailPackage> mailbox;

    {
        mailbox = new ConcurrentLinkedQueue<>();
    }

    public AbstractMailboxActor(String id) {
        this.id = id;
    }

    @Override
    public void receive(MailPackage mailPackage) {
        mailbox.add(mailPackage);
        LOGGER.info(String.format("Actor %s received mail package %s", this.actorId(),
                mailPackage.getMailId()));
    }

    @Override
    public void send(MailPackage mailPackage) {
        LOGGER.info(String.format("Actor %s sending mail package %s to PostOffice", this.actorId(),
                mailPackage.getMailId()));
        PostOffice.sendMail(mailPackage);
    }

    @Override
    public MailPackage takeMailOut() {
        return mailbox.poll();
    }

    @Override
    public MailPackage peekMail() {
        return mailbox.peek();
    }

    @Override
    public String actorId() {
        return id;
    }
}
