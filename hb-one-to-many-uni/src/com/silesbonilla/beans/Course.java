package com.silesbonilla.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH ,CascadeType.PERSIST})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY
				, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviewList;
	
	
	
	public Course() {}
	
	public Course(String title) {
		this.title = title;
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public List<Review> getReviewList(){
		return reviewList;
	}
	public void setReviewList(List<Review> reviews) {
		reviewList = reviews;
	}
	
	
	// Add a convenience method to add a review to the list.
	public void addReview(Review theReview) {
		if (reviewList == null) {
			reviewList = new ArrayList<Review>();
		}
		reviewList.add(theReview);
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	
}
