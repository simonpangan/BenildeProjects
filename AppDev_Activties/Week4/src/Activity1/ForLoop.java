package Activity1;
import java.util.Scanner;

public class ForLoop {

	public static void main(String[] args) {
		
		
	     Scanner reader = new Scanner(System.in);
	
		
   
        System.out.print("Input number of Iteration: ");
        int input = reader.nextInt();
        
 
   
        int even = 0;
        int odd = 0;
        for (int i = 0; i <= input; i++) {
        	if(i % 2 == 0) {
        		even += i;
        	}else {
        		odd+= i;
        	}

		}
        
        System.out.println("The sum of all even numbers: " + even);
        System.out.println("The sum of all odd numbers: " + odd);
        
	}
}

