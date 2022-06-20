package com.mah.casestudy.Service;

import com.mah.casestudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransferService {

    @Autowired
    UserRepository userRepository;
    public int transfer(String source,String dest,int amount)
    {
        String timestamp=userRepository.getDate();
        return userRepository.transfer(source,dest,timestamp,amount);
    }
}