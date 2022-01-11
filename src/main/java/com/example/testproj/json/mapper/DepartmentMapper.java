package com.example.testproj.json.mapper;

import com.example.testproj.entity.Department;
import com.example.testproj.json.dto.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "id", source = "departmentId")
    DepartmentDto toDepartmentDto(Department department);

    @Mapping(target = "departmentId", source = "id")
    Department toDepartment(DepartmentDto departmentDto);
}
