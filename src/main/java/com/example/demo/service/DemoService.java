package com.example.demo.service;

import com.example.demo.model.Application;
import com.example.demo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DemoService {

    @Autowired
    ApplicationRepository applicationRepository;
    public Application getApplication(String id){
        try{
            return  applicationRepository.getApplicationById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Application createApplication(String appName){
        try{
            Application app = new Application();
            app.setId(String.valueOf(UUID.randomUUID()));
            app.setName(appName);
            applicationRepository.save(app);
            return app;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
