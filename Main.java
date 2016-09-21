package net.ukr.geka3;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String fileAddress = "gr.txt";
		Group groupOne = new Group("FL-31");
		File file = new File(fileAddress);
		if (!file.exists()){
			try {
				file.createNewFile();
				groupOne.saveGroup(fileAddress);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error create file, program stoped");
				e.printStackTrace();
				return;
				
				
			}
		}
		
		for(;;){
			
			
			
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Input " + System.lineSeparator() + 
					" 1 to show list of students" + System.lineSeparator() + 
					" 2 to add new student " + System.lineSeparator() + 
					" 3 to del student by index");
			switch(sc.nextLine()){
			case "1":
				groupOne = Group.getGroup(fileAddress);
				System.out.println(groupOne.getSortedListOfStudents());
				break;
			case "2":
				
				
				groupOne = Group.getGroup(fileAddress);
				
				try{
					groupOne.addStudent();
				}catch(InputMismatchException e){
					System.out.println("maybe you input not correct data!!!");
				}
				
				
				
				groupOne.saveGroup(fileAddress);
				
				break;
			case "3":
				groupOne = Group.getGroup(fileAddress);
				System.out.println("input index");
				Student temp;
				if((temp = groupOne.delStudent(sc.nextInt())) != null){
					System.out.println("student" + temp.toString() + " was deleted");
				}
				
				groupOne.saveGroup(fileAddress);
				
				break;
			default:
				break;
			
				
			}
			
			
			
		}
		
		
//		Student stOne = new Student("Vasya", "Petechkin", 18, true,  1, "IFF");
//		Student stTwo = new Student("Lena", "Zayceva", 18, false,  1, "IFF");
//		Student stThree = new Student("Kolya", "Petechkin", 18, true,  1, "IFF");

		
		
		
		
//		try {
//
//				groupOne.addStudent(stOne);
//				groupOne.addStudent(stTwo);
//				groupOne.addStudent(stThree);
//			
//
//		} catch (FullGroupException e) {
//			
//			e.printStackTrace();
//		}
//		
//		
//		groupOne.saveGroup("gr.txt");
//		Group groupTwo = Group.getGroup("gr.txt");
//		
//		
//		
//		
//		System.out.println();
//		//searching student by family
//		Student findStudent = groupOne.getStudent("Zayceva");
//		
//		if(findStudent != null){
//			System.out.println("Student was found " + System.lineSeparator() + findStudent.toString());
//			
//			
//		}else{
//			System.out.println("Student was not found");
//		}
//		
//		
//		System.out.println("it is working!!! :)))");
	}
	
	

}
