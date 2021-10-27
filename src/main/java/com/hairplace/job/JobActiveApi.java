package com.hairplace.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class JobActiveApi {
    private static final int TASK_HOUR = 1 * 60 * 1000; // 1 min
    private static final int TASK_INIT = 20 * 1000; // 20 sec

    private static DateFormat formatter = new SimpleDateFormat(("dd/MM/yyyy HH:mm"));

    @Scheduled(initialDelay = TASK_INIT, fixedRate = TASK_HOUR)
    public void taskExecutada() {

        System.out.println("Executando taskExecutada...");

    }
}
