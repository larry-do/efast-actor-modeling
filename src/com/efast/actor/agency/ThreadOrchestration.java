package com.efast.actor.agency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadOrchestration {
    private final static ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(10);
    }

    
}
