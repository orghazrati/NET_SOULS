package com.example.net_souls;

import com.example.net_souls.gui.ServerGui;
import com.example.net_souls.service.Pc_RepositoryService;
import com.example.net_souls.service.UserRep_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ApplicationClient
{
    private static Socket socket;



    public static void main(String[] args) throws IOException
    {

        //get the mac address
        Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
        String line;
        line = in.readLine();
        String[] result = line.split(",");
        String mac = result[0].replace('"', ' ').trim();

        //connect to server
        try
        {
            socket = new Socket("localhost",8081);

            while (socket.isConnected())
            {
                PrintWriter output_stream = new PrintWriter(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("I connected!");
                output_stream.println(mac);
                output_stream.flush();

                String server_msg = reader.readLine();


                while (server_msg.equals("shutDown"))
                {

                    Runtime runtime = Runtime.getRuntime();
                    String shutdownCommand = "shutdown -s -t 2"; // Shutdown after 2 seconds

                    try {
                        // Execute the command using Runtime.exec() method.
                        runtime.exec(shutdownCommand);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }//end of main

    public void connectToServer()
    {
        try
        {
               this.socket.connect(this.socket.getRemoteSocketAddress());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//end of method,

}//end of class
