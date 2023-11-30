package com.efast.actor.implementation;

import com.efast.actor.MailPackage;
import com.efast.actor.MailboxActor;
import com.efast.actor.agency.ActorOrchestration;

public class Main {
    public static void main(String[] args) {
        ActorOrchestration.register(new TicketAgent("ticket-agent-1"));

        for (int i = 0; i < 100; i++) {
            ActorOrchestration.register(new Audience("audience-" + i));
        }

        MailboxActor ticketAgent = (MailboxActor) ActorOrchestration.getActor("ticket-agent-1").get();
        ticketAgent.send(new MailPackage(null, "audience-1"));
    }
}
