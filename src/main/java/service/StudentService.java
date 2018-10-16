package service;

import java.util.Hashtable;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import model.Student;

@Service
public class StudentService {

	//Populating Hash table with Students
	Hashtable<String, Student> students = new Hashtable<String, Student>();
	public StudentService() {
		Student s = new Student();
		s.setStudentID("1");
		s.setFirst("Kevin");
		s.setLast("Campbell");
		s.setEmail("kevinCampbell@aol.com");
		students.put("1", s);

		s = new Student();
		s.setStudentID("2");
		s.setFirst("Glenn");
		s.setLast("Derwin");
		s.setEmail("glennDerwin@hotmail.com");
		students.put("2",s);
	}

	//1. Get a list of all students [GET]
	public Hashtable<String, Student> getAll() {
		return students;
	}
	//2. Get a single student [GET]
	public Student getStudent(String id) {
		if(students.containsKey(id)){
			return students.get(id);
		}
		else {
			return null;
		}
	}
	//3. Create a new student
	public void postStudent(String id) {

		if(students.containsKey(id)) {
			System.out.println("Student Already Exists");
		}
		else {

			String first; 
			String last;
			String email;

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter student first name: ");
			first = sc.nextLine();
			System.out.println("Enter student last name: ");
			last = sc.nextLine();
			System.out.println("Enter student email: ");
			email = sc.nextLine();

			Student s = new Student();
			s.setStudentID(id);
			s.setFirst(first);
			s.setLast(last);
			s.setEmail(email);
			students.put(id, s);
			System.out.println("Success! Student Added.");
			
			sc.close();


		}
	}

	// 4. Update Students Information

	public void updateStudent(String id) {

		if(students.containsKey(id)) {
			
			Student s = new Student();
			

			String attributeToChange;

			String first; 
			String last;
			String email;

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter attribute to change first/last/id/email: ");
			attributeToChange = sc.nextLine().toLowerCase();

			if(attributeToChange.equals("first")) {
				System.out.println("Enter new First Name: ");
				first = sc.nextLine();
				s.setFirst(first);
				
			} 
			else if(attributeToChange.equals("last")) {
				System.out.println("Enter new Last Name: ");
				last = sc.nextLine();
				s.setLast(last);
				students.put(id, s);
			}
			
			else if(attributeToChange.equals("id")){
				System.out.println("Enter new id: ");
				id = sc.nextLine();
				s.setStudentID(id);
				students.put(id, s);
			}
			else if(attributeToChange.equals("e")) {
				System.out.println("Enter new email: ");
				email = sc.nextLine();
				s.setStudentID(email);
				students.put(id, s);
			} 
			
			sc.close();
			
		} else {
			System.out.println("Student does not exist");
		}
	}

	//5. Delete a Student 
	public void deleteStudent(String id) {

		if(students.containsKey(id)) {
			students.remove(id);
			System.out.println("Success! Student Deleted.");
		}
		else {
			System.out.println("Student does not exist.");
		}
	}

}