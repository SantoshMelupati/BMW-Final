package springboot2.springboot2jpacrudexample.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot2.springboot2jpacrudexample.main.model.College;


public interface CollegeRepository extends JpaRepository<College , String>
{

	College getCollegeByCoolegeCode(String string);

}
