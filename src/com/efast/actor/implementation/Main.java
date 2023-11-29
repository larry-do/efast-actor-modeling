package com.efast.actor.implementation;

import com.efast.actor.ActorOrchestration;

public class Main {
    public static void main(String[] args) {
        ActorOrchestration.register(new TicketAgent("ticket-agent-1"));
    }
}
