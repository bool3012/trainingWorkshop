package corrieri.ponza.model.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import corrieri.ponza.model.Student;

public class DTOresponse extends DTO {

	public DTOresponse(DTO dto, String string) {
			
		this.error = dto.getError();
		this.message = string;
		
	}

	public DTOresponse(){
		
	}
	
	public String getProblemid() {
		return problemid;
	}

	public void setProblemid(String problemid) {
		this.problemid = problemid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentsurname() {
		return studentsurname;
	}

	public void setStudentsurname(String studentsurname) {
		this.studentsurname = studentsurname;
	}


	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private List<Student> students;
	
	@JsonInclude(Include.NON_NULL)
	private String problemid;
	
	@JsonInclude(Include.NON_NULL)
	private String studentid;

	@JsonInclude(Include.NON_NULL)
	private String studentname;
	
	@JsonInclude(Include.NON_NULL)
	private String studentsurname;
	
	
}
