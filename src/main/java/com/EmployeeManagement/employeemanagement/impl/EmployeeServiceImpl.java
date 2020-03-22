package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.repository.EmployeeRepository;
import com.EmployeeManagement.employeemanagement.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*Interface üzerinden implemente edilen methodlar, Repository'de oluşturulan
 methodları döndürecek şekilde çağrılır.*/

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final ModelMapper modelMapper;

    //final değişken yalnızca constructor içerisinde değiştirilebilir.
    public EmployeeServiceImpl(EmployeeRepository employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }
    // mapper genel mantığı apı altında tüm entity dönüşünün önüne geçmesi.
    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        // employee objesi Entity altına map edildi. employeeDB değişkeninde tutuldu.
        EmployeeEntity employeeDB = modelMapper.map(employee, EmployeeEntity.class);
        employeeDB = employeeRepo.save(employeeDB); // save işlemi repo altında burada gerçekleşti.
        return modelMapper.map(employeeDB, EmployeeDTO.class); // DTO altına map edilmiş hali geri döndürüldü.
    }

    @Override
    public EmployeeDTO getById(Long id) {
        EmployeeEntity employeeDB = employeeRepo.getOne(id);
        return modelMapper.map(employeeDB, EmployeeDTO.class);
    }

    @Override
    public Boolean delete(EmployeeEntity employee) {
        employeeRepo.delete(employee);
        return true;
    }

    public Boolean delete(Long id) {
        employeeRepo.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDTO getByName(EmployeeDTO employee) {
        EmployeeEntity emloyeeDB = modelMapper.map(employee, EmployeeEntity.class);
        emloyeeDB = employeeRepo.getByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
        return modelMapper.map(emloyeeDB, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO employee) {
        EmployeeEntity employeeFromDB = employeeRepo.getOne(id);
        if (employeeFromDB.getId() == null ) {
            throw new IllegalArgumentException("Employee could not found! ID:" + id);
        }

        employeeFromDB.setFirstName(employee.getFirstName());
        employeeFromDB.setLastName(employee.getLastName());
        employeeFromDB.seteMail(employee.geteMail());
        employeeFromDB.setPhoneNumber(employee.getPhoneNumber());
        employeeFromDB.setTitle(employee.getTitle());
        employeeFromDB.setDepartment(employee.getDepartment());
        employeeFromDB.setPhoto(employee.getPhoto());
        employeeFromDB.setUpdatedAt(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

        employeeRepo.save(employeeFromDB);
        return modelMapper.map(employeeFromDB, EmployeeDTO.class);
    }

}
