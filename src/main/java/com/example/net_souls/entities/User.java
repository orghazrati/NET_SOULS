package com.example.net_souls.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 30)
    private String username;

    @Column(nullable = false,length = 40)
    private String password;

    @Column
    private int price_charge;

    @Column
    private String account_time;

    @Column(nullable = false)
    private String number;

    @Column
    private String status;

    @Column
    private String currently_system;

    @Column(nullable = false)
    public String accountdate;

    public User(String username, String password,String number,int price_charge)
    {
        Date date = new Date();
        this.accountdate = date.toString();
        this.username = username;
        this.password = password;
        this.status = "offline";
        this.price_charge = price_charge;
        this.number = number;
    }

    public User(String username,String number,int price_charge,String password,String accountdate)
    {
        this.username = username;
        this.number = number;
        this.price_charge = price_charge;
        this.password = password;
        this.status = "offline";
        this.accountdate = accountdate;
    }

}//end of class
