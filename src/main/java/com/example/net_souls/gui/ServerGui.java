package com.example.net_souls.gui;

import com.example.net_souls.entities.User;
import com.example.net_souls.service.UserRep_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

@Component
public class ServerGui
{

    @Autowired
    public ServerGui(UserRep_Service service)
    {
        //frame config
        JFrame frame = new JFrame("NET SOULS");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //welcome label
        JLabel welcome = new JLabel("server is running !");
        Font font = new Font("MV Boli",Font.PLAIN,55);
        welcome.setFont(font);
        welcome.setSize(500,200);
        welcome.setLocation(740,20);
        welcome.setForeground(Color.GREEN);


        //menu config
        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(150,200);
        menuBar.setLocation(0,0);


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
        main_panel.setSize(1920,1080);
        main_panel.setLayout(null);
        main_panel.setBackground(Color.BLACK);


        //actions:

        //when clicked accounts-->create new account:
        createAccount.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main_panel.removeAll();

                //username label:
                JLabel username = new JLabel("enter username: ");
                username.setLocation(20,3);
                username.setSize(170,110);
                username.setFont(new Font("MV Boli",Font.PLAIN,20));
                username.setForeground(Color.GREEN);

                //username textfield
                JTextField usernameField = new JTextField();
                usernameField.setLocation(190,35);
                usernameField.setSize(250,50);
                Border border = BorderFactory.createEtchedBorder();
                usernameField.setBorder(border);
                usernameField.setLayout(null);
                usernameField.setBackground(Color.LIGHT_GRAY);
                usernameField.setFont(new Font("MV Boli",Font.PLAIN,25));
                usernameField.setForeground(Color.BLACK);

                //number label
                JLabel number = new JLabel("enter number: ");
                number.setLocation(20,120);

                number.setSize(170,110);
                number.setFont(new Font("MV Boli",Font.PLAIN,20));
                number.setForeground(Color.GREEN);

                //number textfield
                JTextField numberField = new JTextField();
                numberField.setLocation(185,150);
                numberField.setSize(250,50);
                numberField.setBorder(border);
                numberField.setLayout(null);
                numberField.setBackground(Color.LIGHT_GRAY);
                numberField.setFont(new Font("MV Boli",Font.PLAIN,25));
                numberField.setForeground(Color.BLACK);


                //price_charge label
                JLabel price = new JLabel("enter account value: ");
                price.setLocation(20,235);

                price.setSize(230,110);
                price.setFont(new Font("MV Boli",Font.PLAIN,20));
                price.setForeground(Color.GREEN);



                //price_charge textfield
                JTextField priceField = new JTextField();
                priceField.setLocation(230,265);
                priceField.setSize(250,50);
                priceField.setBorder(border);
                priceField.setLayout(null);
                priceField.setBackground(Color.LIGHT_GRAY);
                priceField.setFont(new Font("MV Boli",Font.PLAIN,25));
                priceField.setForeground(Color.BLACK);


                //password label:
                JLabel password = new JLabel("enter password: ");
                password.setLocation(20,380);

                password.setSize(230,110);
                password.setFont(new Font("MV Boli",Font.PLAIN,20));
                password.setForeground(Color.GREEN);


                //password textfield
                JTextField passwordField = new JTextField();
                passwordField.setLocation(200,410);
                passwordField.setSize(250,50);
                passwordField.setBorder(border);
                passwordField.setLayout(null);
                passwordField.setBackground(Color.LIGHT_GRAY);
                passwordField.setFont(new Font("MV Boli",Font.PLAIN,25));
                passwordField.setForeground(Color.BLACK);


                //button for submit
                JButton submit = new JButton("CREATE");
                submit.setSize(150,35);
                submit.setLayout(null);
                submit.setLocation(600,415);
                submit.setBackground(Color.MAGENTA);
                submit.setForeground(Color.YELLOW);
                submit.setFocusable(false);
                submit.setBorder(border);
                submit.setFont(new Font("MV Boli",Font.PLAIN,25));



                //action for create account and back to the welcome page:
                submit.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                        int price_charge = Integer.parseInt(priceField.getText());
                        String username = usernameField.getText();
                        String password = passwordField.getText();
                        Date date = new Date();
                        String accountDate = date.toString();
                        String number = numberField.getText();
                        User user = new User(username,number,price_charge,password,accountDate);
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
                menuBar.setLocation(850,0);
                menuBar.setSize(150,40);
                main_panel.add(menuBar);
                frame.revalidate();
                frame.repaint();
            }
        });//end of create new account action


        //when clicked on accounts-->find accounts:
        findAccount.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main_panel.removeAll();
                JLabel number = new JLabel("find by number: ");
                number.setLocation(20,3);
                number.setSize(170,110);
                number.setFont(new Font("MV Boli",Font.PLAIN,20));
                number.setForeground(Color.GREEN);


                //number textfield
                JTextField numberField = new JTextField();
                numberField.setLocation(190,35);
                numberField.setSize(250,50);
                numberField.setBorder(border);
                numberField.setLayout(null);
                numberField.setBackground(Color.LIGHT_GRAY);
                numberField.setFont(new Font("MV Boli",Font.PLAIN,25));
                numberField.setForeground(Color.BLACK);


                //username label
                JLabel username = new JLabel("find by username: ");
                username.setLocation(20,120);

                username.setSize(240,120);
                username.setFont(new Font("MV Boli",Font.PLAIN,20));
                username.setForeground(Color.GREEN);


                //username textfield
                JTextField usernameField = new JTextField();
                usernameField.setLocation(200,150);
                usernameField.setSize(250,50);
                Border border = BorderFactory.createEtchedBorder();
                usernameField.setBorder(border);
                usernameField.setLayout(null);
                usernameField.setBackground(Color.LIGHT_GRAY);
                usernameField.setFont(new Font("MV Boli",Font.PLAIN,25));
                usernameField.setForeground(Color.BLACK);



                //button for submit
                JButton submit = new JButton("FIND");
                submit.setSize(150,35);
                submit.setLayout(null);
                submit.setLocation(600,415);
                submit.setBackground(Color.MAGENTA);
                submit.setForeground(Color.YELLOW);
                submit.setFocusable(false);
                submit.setBorder(border);
                submit.setFont(new Font("MV Boli",Font.PLAIN,25));


                submit.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        Object[] columns = {"ID", "username", "status", "charge_value","number", "password"};
                        DefaultTableModel model = new DefaultTableModel(columns, 0);
                        User user = service.findUserByUsername(usernameField.getText());
                        Object[] rowData = {user.getId(), user.getUsername(), user.getStatus(),user.getPrice_charge(), user.getNumber(), user.getPassword()};
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
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                User user = service.findUserByUsername(usernameField.getText());
                                User userId = service.findUserById(user.getId());
                                userId.setStatus("offline");
                                service.createUser(userId);
                            }
                        });//end of force stop action


                        JLabel charge_label = new JLabel("CHARGE ACCOUNT: ");
                        charge_label.setSize(800,350);
                        charge_label.setLocation(900,185);
                        charge_label.setForeground(Color.GREEN);

                        JTextField charge_value = new JTextField();
                        charge_value.setSize(350,35);
                        charge_value.setLocation(1020,350);
                        charge_value.setBorder(border);

                        JButton add_charge = new JButton("CHARGE");
                        add_charge.setFocusable(false);
                        add_charge.setSize(200,25);
                        add_charge.setLocation(1030,400);

                        //charge account action
                        add_charge.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                int value = Integer.parseInt(charge_value.getText());
                                User user = service.findUserByUsername(usernameField.getText());
                                int old_value = user.getPrice_charge();
                                user.setPrice_charge(value+old_value);
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





                main_panel.add(number);
                main_panel.add(numberField);
                main_panel.add(username);
                main_panel.add(usernameField);
                main_panel.add(submit);
                menuBar.setLocation(850,0);
                menuBar.setSize(150,40);
                main_panel.add(menuBar);
                frame.revalidate();
                frame.repaint();
            }
        });//end of find account action


        frame.add(main_panel);
        frame.setVisible(true);
    }//end of constructor


}//end of class
