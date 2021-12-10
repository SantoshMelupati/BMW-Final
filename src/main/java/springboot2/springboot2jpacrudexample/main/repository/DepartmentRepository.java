package springboot2.springboot2jpacrudexample.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot2.springboot2jpacrudexample.main.model.Department;

public interface DepartmentRepository extends JpaRepository<Department , String>
{

	Department getDepartmentByDeptid(String id);

}
