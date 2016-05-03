package corrieri.ponza.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import corrieri.ponza.model.rest.DTOresponse;

public interface StudentService {

	ResponseEntity<DTOresponse> createStudent(String name, String surname, String problemcause);
	ResponseEntity<DTOresponse> getStudents();
	ResponseEntity<DTOresponse> getStudentByName(@RequestParam("name") String name);
	ResponseEntity<DTOresponse> modStudent(String id, String name, String surname, String problemcause);
}
