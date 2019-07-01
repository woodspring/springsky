package woodspring.springsky.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema="person")
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private int personId;
	
    @Column(nullable=false)
	private String firstname;
	
    @Column(nullable=false)
	private String lastname;
	
	private Date birthdate;
	
	private int startYear;
	
	@OneToMany(mappedBy = "persons", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PersonDetail> personDetail = new ArrayList<>();

}
