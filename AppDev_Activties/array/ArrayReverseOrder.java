import java.util.Scanner;

public class ArrayReverseOrder {

	public static void main(String[] args) {
		
		
		 Scanner reader = new Scanner(System.in);
		 
		int[] inputs = new int[8];
		 
		for (int i = 0; i < 8; i++) {
			 
		       System.out.print("Enter number for element " +  (i + 1) + ": ");
		       inputs[i] = reader.nextInt();
		      
		}
		
		int[] temp = new int[inputs.length];
		int iterate = 0;
		for (int i = 8; i > 0; i--) {
			
			temp[iterate] = inputs[i -1];
			iterate++;
		}
		inputs = temp;
		
		System.out.println("");
		System.out.println("");
		
		System.out.print("Reverse Order: ");
		
		for (int i = 0; i < 8; i++)  System.out.print( inputs[i] +  " ");
	

		
		// Solution 1 
		// use bubble sort
		
		
		/*
		
		for(int x=0; x < inputs.length; x++)
		{
			for(int y=1; y < inputs.length-x; y++)
			{
				if(inputs[y-1] > inputs[y])
				{
					int h = inputs[y-1];
					inputs[y-1] = inputs[y];
					inputs[y] = h;
				}
			}
		}

		System.out.println("");
		System.out.println("");
		System.out.print("2nd Highest number is  " + inputs[inputs.length - 2]);
		
				
	
		*/
		
		//Solution 2
		
		int tempa =0;
		int tempb = 0;
		
		for(int x=0; x < inputs.length; x++)
		{
			
				if(tempa < inputs[x])
				{
					tempa = inputs[x];
				}else if(tempb < inputs[x]) {
					
					tempb = inputs[x];
				}
			
		}

		System.out.println("");
		System.out.println("");
		System.out.print("2nd Highest number is  " + tempb);
		
				
		
		
		
		
	}

}
