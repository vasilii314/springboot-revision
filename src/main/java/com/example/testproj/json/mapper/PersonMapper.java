package com.example.testproj.json.mapper;

import com.example.testproj.entity.Department;
import com.example.testproj.entity.Person;
import com.example.testproj.json.dto.DepartmentDto;
import com.example.testproj.json.dto.PersonDto;
import org.hibernate.mapping.DependantValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", source = "personId")
    @Mapping(target = "department", expression = "java(toDepartmentDto(person.getDepartment()))")
    PersonDto toPersonDto(Person person);

    @Mapping(target = "personId", source = "id")
    @Mapping(target = "department", expression = "java(toDepartment(personDto.getDepartment()))")
    Person toPerson(PersonDto personDto);

    default DepartmentDto toDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getDepartmentId() );
        departmentDto.setFullName( department.getFullName() );
        departmentDto.setShortName( department.getShortName() );
        departmentDto.setPhoneNumber( department.getPhoneNumber() );

        return departmentDto;
    }

    default Department toDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDepartmentId( departmentDto.getId() );
        department.setFullName( departmentDto.getFullName() );
        department.setShortName( departmentDto.getShortName() );
        department.setPhoneNumber( departmentDto.getPhoneNumber() );

        return department;
    }
}
