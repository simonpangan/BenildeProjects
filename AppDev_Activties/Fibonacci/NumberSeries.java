package Activity1;

import java.util.Scanner;

public class NumberSeries {

	public static void main(String[] args) {
	    Scanner reader = new Scanner(System.in);
		
		
	    
        System.out.print("Input number of Iteration: ");
        int input = reader.nextInt();
        
        System.out.println("");
 
        int  num1 = 0, num2 = 1;
      
        int sum = 0;
        for (int i = 1; i <= input; i++)
        {
            System.out.print(num1 + "  ");
           
            
            sum += num1;
            
            // 0 + 1 
            // num 1 && num2 
            int next = num1 + num2;
            // next = 1
            // 0 = 1 
            num1 = num2;
            // 1 = 1 
            num2 = next;
            
         
        }
        System.out.println(" ");
        System.out.println("The sum is: " + sum);
   
      

	}

}
