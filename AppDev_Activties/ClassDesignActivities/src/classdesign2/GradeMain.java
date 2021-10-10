package classdesign2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class GradeMain {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in); //for inputs
		 DecimalFormat df = new DecimalFormat("#,###,##0.00"); //for decimal format
		 
		GradeDefinition grades = new GradeDefinition();
		
		
		System.out.println("Midterm GradeComputation");
		
		System.out.print("Attendance: ");grades.setAttendance(Integer.parseInt(reader.nextLine()));
		System.out.print("Exercises: ");grades.setExercise(Integer.parseInt(reader.nextLine()));
		System.out.print("Quizzes: ");grades.setQuizzes(Integer.parseInt(reader.nextLine()));
		System.out.print("Special Project: ");grades.setSpecialProj(Integer.parseInt(reader.nextLine()));
		System.out.print("Midterm Examination: ");grades.setMidtermExamination(Integer.parseInt(reader.nextLine()));
		
		System.out.println();
		
		System.out.println("Total midterm grade: " + df.format(grades.TotalMidterm()));
		System.out.println("Grade equivalent: " + grades.GradeEquivalent(grades.TotalMidterm()));
		
		
	
		 
		 
		
	}

}
