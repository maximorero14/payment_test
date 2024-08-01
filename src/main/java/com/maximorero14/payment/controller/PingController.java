package com.maximorero14.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        long startTime = System.currentTimeMillis();

        long delay = getRandomDelay(10, 300);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Ping request processed in {} ms", duration);

        return "pong";
    }
    private long getRandomDelay(int min, int max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }
}