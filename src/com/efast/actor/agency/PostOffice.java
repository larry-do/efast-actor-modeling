package com.efast.actor.agency;

import com.efast.actor.Actor;
import com.efast.actor.MailPackage;
import com.efast.actor.MailboxActor;

import java.util.Optional;
import java.util.logging.Logger;

public class PostOffice {
    private static final Logger LOGGER = Logger.getLogger(PostOffice.class.getName());

    public static void sendMail(MailPackage mailPackage) {
        if (mailPackage == null) {
            throw new RuntimeException("Can't process mail package null");
        }

        if (mailPackage.getReceiverId() == null || mailPackage.getReceiverId().isEmpty()) {
            throw new RuntimeException("Can't process receiver empty");
        }

        final Optional<Actor> result = ActorOrchestration.getActor(mailPackage.getReceiverId());
        if (result.isEmpty()) {
            throw new RuntimeException("Not found receiver " + mailPackage.getReceiverId());
        }

        Actor actor = result.get();
        if (!(actor instanceof MailboxActor)) {
            throw new RuntimeException("Actor of receiver is not MailboxActor");
        }

        LOGGER.info(String.format("Sending mail package %s to receiver %s...",
                mailPackage.getMailId(), mailPackage.getReceiverId()));
        ((MailboxActor) actor).receive(mailPackage);
    }
}
