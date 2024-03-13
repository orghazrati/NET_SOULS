package com.example.net_souls.service;

import com.example.net_souls.entities.PC;
import com.example.net_souls.repository.PcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pc_RepositoryService
{
    @Autowired
    private PcRepository repository;

    public void createPc(PC pc)
    {
        repository.save(pc);
    }//end of method.


    public PC findPcByMac(String mac_address)
    {
       return repository.findByMac(mac_address);
    }//end of method.

    public Optional<PC> findPcById(Long id)
    {
      return repository.findById(id);
    }//end of method.

    public void deletePcByMac(String mac_address)
    {
        repository.deleteByMac(mac_address);
    }//end of method.

    public void deletePcById(Long id)
    {
        repository.deleteById(id);
    }//end of method.

    public PC findPcByLevel(String level)
    {
        return repository.findByLevel(level);
    }//end of method

    public List<PC> findAllPcs()
    {
       return repository.findAll();
    }//end of method.

    public List<PC> findAllOnlinePCs(String status)
    {
        return repository.findAllByStatusEquals(status);
    }//end of method.


    public PC FindPcById(Long id)
    {
        return repository.findPcById(id);
    }//end of method.

    public boolean isPresent(Long id)
    {
        return repository.existsById(id);
    }

}//end of class
