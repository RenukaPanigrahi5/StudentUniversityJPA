package suny.student.university.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import suny.student.university.entity.University;
import suny.student.university.service.UniversityService;

@RestController
public class UniversityController {
	
	@Autowired
	private UniversityService universityService;

	@PostMapping("/createUniversity")
	public ResponseEntity<University> createUniversity(@RequestBody University univ) {
		University university = universityService.createUniversity(univ);
		return new ResponseEntity<>(university, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/createListOfUniversity")
	public ResponseEntity<List<University>> createListOfUniversity(@RequestBody List<University> univ) {
		List<University> university = universityService.createListOfUniversity(univ);
		return new ResponseEntity<>(university, HttpStatus.CREATED);
	}
	
	@GetMapping("/getStudentNamesByUnivId")
	public ResponseEntity<List<String>>  getStudentNamesByUniversity(@RequestParam(name="univId") Long univId) {
		List<String> studNames = universityService.studListByUniversityId(univId);
		return new ResponseEntity<>(studNames, HttpStatus.OK);
	}
	//University name i neeed to get the student count 3univer and count at the same time
	//university name as input need to get list of students names
	
	
	@GetMapping("/getUnivNameWithStudCount")
	public ResponseEntity<Map<String,Integer>>  getUnivNameByStudCount(@RequestParam(name="univName") String univName) {
		Map<String,Integer> univStudCount = universityService.univNameAndStudCount(univName);
		return new ResponseEntity<>(univStudCount, HttpStatus.OK);
	}
	
	
	@GetMapping("/getUnivNameWithStudNames")
		public ResponseEntity<Map<String,List<String>>> getUnivNameAnyStudNames(@RequestParam(name="univName") String univName) {
		Map<String,List<String>> univNameStudNames = universityService.univNameAndListOfStud(univName);
			return new ResponseEntity<>(univNameStudNames, HttpStatus.OK);
		}
		
	//
}
