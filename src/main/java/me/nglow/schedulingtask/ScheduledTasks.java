package me.nglow.schedulingtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 5000) // Set start time when task is started.
    public void reportCurrentTimeByFixedRate() {
        log.info("The time recorded by fixed rate: {}", LocalDateTime.now().format(format));
    }

    @Scheduled(fixedDelay = 3000) // Set start time when task is done.
    public void reportCurrentTimeFixedDelay() {
        log.info("The time recorded by fixed delay: {}", LocalDateTime.now().format(format));
    }

    @Scheduled(cron = "* * * * * ?")
    public void reportCurrentTimeCron() {
        log.info("The time recorded by cron: {}", LocalDateTime.now().format(format));
    }
}
