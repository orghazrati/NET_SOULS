package com.example.net_souls;

import com.example.net_souls.entities.PC;
import com.example.net_souls.entities.User;
import com.example.net_souls.gui.ClientGui;
import com.example.net_souls.gui.ServerGui;
import com.example.net_souls.service.Pc_RepositoryService;
import com.example.net_souls.service.UserRep_Service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@Data
public class ApplicationServer implements CommandLineRunner
{

    @Autowired
    private UserRep_Service userRepService;

    @Autowired
    private Pc_RepositoryService pcRepositoryService;

    public static int trigger;

    public static void main(String[] args) throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ApplicationServer.class);
        builder.headless(false);
        builder.run(args);
    }


    @Override
    public void run(String... args) throws Exception
    {

        ServerGui serverGui = new ServerGui(userRepService,pcRepositoryService);

        ServerSocket server = new ServerSocket(8081);
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        ApplicationClient client = new ApplicationClient();
        ClientGui clientGui = new ClientGui(userRepService, pcRepositoryService);
        Socket socket = server.accept();
        executorService.execute(()->{
            try
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                while (socket.isConnected()) {
                    String client_mac = reader.readLine();
                    serverGui.setStatusOnLogin(userRepService,pcRepositoryService, client_mac);
                    System.out.println(client_mac);
                    System.out.println(trigger);
                    while (true)
                    {
                        if (trigger==1) {
                            System.out.println(trigger);
                            writer.println("shutDown");
                            writer.flush();
                            break;
                        }
                    }

                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        });


    }//end of commandLineRunner implementation

}//end of class

