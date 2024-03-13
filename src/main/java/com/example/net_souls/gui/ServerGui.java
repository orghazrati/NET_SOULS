package com.example.net_souls.gui;

import com.example.net_souls.ApplicationServer;
import com.example.net_souls.entities.PC;
import com.example.net_souls.entities.User;
import com.example.net_souls.service.Pc_RepositoryService;
import com.example.net_souls.service.UserRep_Service;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

@Component
@Data
public class ServerGui
{
    //properties:
    private int price_per_hour;
    private int minimum_price;
    private int maximum_play_time;
    private int minimum_play_time;


    @Autowired
    public ServerGui(UserRep_Service service, Pc_RepositoryService pcRepositoryService)
    {

                //frame config
                JFrame frame = new JFrame("NET SOULS");
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setSize(1920, 1080);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                //welcome label
                JLabel welcome = new JLabel("server is running !");
                Font font = new Font("MV Boli", Font.PLAIN, 55);
                welcome.setFont(font);
                welcome.setSize(500, 200);
                welcome.setLocation(740, 20);
                welcome.setForeground(Color.GREEN);


                //menu config
                JMenuBar menuBar = new JMenuBar();
                menuBar.setSize(150, 200);
                menuBar.setLocation(0, 0);


                //menu items config:
                JMenu accounts = new JMenu("Accounts");
                menuBar.add(accounts);
                Border border = BorderFactory.createLineBorder(Color.black);
                accounts.setBorder(border);
                menuBar.setBackground(Color.white);


                JMenuItem createAccount = new JMenuItem("Create New Account");
                accounts.add(createAccount);

                JMenuItem findAccount = new JMenuItem("Find Account");
                accounts.add(findAccount);

                JMenuItem editAccount = new JMenuItem("Edit Account");
                accounts.add(editAccount);

                JMenuItem deleteAccount = new JMenuItem("Delete Account");
                accounts.add(deleteAccount);

                //PC:
                JMenu pc = new JMenu("PC");
                menuBar.add(pc);
                pc.setBorder(border);

                JMenuItem addPc = new JMenuItem("Add New PC");
                pc.add(addPc);

                JMenuItem offlinePc = new JMenuItem("Offline PCs");
                pc.add(offlinePc);

                JMenuItem onlinePc = new JMenuItem("Online PCs");
                pc.add(onlinePc);

                JMenuItem editPc = new JMenuItem("Edit Pcs");
                pc.add(editPc);

                JMenuItem deletePc = new JMenuItem("Delete Pc");
                pc.add(deletePc);


                //settings
                JMenu settings = new JMenu("Settings");
                menuBar.add(settings);
                settings.setBorder(border);


                JMenuItem change_values = new JMenuItem("Change Values");
                settings.add(change_values);

                JMenuItem server_setting = new JMenuItem("Server Setting");
                settings.add(server_setting);


                //main panel config
                JPanel main_panel = new JPanel();
                main_panel.add(welcome);
                main_panel.add(menuBar);
                main_panel.setVisible(true);
                main_panel.setSize(1920, 1080);
                main_panel.setLayout(null);
                main_panel.setBackground(Color.BLACK);


                //actions:

                //when clicked accounts-->create new account:
                createAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        //username label:
                        JLabel username = new JLabel("enter username: ");
                        username.setLocation(20, 3);
                        username.setSize(170, 110);
                        username.setFont(new Font("MV Boli", Font.PLAIN, 20));
                        username.setForeground(Color.GREEN);

                        //username textfield
                        JTextField usernameField = new JTextField();
                        usernameField.setLocation(190, 35);
                        usernameField.setSize(250, 50);
                        Border border = BorderFactory.createEtchedBorder();
                        usernameField.setBorder(border);
                        usernameField.setLayout(null);
                        usernameField.setBackground(Color.LIGHT_GRAY);
                        usernameField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                        usernameField.setForeground(Color.BLACK);

                        //number label
                        JLabel number = new JLabel("enter number: ");
                        number.setLocation(20, 120);

                        number.setSize(170, 110);
                        number.setFont(new Font("MV Boli", Font.PLAIN, 20));
                        number.setForeground(Color.GREEN);

                        //number textfield
                        JTextField numberField = new JTextField();
                        numberField.setLocation(185, 150);
                        numberField.setSize(250, 50);
                        numberField.setBorder(border);
                        numberField.setLayout(null);
                        numberField.setBackground(Color.LIGHT_GRAY);
                        numberField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                        numberField.setForeground(Color.BLACK);


                        //price_charge label
                        JLabel price = new JLabel("enter account value: ");
                        price.setLocation(20, 235);

                        price.setSize(230, 110);
                        price.setFont(new Font("MV Boli", Font.PLAIN, 20));
                        price.setForeground(Color.GREEN);


                        //price_charge textfield
                        JTextField priceField = new JTextField();
                        priceField.setLocation(230, 265);
                        priceField.setSize(250, 50);
                        priceField.setBorder(border);
                        priceField.setLayout(null);
                        priceField.setBackground(Color.LIGHT_GRAY);
                        priceField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                        priceField.setForeground(Color.BLACK);


                        //password label:
                        JLabel password = new JLabel("enter password: ");
                        password.setLocation(20, 380);

                        password.setSize(230, 110);
                        password.setFont(new Font("MV Boli", Font.PLAIN, 20));
                        password.setForeground(Color.GREEN);


                        //password textfield
                        JTextField passwordField = new JTextField();
                        passwordField.setLocation(200, 410);
                        passwordField.setSize(250, 50);
                        passwordField.setBorder(border);
                        passwordField.setLayout(null);
                        passwordField.setBackground(Color.LIGHT_GRAY);
                        passwordField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                        passwordField.setForeground(Color.BLACK);


                        //button for submit
                        JButton submit = new JButton("CREATE");
                        submit.setSize(150, 35);
                        submit.setLayout(null);
                        submit.setLocation(600, 415);
                        submit.setBackground(Color.MAGENTA);
                        submit.setForeground(Color.YELLOW);
                        submit.setFocusable(false);
                        submit.setBorder(border);
                        submit.setFont(new Font("MV Boli", Font.PLAIN, 25));


                        //action for create account:
                        submit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                int price_charge = Integer.parseInt(priceField.getText());
                                String username = usernameField.getText();
                                String password = passwordField.getText();
                                Date date = new Date();
                                String accountDate = date.toString();
                                String number = numberField.getText();
                                User user = new User(username, number, price_charge, password, accountDate);
                                service.createUser(user);
                            }
                        });//end of submit action

                        main_panel.add(username);
                        main_panel.add(usernameField);
                        main_panel.add(number);
                        main_panel.add(numberField);
                        main_panel.add(price);
                        main_panel.add(priceField);
                        main_panel.add(submit);
                        main_panel.add(password);
                        main_panel.add(passwordField);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of create new account action


                //when clicked on accounts-->find accounts:
                findAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        //username label
                        JLabel username = new JLabel("find by username: ");
                        username.setLocation(20, 120);

                        username.setSize(240, 120);
                        username.setFont(new Font("MV Boli", Font.PLAIN, 20));
                        username.setForeground(Color.GREEN);


                        //username textfield
                        JTextField usernameField = new JTextField();
                        usernameField.setLocation(200, 150);
                        usernameField.setSize(250, 50);
                        Border border = BorderFactory.createEtchedBorder();
                        usernameField.setBorder(border);
                        usernameField.setLayout(null);
                        usernameField.setBackground(Color.LIGHT_GRAY);
                        usernameField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                        usernameField.setForeground(Color.BLACK);


                        //button for submit
                        JButton submit = new JButton("FIND");
                        submit.setSize(150, 35);
                        submit.setLayout(null);
                        submit.setLocation(600, 415);
                        submit.setBackground(Color.MAGENTA);
                        submit.setForeground(Color.YELLOW);
                        submit.setFocusable(false);
                        submit.setBorder(border);
                        submit.setFont(new Font("MV Boli", Font.PLAIN, 25));


                        submit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object[] columns = {"ID", "username", "status", "charge_value", "number", "password"};
                                DefaultTableModel model = new DefaultTableModel(columns, 0);
                                User user = service.findUserByUsername(usernameField.getText());
                                Object[] rowData = {user.getId(), user.getUsername(), user.getStatus(), user.getPrice_charge(), user.getNumber(), user.getPassword()};
                                model.addRow(rowData);
                                main_panel.removeAll();
                                JTable table = new JTable(model);
                                table.setSize(800, 18);
                                table.setLocation(650, 200);
                                JScrollPane scrollPane = new JScrollPane(table);
                                scrollPane.setSize(800, 45);
                                scrollPane.setLocation(600, 200);


                                //force stop action:
                                    JButton force_stop = new JButton("SHUT DOWN !");
                                    force_stop.setLayout(null);
                                    force_stop.setBackground(Color.RED);
                                    force_stop.setForeground(Color.YELLOW);
                                    force_stop.setSize(150, 45);
                                    force_stop.setLocation(600, 350);

                                    force_stop.addActionListener(new ActionListener()
                                    {
                                        @SneakyThrows
                                        @Override
                                        public void actionPerformed(ActionEvent e)
                                        {


                                                //get the mac address
                                                Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
                                                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
                                                String line;
                                                line = in.readLine();
                                                String[] result = line.split(",");
                                                String mac = result[0].replace('"', ' ').trim();


                                                User user = service.findUserByUsername(usernameField.getText());
                                                User userId = service.findUserById(user.getId());
                                                userId.setStatus("offline");
                                                service.createUser(userId);


                                                PC pc = pcRepositoryService.findPcByMac(mac);
                                                pc.setStatus("offline");
                                                pc.setUser(null);
                                                pcRepositoryService.createPc(pc);
                                                ApplicationServer.trigger = 1;

                                        }
                                    });//end of force stop action



                                JLabel charge_label = new JLabel("CHARGE ACCOUNT: ");
                                charge_label.setSize(800, 350);
                                charge_label.setLocation(900, 185);
                                charge_label.setForeground(Color.GREEN);

                                JTextField charge_value = new JTextField();
                                charge_value.setSize(350, 35);
                                charge_value.setLocation(1020, 350);
                                charge_value.setBorder(border);

                                JButton add_charge = new JButton("CHARGE");
                                add_charge.setFocusable(false);
                                add_charge.setSize(200, 25);
                                add_charge.setLocation(1030, 400);

                                //charge account action
                                add_charge.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int value = Integer.parseInt(charge_value.getText());
                                        User user = service.findUserByUsername(usernameField.getText());
                                        int old_value = user.getPrice_charge();
                                        user.setPrice_charge(value + old_value);
                                        service.createUser(user);
                                        JOptionPane.showMessageDialog(null, "ACCOUNT CHARGED SUCCESSFULLY !", "NET SOULS",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                });//end of charge account event.


                                main_panel.add(add_charge);
                                main_panel.add(charge_value);
                                main_panel.add(charge_label);
                                main_panel.add(force_stop);
                                main_panel.add(scrollPane);
                                menuBar.setLocation(850, 0);
                                menuBar.setSize(150, 40);
                                main_panel.add(menuBar);
                                frame.add(main_panel);
                                frame.revalidate();
                                frame.repaint();
                            }
                        });//end of find action event


                        main_panel.add(username);
                        main_panel.add(usernameField);
                        main_panel.add(submit);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//***********************end of find account action***************************


                //**************************edit account action************************
                editAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //edit account:
                        main_panel.removeAll();
                        JLabel username = new JLabel("enter username to find:");
                        username.setSize(320, 20);
                        username.setLocation(20, 25);
                        username.setForeground(Color.GREEN);
                        username.setFont(new Font("MV Boli", Font.PLAIN, 22));
                        username.setLayout(null);


                        //field for username:
                        JTextField usernameField = new JTextField();
                        usernameField.setSize(350, 40);
                        usernameField.setLocation(310, 30);
                        usernameField.setLayout(null);
                        usernameField.setFont(new Font("Arial", Font.BOLD, 25));

                        //button for submit:
                        JButton submit = new JButton("FIND");
                        submit.setSize(100, 30);
                        submit.setLocation(30, 90);
                        submit.setLayout(null);
                        submit.setBackground(Color.LIGHT_GRAY);
                        submit.setFocusable(false);
                        submit.setForeground(Color.MAGENTA);

                        //for find when clicked:
                        submit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                main_panel.removeAll();
                                User user = service.findUserByUsername(usernameField.getText());
                                if (user != null) {
                                    JLabel new_username = new JLabel("enter new username:");
                                    new_username.setSize(270, 25);
                                    new_username.setLocation(30, 30);
                                    new_username.setForeground(Color.GREEN);
                                    new_username.setFont(new Font("MV Boli", Font.PLAIN, 25));
                                    new_username.setLayout(null);


                                    JTextField new_usernameField = new JTextField();
                                    new_usernameField.setSize(300, 40);
                                    new_usernameField.setLocation(320, 30);
                                    new_usernameField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                                    new_usernameField.setLayout(null);


                                    JLabel new_number = new JLabel("enter new number:");
                                    new_number.setSize(270, 25);
                                    new_number.setLocation(30, 150);
                                    new_number.setForeground(Color.GREEN);
                                    new_number.setFont(new Font("MV Boli", Font.PLAIN, 25));
                                    new_number.setLayout(null);


                                    JTextField new_numberField = new JTextField();
                                    new_numberField.setSize(300, 40);
                                    new_numberField.setLocation(320, 150);
                                    new_numberField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                                    new_numberField.setLayout(null);


                                    JLabel new_password = new JLabel("enter new password:");
                                    new_password.setSize(270, 25);
                                    new_password.setLocation(30, 260);
                                    new_password.setForeground(Color.GREEN);
                                    new_password.setFont(new Font("MV Boli", Font.PLAIN, 25));
                                    new_password.setLayout(null);


                                    JTextField new_passwordField = new JTextField();
                                    new_passwordField.setSize(300, 40);
                                    new_passwordField.setLocation(320, 250);
                                    new_passwordField.setFont(new Font("MV Boli", Font.PLAIN, 25));
                                    new_passwordField.setLayout(null);


                                    JButton update = new JButton("UPDATE !");
                                    update.setSize(140, 60);
                                    update.setLocation(20, 350);
                                    update.setForeground(Color.BLUE);
                                    update.setBackground(Color.GRAY);
                                    update.setLayout(null);


                                    //when submitted:
                                    update.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            User user = service.findUserByUsername(usernameField.getText());
                                            user.setUsername(new_usernameField.getText());
                                            user.setNumber(new_numberField.getText());
                                            user.setPassword(new_passwordField.getText());
                                            service.createUser(user);
                                            JOptionPane.showMessageDialog(null, "ACCOUNT SUCCESSFULLY UPDATED !", "NET SOULS",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    });//end of update event


                                    main_panel.add(new_passwordField);
                                    main_panel.add(update);
                                    main_panel.add(new_password);
                                    main_panel.add(new_numberField);
                                    main_panel.add(new_number);
                                    main_panel.add(new_usernameField);
                                    main_panel.add(new_username);
                                    menuBar.setLocation(850, 0);
                                    menuBar.setSize(150, 40);
                                    main_panel.add(menuBar);
                                    frame.add(main_panel);
                                    frame.revalidate();
                                    frame.repaint();
                                }
                            }

                        });//end of edit account event


                        main_panel.add(submit);
                        main_panel.add(usernameField);
                        main_panel.add(username);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of edit account action

//***************************************end of edit account********************************************


//****************************************delete account action********************************************


                deleteAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        JLabel username = new JLabel("enter username to find:");
                        username.setSize(400, 25);
                        username.setLocation(20, 15);
                        username.setForeground(Color.GREEN);
                        username.setFont(new Font("MV Boli", Font.PLAIN, 28));


                        JTextField usernameField = new JTextField();
                        usernameField.setSize(250, 40);
                        usernameField.setLocation(400, 18);
                        usernameField.setFont(new Font("Comic Sans", Font.BOLD, 25));


                        JButton delete = new JButton("DELETE !");
                        delete.setSize(150, 50);
                        delete.setLocation(30, 75);
                        delete.setFocusable(false);
                        delete.setBackground(Color.red);
                        delete.setFont(new Font("Arial", Font.BOLD, 20));
                        delete.setForeground(Color.YELLOW);

                        //when submit button:
                        delete.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                User user = service.findUserByUsername(usernameField.getText());
                                service.deleteUserById(user.getId());
                                JOptionPane.showMessageDialog(null, "ACCOUNT SUCCESSFULLY DELETED !", "NET SOULS",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        });//end of delete account event


                        main_panel.add(delete);
                        main_panel.add(usernameField);
                        main_panel.add(username);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of delete account action


//*****************************************end of delete account action*****************************************


                //-------------------->>>>>>>end of account menu actions<<<<<<<<--------------------------------


                //--------------------->>>>>>>>PC menu actions:

                addPc.addActionListener(new ActionListener() //add new pc action:*******************************
                {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();


                        JLabel mac = new JLabel("enter MAC address:");
                        mac.setSize(280, 25);
                        mac.setLocation(30, 25);
                        mac.setForeground(Color.GREEN);
                        mac.setFont(new Font("MV Boli", Font.PLAIN, 25));


                        JTextField macField = new JTextField();
                        macField.setSize(300, 40);
                        macField.setLocation(290, 25);
                        macField.setFont(new Font("Arial", Font.BOLD, 23));


                        JLabel level = new JLabel("set level:");
                        level.setSize(150, 25);
                        level.setLocation(45, 80);
                        level.setForeground(Color.GREEN);
                        level.setFont(new Font("MV Boli", Font.PLAIN, 25));


                        JTextField levelField = new JTextField();
                        levelField.setSize(300, 40);
                        levelField.setLocation(190, 85);
                        levelField.setFont(new Font("Arial", Font.BOLD, 23));


                        JButton add = new JButton("ADD NEW PC !");
                        add.setSize(250, 60);
                        add.setLocation(30, 160);
                        add.setBackground(Color.LIGHT_GRAY);
                        add.setForeground(Color.MAGENTA);


                        //when clicked the button:

                        add.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PC pc = new PC(macField.getText(), levelField.getText());
                                pcRepositoryService.createPc(pc);
                                JOptionPane.showMessageDialog(null, "PC ADDED SUCCESSFULLY !", "NET SOULS",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        });//end of add new pc event


                        main_panel.add(add);
                        main_panel.add(levelField);
                        main_panel.add(macField);
                        main_panel.add(level);
                        main_panel.add(mac);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of pc actions


                //see offline PCs:
                offlinePc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        Object[] columns = {"ID", "mac", "user_id", "level", "status"};
                        DefaultTableModel model = new DefaultTableModel(columns, 0);
                        List<PC> pcs = pcRepositoryService.findAllPcs();
                        for (PC pc1 : pcs) {
                            Object[] rowData = {pc1.getId(), pc1.getMac(), pc1.getUser(), pc1.getLevel(), pc1.getStatus()};
                            model.addRow(rowData);
                        }
                        main_panel.removeAll();
                        JTable table = new JTable(model);
                        table.setSize(800, 500);
                        table.setLocation(650, 200);
                        JScrollPane scrollPane = new JScrollPane(table);
                        scrollPane.setSize(800, 650);
                        scrollPane.setLocation(600, 200);


                        main_panel.add(scrollPane);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of offline PCs


                // online PCs:
                onlinePc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        Object[] columns = {"ID", "mac", "user_id", "level", "status"};
                        DefaultTableModel model = new DefaultTableModel(columns, 0);
                        List<PC> pcs = pcRepositoryService.findAllOnlinePCs("online");
                        for (PC pc1 : pcs) {
                            Object[] rowData = {pc1.getId(), pc1.getMac(), pc1.getUser(), pc1.getLevel(), pc1.getStatus()};
                            model.addRow(rowData);
                        }
                        main_panel.removeAll();
                        JTable table = new JTable(model);
                        table.setSize(800, 500);
                        table.setLocation(650, 200);
                        JScrollPane scrollPane = new JScrollPane(table);
                        scrollPane.setSize(800, 650);
                        scrollPane.setLocation(600, 200);


                        main_panel.add(scrollPane);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of online PCs


                //edit PC action:
                editPc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        JLabel pc_id = new JLabel("enter id:");
                        pc_id.setSize(120, 25);
                        pc_id.setLocation(25, 20);
                        pc_id.setForeground(Color.GREEN);
                        pc_id.setFont(new Font("MV Boli", Font.PLAIN, 15));

                        JTextField id_field = new JTextField();
                        id_field.setSize(60, 30);
                        id_field.setLocation(140, 20);
                        id_field.setFont(new Font("Arial", Font.BOLD, 25));

                        JButton find = new JButton("FIND");
                        find.setSize(75, 35);
                        find.setLocation(50, 55);
                        find.setBackground(Color.WHITE);
                        find.setForeground(Color.BLACK);
                        find.setFont(new Font("Arial", Font.PLAIN, 18));

                        //when clicked on find button:

                        find.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                main_panel.removeAll();

                                JLabel new_mac = new JLabel("enter new mac address:");
                                new_mac.setSize(190, 28);
                                new_mac.setLocation(15, 20);
                                new_mac.setForeground(Color.GREEN);
                                new_mac.setFont(new Font("Arial", Font.BOLD, 17));

                                JTextField mac_field = new JTextField();
                                mac_field.setSize(250, 35);
                                mac_field.setLocation(220, 19);
                                mac_field.setFont(new Font("Arial", Font.BOLD, 20));

                                JLabel new_level = new JLabel("enter new level:");
                                new_level.setSize(190, 25);
                                new_level.setLocation(15, 70);
                                new_level.setForeground(Color.GREEN);
                                new_level.setFont(new Font("Arial", Font.BOLD, 17));

                                JTextField level_field = new JTextField();
                                level_field.setSize(250, 35);
                                level_field.setLocation(180, 75);
                                level_field.setFont(new Font("Arial", Font.BOLD, 20));

                                JButton update = new JButton("UPDATE");
                                update.setSize(110, 35);
                                update.setBackground(Color.darkGray);
                                update.setForeground(Color.MAGENTA);
                                update.setLocation(75, 135);
                                update.setFont(new Font("MV Boli", Font.PLAIN, 18));

                                update.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        PC pc = pcRepositoryService.FindPcById(Long.valueOf(id_field.getText()));
                                        pc.setMac(mac_field.getText());
                                        pc.setLevel(level_field.getText());
                                        pcRepositoryService.createPc(pc);
                                        JOptionPane.showMessageDialog(null, "PC UPDATED SUCCESSFULLY !", "NET SOULS",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                });

                                main_panel.add(update);
                                main_panel.add(level_field);
                                main_panel.add(new_level);
                                main_panel.add(mac_field);
                                main_panel.add(new_mac);
                                menuBar.setLocation(850, 0);
                                menuBar.setSize(150, 40);
                                main_panel.add(menuBar);
                                frame.add(main_panel);
                                frame.revalidate();
                                frame.repaint();
                            }
                        });//end of find button


                        main_panel.add(find);
                        main_panel.add(id_field);
                        main_panel.add(pc_id);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of edit pc action.


                //delete Pc action:
                deletePc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        JLabel id = new JLabel("enter id to find:");
                        id.setSize(190, 25);
                        id.setLocation(15, 20);
                        id.setForeground(Color.GREEN);


                        JTextField id_field = new JTextField();
                        id_field.setSize(110, 25);
                        id_field.setLocation(120, 19);
                        id_field.setFont(new Font("Arial", Font.BOLD, 20));

                        JButton delete = new JButton("DELETE !");
                        delete.setSize(190, 35);
                        delete.setLocation(40, 65);
                        delete.setBackground(Color.red);
                        delete.setForeground(Color.YELLOW);
                        delete.setFont(new Font("MV Boli", Font.PLAIN, 20));

                        delete.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                pcRepositoryService.deletePcById(Long.valueOf(id_field.getText()));
                                JOptionPane.showMessageDialog(null, "PC DELETED SUCCESSFULLY !", "NET SOULS",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        });


                        main_panel.add(delete);
                        main_panel.add(id_field);
                        main_panel.add(id);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of delete action


                //**********************************end of pc menu actions***************************************

                //---------------------------------->>>>>>settings menu actions:

                change_values.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        JLabel new_value = new JLabel("enter new price per hour:");
                        new_value.setSize(270, 30);
                        new_value.setLocation(20, 22);
                        new_value.setForeground(Color.YELLOW);
                        new_value.setFont(new Font("MV Boli", Font.PLAIN, 22));

                        JTextField price_field = new JTextField();
                        price_field.setSize(200, 40);
                        price_field.setLocation(300, 20);
                        price_field.setFont(new Font("Arial", Font.BOLD, 20));

                        JLabel minimum_price = new JLabel("enter new minimum price:");
                        minimum_price.setSize(310, 25);
                        minimum_price.setLocation(20, 55);
                        minimum_price.setForeground(Color.YELLOW);
                        minimum_price.setFont(new Font("MV Boli", Font.PLAIN, 22));

                        JTextField minimum_field = new JTextField();
                        minimum_field.setSize(200, 40);
                        minimum_field.setLocation(300, 80);
                        minimum_field.setFont(new Font("Arial", Font.BOLD, 20));

                        JButton submit = new JButton("SUBMIT");
                        submit.setSize(80, 45);
                        submit.setLocation(50, 90);
                        submit.setBackground(Color.GREEN);
                        submit.setForeground(Color.MAGENTA);

                        submit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                setPrice_per_hour(Integer.parseInt(price_field.getText()));
                                setMinimum_price(Integer.parseInt(minimum_field.getText()));
                                JOptionPane.showMessageDialog(null, "VALUES SUCCESSFULLY CHANGED !", "NET SOULS",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        });

                        main_panel.add(submit);
                        main_panel.add(minimum_field);
                        main_panel.add(minimum_price);
                        main_panel.add(price_field);
                        main_panel.add(new_value);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of change values actions


                //server settings:
                server_setting.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_panel.removeAll();

                        JLabel minimum_tp = new JLabel("enter minimum time play:");
                        minimum_tp.setSize(270, 25);
                        minimum_tp.setForeground(Color.GREEN);
                        minimum_tp.setLocation(20, 20);

                        JTextField minimum_tp_field = new JTextField();
                        minimum_tp_field.setSize(120, 30);
                        minimum_tp_field.setLocation(280, 18);
                        minimum_tp_field.setFont(new Font("Arial", Font.BOLD, 18));

                        JLabel maximum_tp = new JLabel("enter maximum time play:");
                        maximum_tp.setSize(270, 25);
                        maximum_tp.setLocation(20, 50);
                        maximum_tp.setForeground(Color.GREEN);

                        JTextField maximum_tp_field = new JTextField();
                        maximum_tp_field.setSize(120, 30);
                        maximum_tp_field.setLocation(280, 55);
                        maximum_tp_field.setFont(new Font("Arial", Font.BOLD, 18));

                        JButton submit = new JButton("SUBMIT");
                        submit.setSize(120, 35);
                        submit.setLocation(50, 150);

                        submit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                setMinimum_play_time(Integer.parseInt(minimum_tp_field.getText()));
                                setMaximum_play_time(Integer.parseInt(maximum_tp_field.getText()));
                                JOptionPane.showMessageDialog(null, "VALUES SUCCESSFULLY CHANGED !", "NET SOULS",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        });//end of submit


                        main_panel.add(submit);
                        main_panel.add(maximum_tp_field);
                        main_panel.add(maximum_tp);
                        main_panel.add(minimum_tp_field);
                        main_panel.add(minimum_tp);
                        menuBar.setLocation(850, 0);
                        menuBar.setSize(150, 40);
                        main_panel.add(menuBar);
                        frame.add(main_panel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });//end of server settings action


                frame.add(main_panel);
                frame.setVisible(true);

//----------------------------------------------->>>>>>>>>>>> END OF GUI PART<<<<<<<<<<<<<<<<<<-------------------------


    }//end of constructor


    public void setStatusOnLogin(UserRep_Service userRepService,Pc_RepositoryService pcRepositoryService,String mac)
    {
        PC pc = pcRepositoryService.findPcByMac(mac);
        pc.setStatus("online");

        pcRepositoryService.createPc(pc);
    }//end of method.

}//end of class
