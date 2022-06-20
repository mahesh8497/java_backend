package com.springCore.controller;


import com.springCore.entity.Department;
import com.springCore.excption.DepartmentNotFoundException;
import com.springCore.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
        @Autowired
        private DepartmentService departmentService;


        @PostMapping("/department")
        public Department saveDepartment
        (@Valid @RequestBody Department
        department)
        {
            return departmentService.saveDepartment(department);
        }
        @GetMapping("/department")
        public List<Department> fetchDepartmentlist
        ()
        {
            return departmentService.fetchDepartmentlist();

        }

        @GetMapping("/department/{id}")
        public Department fetchDepartmentById
        (@PathVariable("id") Long
        departmentId)
            throws DepartmentNotFoundException {
            return departmentService.fetchDepartmenId(departmentId);
        }

        @DeleteMapping("/department/{id}")
        public String deleteDepartmentById
        (@PathVariable("id") Long
        departmentId)
        {
            departmentService.deleteDepartmentById(departmentId);
            return "department deleted successfully";
        }
        @PutMapping("/department/{id}")
        public Department updateDepartment
        (@PathVariable("id") Long
        departmentId,
                @RequestBody Department
        department)
        {
            return departmentService.updateDepartment(departmentId, department);

        }
        @GetMapping("/department/name/{name}")
        public Department feDepartmentByName
        (@PathVariable("name") String
        departmentName)
        {
            return departmentService.fetchDepartmentByName(departmentName);
        }
    }

