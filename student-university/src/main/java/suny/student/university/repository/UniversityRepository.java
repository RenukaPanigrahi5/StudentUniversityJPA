package suny.student.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import suny.student.university.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

}
