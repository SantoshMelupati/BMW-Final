package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import springboot2.springboot2jpacrudexample.main.Application;
import springboot2.springboot2jpacrudexample.main.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmployeeById() {
		Student employee = restTemplate.getForObject(getRootUrl() + "/employees/1", Student.class);
		System.out.println(employee.getName());
		assertNotNull(employee);
	}

	@Test
	public void testCreateEmployee() {
		Student employee = new Student();
		employee.setMailid("admin@gmail.com");
		employee.setName("admin");
		employee.setPhoneno("admin");

		ResponseEntity<Student> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", employee, Student.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateEmployee() {
		int id = 1;
		Student employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Student.class);
		employee.setName("admin1");
		employee.setPhoneno("admin2");

		restTemplate.put(getRootUrl() + "/employees/" + id, employee);

		Student updatedEmployee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Student.class);
		assertNotNull(updatedEmployee);
	}

	@Test
	public void testDeleteEmployee() {
		int id = 2;
		Student employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Student.class);
		assertNotNull(employee);

		restTemplate.delete(getRootUrl() + "/employees/" + id);

		try {
			employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Student.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
