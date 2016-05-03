package corrieri.ponza.controller.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import corrieri.ponza.controller.StudentService;
import corrieri.ponza.model.Problem;
import corrieri.ponza.model.Student;
import corrieri.ponza.model.rest.DTOresponse;
import corrieri.ponza.repositories.ProblemRepository;
import corrieri.ponza.repositories.StudentRepository;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	ProblemRepository problemRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public ResponseEntity<DTOresponse> createStudent(String name, String surname, String problemcause) {
	
		Student student = new Student(name, surname);
		Problem problem = new Problem(problemcause);
		
		problemRepository.save(problem);
		
		student.setProblem(problem);
		
		studentRepository.save(student);
		
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setStudentid(student.getId());
		dtoresponse.setStudentname(student.getName());
		dtoresponse.setStudentsurname(student.getSurname());
		dtoresponse.setProblemid(student.getProblem().getId());
		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
		
		
		return response;
	}


	@Override
	public ResponseEntity<DTOresponse> getStudents() {
		
		List<Student> students = studentRepository.findAll();
		
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setStudents(students);
		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);	
		
		return response;
		
	}
	
	@Override
	public ResponseEntity<DTOresponse> getStudentByName(String name) {
				
		List<Student> myStudent = studentRepository.findAll().stream()
                .filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
		
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setStudents(myStudent);		
		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);	
		
		return response;
		
	}
	
	@Override
	public ResponseEntity<DTOresponse> modStudent(String id, String newname, String newsurname, String newproblemcause) {
		
		Student s = studentRepository.findOne(id);
		Problem problem = problemRepository.findOne(s.getProblem().getId());
		
		problem.setCause(newproblemcause);		
		problemRepository.save(problem);
		s.setName(newname);
		s.setSurname(newsurname);
		s.setProblem(problem);
		studentRepository.save(s);		
		
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setStudentid(s.getId());
		dtoresponse.setStudentname(s.getName());
		dtoresponse.setStudentsurname(s.getSurname());
		dtoresponse.setProblemid(s.getProblem().getId());
		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);	
		
		return response;
		
	}




}
