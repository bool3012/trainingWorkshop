package corrieri.ponza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import corrieri.ponza.controller.StudentService;
import corrieri.ponza.model.rest.DTOStudent;
import corrieri.ponza.model.rest.DTOresponse;

@RestController
@RequestMapping("/")
public class RestPresentation {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/createStudent/", method = RequestMethod.POST)
	public ResponseEntity<DTOresponse> createStudent(@RequestBody DTOStudent dtoStudent) {

		return studentService.createStudent(dtoStudent.getName(), dtoStudent.getSurname(), dtoStudent.getProblem());

	}

	
	@RequestMapping(value = "/getStudents/", method = RequestMethod.GET)
	public ResponseEntity<DTOresponse> getStudents() {

		return studentService.getStudents();

	}
	
	@RequestMapping(value = "/getStudentByName", params = "name", method = RequestMethod.GET)
	public ResponseEntity<DTOresponse> getStudentByName(@RequestParam("name") String name) {

		return studentService.getStudentByName(name);

	}
	
	@RequestMapping(value = "/modStudent", params = "id", method = RequestMethod.PUT)
	public ResponseEntity<DTOresponse> modStudent(@RequestParam("id") String id, @RequestBody DTOStudent dtoStudent) {

		return studentService.modStudent(id, dtoStudent.getName(), dtoStudent.getSurname(), dtoStudent.getProblem());

	}


}
