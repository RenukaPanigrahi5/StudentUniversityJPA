package suny.student.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import suny.student.university.entity.Student;
import suny.student.university.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
      University findByUnivName(String univName);
      List<University> save(List<University> univ);
}
