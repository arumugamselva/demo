package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.service.Consumer;
import com.example.demo.service.DemoService;
import com.example.demo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;

    @GetMapping("/get/app/{id}")
    public Application getApp(@PathVariable("id") String id){
        return demoService.getApplication(id);
    }

    @PostMapping("/create/app")
    public Application createApplication(String appName){
       return demoService.createApplication(appName);
    }

    @GetMapping("/pushMessage/{message}")
    public ResponseEntity<String> produceMessage(@PathVariable("message") String message){
        producer.sendMsgToTopic(message);
        return ResponseEntity.ok("Submitted successfully");
    }
}
