package com.example.testproj.repository.custom.impl;

import com.example.testproj.entity.Department;
import com.example.testproj.entity.Department_;
import com.example.testproj.entity.Person;
import com.example.testproj.entity.Person_;
import com.example.testproj.json.dto.Filter;
import com.example.testproj.repository.custom.CustomPersonRepository;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    private final EntityManager entityManager;

    @Override
    public List<Person> findByFilter(Filter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = query.from(Person.class);
        Join<Person, Department> personDepartmentJoin = personRoot.join(Person_.department);

        query
                .select(personRoot)
                .distinct(true);

        List<Person> people = new ArrayList<>();

        if (filter != null) {
            final String lastname = filter.getLastname();
            final String birthDate = filter.getDate();
            final String department = filter.getDepartment();

            Predicate lastnamePredicate = lastname != null ? criteriaBuilder
                    .like(personRoot.get(Person_.lastname), "%" + lastname + "%") :
                    criteriaBuilder.like(personRoot.get(Person_.lastname), "%");

            Predicate birthDatePredicate = birthDate != null ? criteriaBuilder
                    .equal(personRoot.get(Person_.birthDate), Date.valueOf(birthDate)) :
                    criteriaBuilder.lessThan(personRoot.get(Person_.birthDate), Date.valueOf(LocalDate.now()));

            Predicate departmentPredicate = department != null ? criteriaBuilder
                    .or(
                            criteriaBuilder.like(
                                    personDepartmentJoin.get(Department_.fullName),
                                    "%" + department + "%"
                            ),
                            criteriaBuilder.like(
                                    personDepartmentJoin.get(Department_.shortName),
                                    "%" + department + "%"
                            )
                    ) :
                    criteriaBuilder
                            .or(
                                    criteriaBuilder.like(
                                            personDepartmentJoin.get(Department_.fullName),
                                            "%"
                                    ),
                                    criteriaBuilder.like(
                                            personDepartmentJoin.get(Department_.shortName),
                                            "%"
                                    )
                            );
            query
                    .where(
                            criteriaBuilder
                                    .and(
                                            lastnamePredicate,
                                            birthDatePredicate,
                                            departmentPredicate
                                    )
                    );
        }

        people = entityManager
                .createQuery(query)
                .getResultList();

        return people;
    }
}
