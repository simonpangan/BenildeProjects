package Activity1;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		
	     Scanner reader = new Scanner(System.in);
		first: 
		for (;;) {
   
        System.out.print("Enter First number: ");
        double first = reader.nextDouble();
        
        
        System.out.print("Enter Second number: ");
        double second = reader.nextDouble();
        
        System.out.println("");
        System.out.println("Select Operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("");
        
        
        
        System.out.print("Enter an operator (1,2,3,4): ");
        int operator = reader.nextInt();

   
        	if (second == 0 && operator == 4) {
        	   System.out.println("Division by 0 is not allowed");    
       		}else {
       			double result;
       	  	   switch(operator)
               {
                   case 1:
                       result = first + second;
                       break;

                   case 2:
                       result = first - second;
                       break;

                   case 3:
                       result = first * second;
                       break;

                   case 4:
                       result = first / second;
                       break;

                 
                   default:
                       System.out.printf("Error! operator is not correct");
                       return;
               }
       	
             System.out.println("The answer is: " +  result);
       		}
        
		
	      System.out.print("Would you like to try Again (Y/N) ?");
	       String input = reader.next();
	       
	       
	    for(;;){
	    	  if(input.equals("Y") ||(input.equals("N"))) {
		    	  if(input.equals("N"))
		          {
		          	  System.out.println("Thank you for using this application.");
		          	break first ;
		          }else {
		        	  continue first;
		          }
	    	  }else {
	    		  System.out.println("Input must be Y or N only");
	    	  }
	    	  
		    	 System.out.print("Would you like to try Again (Y/N) ?");
		 	     input = reader.next();
	    	}
	    
	   
        
	}

}
}

