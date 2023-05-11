package com.User.service.repository;

import com.User.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repository extends JpaRepository<User,String> {
}
