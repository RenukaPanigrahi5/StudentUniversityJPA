package suny.student.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import suny.student.university.entity.University;
import suny.student.university.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/getUniversityByStudName")
	public ResponseEntity<String> getUnivByStudName(@RequestParam(name="studentName") String studName) {
		String univName = studentService.getUnivNameByStudName(studName);
		if(univName==null){
			return new ResponseEntity<>("University Name Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(univName, HttpStatus.OK);
	}
	

}
