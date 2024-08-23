package in.ashokit.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "enquiries_tbl")
public class Enquiry {
	
	
//	2) enquiries_tbl
//
//enq_id  (PK)
//student_name
//student_phno
//course_name
//class_mode
//enq_status
//created_date
//updated_date
//
//counsellor_id (FK)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enqId;
	private String studentName;
	private Long studentPhno;
	private String courseName;
	private String classMode;
	private String enqStatus;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	
	@ManyToOne
	@JoinColumn(name = "counsellorId")
	private Counsellor counsellor;


	public Integer getEnqId() {
		return enqId;
	}


	public void setEnqId(Integer enqId) {
		this.enqId = enqId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Long getStudentPhno() {
		return studentPhno;
	}


	public void setStudentPhno(Long studentPhno) {
		this.studentPhno = studentPhno;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getClassMode() {
		return classMode;
	}


	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}


	public String getEnqStatus() {
		return enqStatus;
	}


	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}


	public LocalDate getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Counsellor getCounsellor() {
		return counsellor;
	}


	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}


	
}
