package net.ukr.geka3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Group implements Serializable {
	String name;

	Student[] array = new Student[10];

	public Group(String name) {
		super();
		this.name = name;
	}

	public static Group getGroup(String address) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(address))) {
			return (Group) ois.readObject();

		} catch (IOException e) {
			System.out.println("IO error" + e);
		} catch (ClassNotFoundException e) {
			System.out.println("error no found class");
		} catch (ClassCastException e) {
			System.out.println("error mismatch class");
		}

		return null;
	}

	public void saveGroup(String address) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(address))) {
			oos.writeObject(this);
			oos.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addStudent(Student std) throws FullGroupException {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = std;
				System.out.println(std.name + " is added to group " + this.name);
				return;
			}
		}
		throw new FullGroupException("Group " + name + " is full Exception for " + std.name);
	}

	public void addStudent() throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input name");
		String name = sc.nextLine();
		
		System.out.println("Input surName");
		String surName = sc.nextLine();
		
		System.out.println("Input age");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Input sex M / other W");
		boolean sex;
		String temp = sc.nextLine();
		
		if( temp.equalsIgnoreCase("M")){
			sex = true;
			System.out.println("you input M");
		}else{
			sex = false;
			System.out.println("you input W");
		}
		
		System.out.println("Input course");
		int course = sc.nextInt();
		
		
		System.out.println("Input departmant");
		String departmant = sc.nextLine();
		departmant = sc.nextLine();
		try {
			this.addStudent(new Student(name, surName, age, sex, course, departmant));
		} catch (FullGroupException e) {
			
			e.printStackTrace();
		}
		SortStudentsArrya(array);

	}

	public String getSortedListOfStudents() {
		StringBuilder studList = new StringBuilder();
		SortStudentsArrya(array);
		for (int i = 0;i < array.length;i++) {
			if (array[i] != null) {
				studList.append( i + " " + array[i].surName + " " + array[i].name + System.lineSeparator());
			}else{
			//	studList.append(i + " null" + System.lineSeparator());
			}

		}
		return studList.toString();
	}

	static public void SortStudentsArrya(Student[] stdArray) {
		Student temp = null;
		for (int i = 0; i < stdArray.length; i++) {
			for (int j = i; j < stdArray.length; j++) {
				if (stdArray[i] == null) {
					temp = stdArray[i];
					stdArray[i] = stdArray[j];
					stdArray[j] = temp;
				} else if (stdArray[j] == null) {
				}

				else if ((stdArray[i].surName + stdArray[i].name)
						.compareToIgnoreCase(stdArray[j].surName + stdArray[j].name) > 0) {
					temp = stdArray[i];
					stdArray[i] = stdArray[j];
					stdArray[j] = temp;
				}

			}
		}

	}

	public Student getStudent(String surName) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && array[i].surName.equals(surName)) {
				return array[i];
			}
		}
		return null;
	}
	
	public Student delStudent(int index){
		if(array[index] == null){
			System.out.println("student is null");
			return null;
		}
		System.out.println("index "  + index + " was deleted " + array[index].surName);
		Student temp = array[index]; 
		array[index] = null;
		SortStudentsArrya(array);
		return temp;
		
	}

}
