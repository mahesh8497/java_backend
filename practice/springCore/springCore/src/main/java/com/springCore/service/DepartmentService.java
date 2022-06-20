package com.springCore.service;

import com.springCore.entity.Department;
import com.springCore.excption.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment (Department department);

   public List<Department> fetchDepartmentlist();

    public Department fetchDepartmenId(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

   public  Department updateDepartment(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);

    Object fetchDepartmentById(long l);
}
