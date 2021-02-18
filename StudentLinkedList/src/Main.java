import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {

	public static LinkedList <Student> students;

	
	public static void main(String[] args) throws Exception 
	{		
		// create list
		students = new LinkedList <Student>();

		// start read file method to add elements to linked list
		readFile("C:/Temp/studentdata.txt");
	
		// main menu display
		boolean cont = true;
		while(cont == true)
		{			
			System.out.println("Student Report System\n----------------------\n1) Display student marks\n2) Display student grades\n"
					+ "3) Add new student\n4) Remove student\n5) Exit");
			
			int input = getInt();
		
			if(input == 1)
			{
				displayReportByMarks();
			}
			else if(input == 2)
			{
				displayReportByGrades();
			}
			else if(input == 3)
			{
				addNewStudent();
			}
			else if(input == 4)
			{
				removeStudent();
			}
			else if(input == 5)
			{
				System.exit(1);
			}
			else
			{
				System.out.println("Invalid input\nPlease enter from the following options\n\n");
			}
		}
	
	}
	
	// read file method
	public static boolean readFile(String filename) { File file = new File(filename);
	try 
	{
			// reads file
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				// adds to array
				String[] words =scanner.nextLine().split(",");
				
				// assign items from array to variables
				int id = Integer.parseInt(words[0]);
				String firstName = words[1];
				String lastName = words[2];
				int mathsMark1 = Integer.parseInt(words[3]);
				int mathsMark2 = Integer.parseInt(words[4]);
				int mathsMark3 = Integer.parseInt(words[5]);
				int englishMark1 = Integer.parseInt(words[6]);
				int englishMark2 = Integer.parseInt(words[7]);
				int englishMark3 = Integer.parseInt(words[8]);
				
				// use addStudent method to create student object
				addStudent(id, firstName, lastName, mathsMark1, mathsMark2, mathsMark3, englishMark1, englishMark2, englishMark3);
		
			}
			scanner.close();
	} 
	catch (FileNotFoundException e) 
	{
			System.out.println("Failed to read file");
	}
	return true;
	}

	// addStudent method
	private static void addStudent(int id, String firstName, String lastName,int
			mathsMark1, int mathsMark2, int mathsMark3, int englishMark1, int englishMark2,
			int englishMark3)
	{
		//creates the aStudent object
		Student aStudent = new Student(id, firstName, lastName);
		AssignmentMarks mathSubject = new AssignmentMarks("Maths", mathsMark1, mathsMark2, mathsMark3);
		AssignmentMarks englishSubject = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);

		aStudent.math = mathSubject;
		aStudent.english = englishSubject;
		
		// inserts aStudent object into the linkedlist
		students.add(aStudent);
		
	}
	
	
	// display by marks method
	private static void displayReportByMarks()
	{
		
		System.out.println("ID\tName\t\tCourse\tA1\tA2\tA3\tAverage\tCourse\tA1\tA2\tA3\tAverage");
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		// loops linked list printing all values
		for(Student s : students)
		{
			System.out.println(s.id + "\t" + s.firstName + " " + s.lastName 
					+ "\t" + s.math.getCourseName() + "\t" + s.math.getAssignment1() 
					+ "\t" + s.math.getAssignment2() + "\t" + s.math.getAssignment3() 
					+ "\t" + s.math.getAverageMark() + "\t" + s.english.getCourseName() + "\t"
					+ s.english.getAssignment1() + "\t" + s.english.getAssignment2() 
					+ "\t" + s.english.getAssignment3() + "\t" + s.english.getAverageMark());
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------\n");
		
		menuExit();
	}
	
	
	// display by grades method
	private static void displayReportByGrades()
	{
		
		System.out.println("ID\tName\t\tCourse\tA1\tA2\tA3\tAverage\tCourse\tA1\tA2\tA3\tAverage");
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		for(Student s : students)
		{
			System.out.println(s.id + "\t" + s.firstName + " " + s.lastName 
					+ "\t" + s.math.getCourseName() + "\t" + s.math.markToGrade(s.math.getAssignment1()) 
					+ "\t" + s.math.markToGrade(s.math.getAssignment2()) + "\t" + s.math.markToGrade(s.math.getAssignment3())
					+ "\t" + s.math.markToGrade(s.math.getAverageMark()) + "\t" + s.english.getCourseName() + "\t"
					+ s.english.markToGrade(s.english.getAssignment1()) + "\t" + s.english.markToGrade(s.english.getAssignment2()) 
					+ "\t" + s.english.markToGrade(s.english.getAssignment3()) + "\t" + s.english.markToGrade(s.english.getAverageMark()));
			
		}
		System.out.println("------------------------------------------------------------------------------------------------------\n");
		
		menuExit();
	}
	
	// add student method
	private static void addNewStudent()
	{
		Scanner scanner = new Scanner(System.in);
		
		// asks the user for the inputs
		System.out.println("Please enter the first name");
		String firstName = scanner.next();
		System.out.println("Please enter the last name");
		String lastName = scanner.next();
		System.out.println("Please enter the mark for Maths assigntment 1");
		int mathMark1 = AssignmentMarks.setMark();
		System.out.println("Please enter the mark for Maths assigntment 2");
		int mathMark2 = AssignmentMarks.setMark();		
		System.out.println("Please enter the mark for Maths assigntment 3");
		int mathMark3 = AssignmentMarks.setMark();
		System.out.println("Please enter the mark for English assigntment 1");
		int englishMark1 = AssignmentMarks.setMark();
		System.out.println("Please enter the mark for English assigntment 2");
		int englishMark2 = AssignmentMarks.setMark();
		System.out.println("Please enter the mark for English assigntment 3");
		int englishMark3 = AssignmentMarks.setMark();
		
		// gets last student ID
		Student s = students.getLast();
		// creates new student ID
		int id = s.id + 1;
		
		// adds student to linked list
		addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);

		System.out.println("Student added, your new student ID is " + id);
		
		menuExit();
	}
	
	// remove student method
	private static void removeStudent()
	{
		// removes student by ID
		System.out.println("Please ente the ID of the student you would like to remove");
		int id = getInt();
		Student d = students.getFirst();
		
		// searching for ID
		for(Student s : students)
		{
			d = s;
			if(s.id == id)
			{
				students.remove(s);
				System.out.println("Student removed");
				break;
			}
			
		}		
		if(d.id != id)
		{
		System.out.println("Student ID not found......");
		}
		menuExit();

		}
	
	// get an integer method
	private static int getInt()
	{
		Scanner scanner = new Scanner(System.in);
		int input;
		   while (true)
	            try {
	                input = Integer.parseInt(scanner.nextLine());
	                break;
	            } catch (NumberFormatException nfe) {
	                System.out.print("Please enter an integer\n");
	            }
		   return input;
	}
	
	
	// menu exit method
	private static void menuExit()
	{
		System.out.println("1) Return to menu\n2) Exit");
		int input;
		do{
		input = getInt();
		if(input == 2)
		{
			System.exit(1);
		}
		if(input != 1){
			System.out.println("Please enter a valid input");
		}
		}while(input != 1);
	}
	
	}
	



