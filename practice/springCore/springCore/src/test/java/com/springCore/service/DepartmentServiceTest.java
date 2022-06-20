package com.springCore.service;

import com.springCore.entity.Department;
import com.springCore.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @MockBean
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentService departmentService;
    @BeforeEach//each and every test case added to class
    void setUp() {
        Department department=Department.builder().dapartmentName("IT")
                .departmentAddress("Pune")
                .departmentCode("IT-08")
                .departmentId(1l)
                .build();
        Mockito.when(departmentRepository.findBydapartmentName("IT")).thenReturn(department);
    }
    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDapartmentName());
    }
}