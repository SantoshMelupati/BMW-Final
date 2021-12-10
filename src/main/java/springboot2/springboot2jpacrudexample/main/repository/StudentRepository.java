package springboot2.springboot2jpacrudexample.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot2.springboot2jpacrudexample.main.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{

	//List<Student> findStudentByDepartment(String department);

	
	Student getStudentById(Long i);

	//List<Student> findStudentByDeptId(String department);

}
