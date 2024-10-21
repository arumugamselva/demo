package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "datalog", groupId = "art_log_grp")
    public void listToTopic(String message){
        System.out.println("Message " +message);
    }
}
