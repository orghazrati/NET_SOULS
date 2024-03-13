package com.example.net_souls.repository;

import com.example.net_souls.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
   User findByNumber(String number);

   User findUserById(Long id);


   User findByStatus(String status);


   void deleteUserByNumber(String number);

   User findUserByaccountdate(String date);

   List<User> findAllByStatus(String status);

   User findUserByUsername(String username);

   User findUserByUsernameAndPassword(String username,String password);
}//end of interface
