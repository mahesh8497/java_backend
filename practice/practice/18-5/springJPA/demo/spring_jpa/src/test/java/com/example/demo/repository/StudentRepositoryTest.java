package com.example.demo.repository;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentRepositoryTest {
        @Autowired
private StudentRepository studentRepository;

      @Test
        public void saveStudent(){
                Student student=Student.builder().emailId("dfghj@gmail.com")
                        .firstName("Mahesh")
                        .lastName("Takale")
                       // .guardianName("sachin")
                       // .guardianEmail("poiu@gmail.com")
                        //.guardianMobile("1234567890")
                        .build();
                studentRepository.save(student);

}
    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .Email("guardianObject@gmail.com").
                Mobile("1234567890")
                .build();


          Student student=Student.builder().firstName("Shivam")
                  .emailId("Shivam@gmail.com").
                  lastName("Raje")
                  .guardian(guardian)
                  .build();
          studentRepository.save(student);


    }
    @Test
        public void printAllStudent(){
            List<Student>studentList=studentRepository.findAll();
            System.out.println("StudentList "+ studentList);
        }
    @Test
        public void printStudentByFirsyName(){
          List<Student>students=
          studentRepository.findByFirstName("Shivam");
            System.out.println("student= "+students);
        }


}