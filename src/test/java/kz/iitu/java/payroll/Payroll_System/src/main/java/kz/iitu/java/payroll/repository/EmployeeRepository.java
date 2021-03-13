package kz.iitu.java.payroll.repository;

import kz.iitu.java.payroll.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query(value = "select *from employees", nativeQuery = true)
    List<Employee> findAll(String name, Integer age);

    Page<Employee> findAll(Pageable pageable);
}
