package springboot2.springboot2jpacrudexample.main.controller;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter.*;

import javax.validation.Valid;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springboot2.springboot2jpacrudexample.main.exception.ResourceNotFoundException;
import springboot2.springboot2jpacrudexample.main.model.AddStudent;
import springboot2.springboot2jpacrudexample.main.model.College;
import springboot2.springboot2jpacrudexample.main.model.Department;
import springboot2.springboot2jpacrudexample.main.model.DeptCollege;
import springboot2.springboot2jpacrudexample.main.model.Student;
import springboot2.springboot2jpacrudexample.main.repository.CollegeRepository;
import springboot2.springboot2jpacrudexample.main.repository.DepartmentRepository;
import springboot2.springboot2jpacrudexample.main.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public static String UPLOADED_FOLDER="C:\\New folder\\";

	private final FileService fileService;

    @Autowired
    public StudentController(FileService fileService) {
        this.fileService = fileService;
    }
    
    
    
    @PostMapping("/files")
    public ResponseEntity<UploadResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws ParseException, IOException {
    	System.out.println("Hai");
        fileService.save(file);
        
        Path path=Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
        
          
        
        System.out.println(path);
        
        try (Reader reader = Files.newBufferedReader(Paths.get(path.toString()))) {
        	List<Student> std=studentRepository.findAll();
        	long n=std.size();
        	System.out.println("Length : "+n);
        	
        	// read csv file
        	Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
        	
        	//Department dpt=departmentRepository.getDepartmentByDeptid("100");
    		//College clg=collegeRepository.getCollegeByCoolegeCode("201");
        	
        	for (CSVRecord record : records) {
        		
        	            if(record.getRecordNumber()==1)
        	            	continue;
        	     
        	                Student emp=new Student();
        	               
        	                emp.setName(record.get(0));
        	                emp.setMailid(record.get(1));
        	               // emp.setDepartment(dpt);
        	                if(record.get(2).equalsIgnoreCase("ece")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("101");
        	                	emp.setDepartment(dpt);
        	                }
        	                else if(record.get(2).equalsIgnoreCase("cse")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("100");
        	                	emp.setDepartment(dpt);
        	                }
        	                else if(record.get(2).equalsIgnoreCase("mech")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("103");
        	                	emp.setDepartment(dpt);
        	                }
        	                else if(record.get(2).equalsIgnoreCase("aero")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("104");
        	                	emp.setDepartment(dpt);
        	                }
        	                else if(record.get(2).equalsIgnoreCase("eee")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("102");
        	                	emp.setDepartment(dpt);
        	                }
        	                else if(record.get(2).equalsIgnoreCase("petrolium")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("105");
        	                	emp.setDepartment(dpt);
        	                }
        	                else if(record.get(2).equalsIgnoreCase("it")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("106");
        	                	emp.setDepartment(dpt);
        	                }
        	                else if(record.get(2).equalsIgnoreCase("chemical")) {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("107");
        	                	emp.setDepartment(dpt);
        	                }
        	                else  {
        	                	Department dpt=departmentRepository.getDepartmentByDeptid("110");
        	                	emp.setDepartment(dpt);
        	                }
        	                //emp.setDepartment(record.get(2));
        	                emp.setPhoneno(record.get(3));
        	                emp.setAreaofinterest1(record.get(4));
        	                emp.setAreaofinterest2(record.get(5));
        	                emp.setAreaofinterest3(record.get(6));
        	                
        	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        	                
                            LocalDate localDate = LocalDate.parse(record.get(7).toString(), formatter);
        	                
        	                
        	                DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	                String formatedDateTime=localDate.format(format);
        	                
        	                emp.setDob(formatedDateTime.toString());
        	                
        	                
        	                emp.setGender(record.get(8)); 
        	                
        	                if(record.get(9).equalsIgnoreCase("srm")) {
        	                	College clg=collegeRepository.getCollegeByCoolegeCode("200");
        	                	emp.setCollege(clg);
        	                }
        	                else if(record.get(9).equalsIgnoreCase("psg")) {
        	                	College clg=collegeRepository.getCollegeByCoolegeCode("201");
        	                	emp.setCollege(clg);
        	                }
        	                else {
        	                	College clg=collegeRepository.getCollegeByCoolegeCode("202");
        	                	emp.setCollege(clg);
        	                }
        	        		
        	        		
        	                
        	                try {
        	               
        	                studentRepository.save(emp);
        	                     
        	                 
        	                }catch(Exception e) {
        	                	System.out.println(record.get(1)+" : Already exists");
        	                }
        	                std.add(emp);
        	                
        	             
        	}
        	        } catch (IOException ex) {
        	            ex.printStackTrace();
        	        }
       
      
        LocalDateTime now1 = LocalDateTime.now();  
       
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");  
        String formatDateTime = now1.format(format);  
        
        String name=file.getOriginalFilename();
        String fileName = name.substring(0,name.lastIndexOf("."));
        
        Files.move(path, path.resolveSibling(fileName+"-"+formatDateTime+".csv")); 

        return ResponseEntity.status(HttpStatus.OK)
                             .body(new UploadResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
    }
	
    @GetMapping("/students")
	public List<Student> getAllStudents() {
	 
		return studentRepository.findAll();
	}
	
    
	
	
	@GetMapping("/colleges")
	public List<College> getAllColleges() {
		
		return collegeRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
			throws ResourceNotFoundException {
		
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
		 System.out.println(student);
		return ResponseEntity.ok().body(student);
	}
	
	@PostMapping("/departments")
	public List<Student> getStudentByDept(@RequestBody DeptCollege deptCollege)
			throws ResourceNotFoundException {
		System.out.println("Entered");
		System.out.println(deptCollege.getDeptId());
		System.out.println(deptCollege.getCollegeId());
		List<Student> students=studentRepository.findAll();
		List<Student> departmentStudents=new ArrayList<>();
		for(Student dept:students) {
			if(deptCollege.getCollegeId().equalsIgnoreCase(dept.getCollege().getCoolegeCode()) && deptCollege.getDeptId().equalsIgnoreCase(dept.getDepartment().getDept_id())) {
				departmentStudents.add(dept);
				System.out.println(dept.getName());
			}
		}
	   return departmentStudents;
				
	}
	
	
	
	@GetMapping("/colleges/{id}")
	public ResponseEntity<College> getCollegeById(@PathVariable(value = "id") String coolegeCode)
			throws ResourceNotFoundException {
		
		College college = collegeRepository.findById(coolegeCode)
				.orElseThrow(() -> new ResourceNotFoundException("College not found for this id :: " + coolegeCode));
		return ResponseEntity.ok().body(college);
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") String dept_id)
			throws ResourceNotFoundException {
		
		Department department = departmentRepository.findById(dept_id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + dept_id));
		return ResponseEntity.ok().body(department);
	}
	

	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody AddStudent student) {
		Student studentDetails=new Student();
		
		System.out.println(student.getName());
		System.out.println("Hai");
		studentDetails.setName(student.getName());
		studentDetails.setMailid(student.getMailid());
		studentDetails.setPhoneno(student.getPhoneno());
		Department dpt=departmentRepository.getDepartmentByDeptid(student.getDeptId());
		College clg=collegeRepository.getCollegeByCoolegeCode(student.getCollegeId());
		studentDetails.setDepartment(dpt);
		studentDetails.setCollege(clg);
		studentDetails.setDob(student.getDob());
		studentDetails.setGender(student.getGender());
		try {
		if(student.getAreaofinterest1().equalsIgnoreCase("true")) {
			System.out.println(student.getAreaofinterest1());
			studentDetails.setAreaofinterest1("Internet of things");
		}
	
		}catch(Exception e) {
			
		}
		try {
		if(student.getAreaofinterest2().equalsIgnoreCase("true")) {
			System.out.println(student.getAreaofinterest2());
			studentDetails.setAreaofinterest2("Artificial Inteligence");
		}
		
	}catch(Exception e) {
		
	}
		try {
		if(student.getAreaofinterest3().equalsIgnoreCase("true")) {
			System.out.println(student.getAreaofinterest3());
			studentDetails.setAreaofinterest3("Machine Learning");
		}
		
		}catch(Exception e) {
			
		}
		//System.out.println("Student Details :"+student);
		return studentRepository.save(studentDetails);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
			@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

		student.setName(studentDetails.getName());
		student.setMailid(studentDetails.getMailid());
		student.setPhoneno(studentDetails.getPhoneno());
		student.setDepartment(studentDetails.getDepartment());
		student.setCollege(studentDetails.getCollege());
		student.setDob(studentDetails.getDob());
		student.setGender(studentDetails.getGender());
		
		student.setAreaofinterest1(studentDetails.getAreaofinterest1());
		student.setAreaofinterest2(studentDetails.getAreaofinterest2());
		student.setAreaofinterest3(studentDetails.getAreaofinterest3());
		
		final Student updatedEmployee = studentRepository.save(student);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
			throws ResourceNotFoundException {
		Student student= studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/college/{id}")
	public List<Student> searchByCollege(@PathVariable( value="id") String collegeId){
		
		System.out.println(collegeId);
		List<Student> students=studentRepository.findAll();
		List<Student> collegeStudents=new ArrayList<>();
		for(Student colleges:students) {
			if(collegeId.equalsIgnoreCase(colleges.getCollege().getCoolegeCode())) {
				collegeStudents.add(colleges);
			}
		}
		return collegeStudents;
	}
}
