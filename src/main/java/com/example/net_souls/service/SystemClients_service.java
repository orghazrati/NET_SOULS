package com.example.net_souls.service;

import com.example.net_souls.entities.System_Clients;
import com.example.net_souls.repository.System_Clients_Rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemClients_service
{
    @Autowired
    private System_Clients_Rep systemClientsDao;

    public Optional<System_Clients> findClientById(Long id)
    {
        return systemClientsDao.findById(id);
    }//END OF METHOD.

    public List<System_Clients> findAllClients()
    {
        return systemClientsDao.findAll();
    }//END OF METHOD.

    public System_Clients findClientByStatus(String status)
    {
            return systemClientsDao.findByStatus(status);
    }//END OF METHOD.

    public void createClient(System_Clients systemClients)
    {
        systemClientsDao.save(systemClients);
    }//END OF METHOD.

}//END OF CLASS
