package net.ukr.geka3;

import java.io.Serializable;

public class Student extends Human implements Serializable {
//генерирование пустого конструктора ?
	
	protected int course;
	protected String departmant;
	
	public Student(String name, String surName, int age, boolean sex, int course, String departmant) {
		super(name, surName, age, sex);
		
		this.course = course;
		this.departmant = departmant;
	}
	public Student(String name, String surName, int age, boolean sex) {
		super(name, surName, age, sex);
	}
	public Student() {
		super();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student course=" + course + ", departmant=" + departmant + "]" + super.toString();
	}
	
	
	/**
	 * @return the course
	 */
	public int getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(int course) {
		this.course = course;
	}
	/**
	 * @return the departmant
	 */
	public String getDepartmant() {
		return departmant;
	}
	/**
	 * @param departmant the departmant to set
	 */
	public void setDepartmant(String departmant) {
		this.departmant = departmant;
	}
	
	
	
}
