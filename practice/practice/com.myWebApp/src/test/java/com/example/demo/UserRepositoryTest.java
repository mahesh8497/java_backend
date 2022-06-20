package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
 void testAddNew(){
        var user=new User();
        user.setId(0);
        user.setEmail("sam@gmail.com");
        user.setPassword("sam@123");
        user.setFirstName("sam");
        user.setLastName("Takale");
      User saveUser= repo.save(user);
      Assertions.assertThat(saveUser).isNotNull();
      Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user:users
             ) {
            System.out.println(user);
        }
    }
    @Test
    public void testUpdate(){
        Integer userId=1;
        Optional<User> optionalUser = repo.findById(userId);
        User user=optionalUser.get();
        user.setPassword("hello211");
        repo.save(user);

        User updatedUser=repo.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello211");
    }
    @Test
    public void testGet(){
        Integer userId=2;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId=2;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
