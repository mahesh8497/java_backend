package com.mah.casestudy.Service;

import com.mah.casestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;
    public int addAdmin(String name,String username,String accno,
                        int mobno,String address, int ifsc, int balance)
    {
        return userRepository.addAdmin(name,username,accno,mobno,address,ifsc,balance);
    }
    public int addAdminLogin(String username,String password,String role)
    {
        return userRepository.addAdminLogin(username,password,role);
    }
}
