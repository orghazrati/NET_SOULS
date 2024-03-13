package com.example.net_souls.repository;

import com.example.net_souls.entities.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcRepository extends JpaRepository<PC,Long>
{
    PC findByMac(String mac);
    void deleteByMac(String mac);
    PC findByLevel(String level);
    List<PC> findAllByStatusEquals(String status);
    PC findPcById(Long id);
}//end of repository
