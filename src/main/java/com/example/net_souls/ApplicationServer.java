package com.example.net_souls;

import com.example.net_souls.entities.User;
import com.example.net_souls.gui.ServerGui;
import com.example.net_souls.service.UserRep_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Date;

@SpringBootApplication
public class ApplicationServer implements CommandLineRunner
{

    @Autowired
    private UserRep_Service userRepService;

    public static void main(String[] args)
    {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ApplicationServer.class);
        builder.headless(false);
        builder.run(args);
    }


    @Override
    public void run(String... args) throws Exception
    {
        ServerGui serverGui = new ServerGui(userRepService);
    }
}

