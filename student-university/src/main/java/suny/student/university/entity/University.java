package suny.student.university.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="University")
public class University {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String univName;
	
	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private List<Student> student = new ArrayList<>();
	

	public University(String univName) {
		super();
		this.univName = univName;
	}


	public String getUnivName() {
		return univName;
	}


	public void setUnivName(String univName) {
		this.univName = univName;
	}


	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	public University() {
	
	}

}
