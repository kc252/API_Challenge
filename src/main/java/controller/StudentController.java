package controller;

import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Student;
import service.StudentService;   

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService ss;

	//1. Get list of all students
	@RequestMapping(value = "/all", method =  RequestMethod.GET)
	public Hashtable<String, Student> getAll() {
		return ss.getAll();
	}
	
	// 2. Get single student based on id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") String id) {
		return ss.getStudent(id);
	}
	
	// 3. Create New Student
	@RequestMapping(value = "/post_{id}", method = RequestMethod.POST)
	public void addStudent(@PathVariable("id") String id) {
		ss.postStudent(id);
	}
	
	//4. Update Students Information
	@RequestMapping(value = "/update_{id}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable("id") String id) {
		ss.updateStudent(id);
	}

	// 5. Delete Student
	@RequestMapping(value = "/delete_{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") String id) {
		ss.deleteStudent(id);
		
	}
	
}