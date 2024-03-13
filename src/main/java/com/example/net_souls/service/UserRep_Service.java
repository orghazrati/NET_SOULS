package com.example.net_souls.service;

import com.example.net_souls.entities.User;
import com.example.net_souls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserRep_Service
{

    @Autowired
    public UserRepository userDao;

    //FETCHING DATA FROM DB:
    public User findUserById(Long id)
    {
       return userDao.findUserById(id);
    }//END OF METHOD.

    public List<User> findAllUsers()
    {
        return userDao.findAll();
    }//END OF METHOD

    public User findUserByNumber(String number)
    {
            return userDao.findByNumber(number);
    }//END OF METHOD


    public User findUserByStatus(String status)
    {
        return userDao.findByStatus(status);
    }//END OF METHOD.

    public List<User> findAllUsersByStatus(String status)
    {
        return userDao.findAllByStatus(status);
    }//END OF METHOD.

    public User findUserByAccountDateCreated(String date)
    {
        return userDao.findUserByaccountdate(date);
    }//END OF METHOD.


    public User findUserByUsername(String username)
    {
        return userDao.findUserByUsername(username);
    }//end of method.

    public User login(String username,String password)
    {
        return userDao.findUserByUsernameAndPassword(username,password);
    }//end of method.

    //END OF FETCHING DATA.



    //ACTION METHODS FOR DB:
    public void deleteUserById(Long id)
    {
        userDao.deleteById(id);
    }//END OF METHOD.

    public void deleteUserByNumber(String number)
    {
        userDao.deleteUserByNumber(number);
    }//END OF METHOD.

    public void createUser(User user)
    {
        userDao.save(user);
    }//END OF METHOD.

}//end of class
