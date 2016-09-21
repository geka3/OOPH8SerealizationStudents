package net.ukr.geka3;

import java.io.Serializable;

public class Human implements Serializable {
	protected String name;
	protected String surName;
	protected int age;
	protected boolean sex;

	public Human(String name, String surName, int age, boolean sex) {
		super();
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.sex = sex;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Human [name=" + name + ", surName=" + surName + ", age=" + age + ", sex=" + sex + "]";
	}



	public Human() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @param surName
	 *            the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the sex
	 */
	public boolean isSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}

}
