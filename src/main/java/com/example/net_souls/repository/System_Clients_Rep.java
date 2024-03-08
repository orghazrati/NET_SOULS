package com.example.net_souls.repository;

import com.example.net_souls.entities.System_Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface System_Clients_Rep extends JpaRepository<System_Clients,Long>
{
    System_Clients findByStatus(String status);

    System_Clients findBycurrentlygame(String name);

    System_Clients findByUser_Id(Long id);

}//end of interface
