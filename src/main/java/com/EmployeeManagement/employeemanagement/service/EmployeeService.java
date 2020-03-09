package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

/*Bu interface üzerinde bu interfacei implemente edecek Class için methodlar oluşturulur.*/

@Service
public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO employee);

    EmployeeDTO getById(Long id);

    Boolean delete(EmployeeEntity employee);

    EmployeeDTO getByName(EmployeeDTO employee);

}
