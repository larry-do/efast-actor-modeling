package com.efast.actor.agency;

import com.efast.actor.Actor;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class ActorOrchestration {
    private static final Logger LOGGER = Logger.getLogger(ActorOrchestration.class.getName());
    private static final ConcurrentHashMap<String, Actor> actors;

    static {
        actors = new ConcurrentHashMap<>();
    }

    public static void register(Actor actor) {
        if (actor == null) {
            throw new RuntimeException("Can't register actor null");
        }

        if (actor.actorId() == null || actor.actorId().isEmpty()) {
            throw new RuntimeException("Can't register actor having empty id");
        }

        if (actors.containsKey(actor.actorId())) {
            throw new RuntimeException("Can't register actor having existing id");
        }

        actors.put(actor.actorId(), actor);
        LOGGER.info("Actor " + actor.actorId() + " registered");
    }

    public static Optional<Actor> getActor(String id) {
        return Optional.ofNullable(actors.get(id));
    }
}
