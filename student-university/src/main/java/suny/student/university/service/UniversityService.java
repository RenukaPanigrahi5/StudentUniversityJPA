package suny.student.university.service;

import java.util.List;
import java.util.Map;

import suny.student.university.entity.University;

public interface UniversityService {
	University createUniversity(University univ);
	List<String> studListByUniversityId(Long univId);
	Map<String,Integer> univNameAndStudCount(String univName);
	Map<String,List<String>> univNameAndListOfStud(String univName);
	List<University> createListOfUniversity(List<University> univ);
}
