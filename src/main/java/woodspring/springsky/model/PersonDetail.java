package woodspring.springsky.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema="person_detail")
@Data
public class PersonDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pd_d")
	private int pdId;
	
	private String detail;
	
	@Column(name = " person_detailcol")
	private String personDetail;
	
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name="person_id")
    private Person person;


}
