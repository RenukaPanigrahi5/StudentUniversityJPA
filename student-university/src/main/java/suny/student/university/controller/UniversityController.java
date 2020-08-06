package suny.student.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import suny.student.university.entity.University;
import suny.student.university.service.UniversityService;

@RestController
public class UniversityController {
	
	@Autowired
	private UniversityService universityService;

	@PostMapping("/createUniversity")
	public ResponseEntity<University>  createUniversity(@RequestBody University univ) {
		University university = universityService.createUniversity(univ);
		return new ResponseEntity<>(university, HttpStatus.CREATED);
	}
}
