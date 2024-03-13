package com.example.net_souls.gui;

import com.example.net_souls.entities.PC;
import com.example.net_souls.entities.User;
import com.example.net_souls.service.Pc_RepositoryService;
import com.example.net_souls.service.UserRep_Service;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

@Component
public class ClientGui
{
    @Autowired
    public ClientGui(UserRep_Service userRepService, Pc_RepositoryService pcRepositoryService) throws IOException
    {
        //get the mac address
        Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
        String line;
        line = in.readLine();
        String[] result = line.split(",");
        String mac = result[0].replace('"', ' ').trim();


        //frame config
        JFrame frame = new JFrame("NET SOULS");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(1920, 1080);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //main panel config
        JPanel main_panel = new JPanel();
        main_panel.setVisible(true);
        main_panel.setSize(1920, 1080);
        main_panel.setLayout(null);
        main_panel.setBackground(Color.BLACK);

        main_panel.removeAll();

        JLabel username = new JLabel("enter username:");
        username.setSize(150, 25);
        username.setLocation(25, 20);
        username.setForeground(Color.GREEN);
        username.setFont(new Font("Comic Sans", Font.PLAIN, 20));

        JTextField username_field = new JTextField();
        username_field.setSize(190, 30);
        username_field.setLocation(190, 20);
        username_field.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel password = new JLabel("enter password:");
        password.setSize(150, 25);
        password.setLocation(25, 55);
        password.setForeground(Color.GREEN);
        password.setFont(new Font("Comic Sans", Font.PLAIN, 20));

        JTextField password_field = new JTextField();
        password_field.setSize(190, 30);
        password_field.setLocation(190, 55);
        password_field.setFont(new Font("Arial", Font.BOLD, 15));

        JButton login = new JButton("LOGIN");
        login.setSize(110, 35);
        login.setLocation(35, 77);
        login.setFocusable(false);
        login.setBackground(Color.BLUE.brighter().brighter());
        login.setForeground(Color.red.brighter());

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    PC pc = pcRepositoryService.findPcByMac(mac);
                    User user = userRepService.login(username_field.getText(), password_field.getText());
                    pc.setUser(user);
                    user.setStatus("online");
                    userRepService.createUser(user);
                    pc.setStatus("online");
                    pcRepositoryService.createPc(pc);
                    JOptionPane.showMessageDialog(null, "WELCOME !", "NET SOULS",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });//end of login action.


            JButton logout = new JButton("LOGOUT !");
            logout.setSize(120, 40);
            logout.setLocation(40, 100);
            logout.setForeground(Color.YELLOW);
            logout.setBackground(Color.RED);
            logout.setFocusable(false);


            logout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    User user = userRepService.login(username_field.getText(), password_field.getText());
                    user.setStatus("offline");
                    userRepService.createUser(user);
                    JOptionPane.showMessageDialog(null, "GOOD BYE !", "NET SOULS",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });//end of logout action


            main_panel.add(logout);
            main_panel.add(username);
            main_panel.add(password);
            main_panel.add(login);
            main_panel.add(username_field);
            main_panel.add(password_field);
            frame.revalidate();
            frame.repaint();
            frame.setVisible(true);
            frame.add(main_panel);

        }//end of constructor

}//end of class
