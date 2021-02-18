import java.util.Scanner;



public class AssignmentMarks 
{

	private String courseName;
	private int assignment1;
	private int assignment2;
	private int assignment3;
	
	public AssignmentMarks(String name, int mark1, int mark2, int mark3)
	{
		this.courseName = name;
		this.assignment1 = mark1;
		this.assignment2 = mark2;
		this.assignment3 = mark3;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public int getAssignment1()
	{
		return assignment1;
	}
	
	public int getAssignment2()
	{
		return assignment2;
	}
	
	public int getAssignment3()
	{
		return assignment3;
	}
	
	public int getAverageMark()
	{
		return (assignment1 + assignment2 + assignment3) / 3;
		
	}
	
	public String markToGrade(int mark)
	{
		String grade = "";
		if(mark >= 0 && mark <= 39)
		{
			grade = "D";
		}
		else if(mark >= 40 && mark <= 49)
		{
			grade = "C-";
		}
		else if(mark >= 50 && mark <= 59)
		{
			grade = "C";
		}
		else if(mark >= 60 && mark <= 69)
		{
			grade = "C+";
		}
		else if(mark >= 70 && mark <= 74)
		{
			grade = "B-";
		}
		else if(mark >= 75 && mark <= 79)
		{
			grade = "B";
		}
		else if(mark >= 80 && mark <= 84)
		{
			grade = "B+";
		}
		else if(mark >= 85 && mark <= 89)
		{
			grade = "A-";
		}
		else if(mark >= 90 && mark <= 94)
		{
			grade = "A";
		}
		else if(mark >= 95 && mark <= 100)
		{
			grade = "A+";
		}
		return grade;
	}
	
	public static int setMark()
	{
		Scanner scanner = new Scanner(System.in);
		int mark = -1;
	      while (true)
	            try {
	                mark = Integer.parseInt(scanner.nextLine());
	                if(mark <0 || mark >100)
	      	      	{
	      	    	  System.out.println("Please enter a value between 0 and 100");
	      	      	}
	                else
	                {
	                	break;
	                }
	            } catch (NumberFormatException nfe) {
	                System.out.print("Please enter an integer");
	            }
	   
	      return mark;
	}

}
