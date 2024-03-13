package com.example.net_souls.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PC")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PC
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String mac;

    @Column
    public String level;

    @OneToOne
    private User user;

    @Column
    private String status;

    public PC(String mac_address,String level)
    {
        this.mac = mac_address;
        this.setStatus("offline");
        this.level = level;
    }//end of constructor

}//end of class
