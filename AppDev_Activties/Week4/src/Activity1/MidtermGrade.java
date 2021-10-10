package Activity1;

import java.util.Scanner;

public class MidtermGrade {
	
	public static void main(String[] args) {
	    Scanner reader = new Scanner(System.in);
		
	
      
    
        
		
	    
        System.out.print("Input Class Participation: ");
        int classParticipation = reader.nextInt();
        System.out.print("Input Exercise: ");
        int exercises = reader.nextInt();
        System.out.print("Input Quizzes: ");
        int quizzes = reader.nextInt();
        System.out.print("Input Special Project: ");
        int specialProject = reader.nextInt();
        System.out.print("Input Midterm Examination: ");
        int midtermExamination = reader.nextInt();
        
    
        double sum = ((classParticipation * .10) + 
        		(exercises * .20) + 
        		(quizzes * .25) + 
        		(specialProject * .20) + 
        		(midtermExamination * .25));
  
        System.out.println(" ");
        System.out.println("The sum is: " + sum);
   
      

	}

}
