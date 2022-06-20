package com.springCore.controller;

import com.springCore.entity.Department;
import com.springCore.excption.DepartmentNotFoundException;
import com.springCore.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department=Department.builder()
                .departmentAddress("Pune")
                .departmentCode("CSE-01")
                .dapartmentName("CSE")
                .departmentId(1L)
                .build();

    }

    @Test
    void saveDepartment()
         throws Exception {
            Department inputDepartment = Department.builder()
                    .departmentAddress("Ahmedabad")
                    .departmentCode("IT-06")
                    .dapartmentName("IT")
                    .build();

            Mockito.when(departmentService.saveDepartment(inputDepartment))
                    .thenReturn(department);

   mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"departmentName\":\"IT\",\n" +
                                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
                                "\t\"departmentCode\":\"IT-06\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fetchDepartmentById() throws DepartmentNotFoundException {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/department/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").
                        value(department.getDapartmentName()));
    }
}














