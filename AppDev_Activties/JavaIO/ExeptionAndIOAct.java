package Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class ExeptionAndIOAct {

	public static void main(String[] args) {
	
		BufferedReader reader = null;
		
		int total = 0;
		int totalAPC =0;
		int totalCSB =0;
		int totalMapua =0;
		int totalSTI =0;		
		
		try {
			
			File sourceLocation = new File("d:\\charity.txt");
			
			if(!sourceLocation.exists()) {
				throw new InvalidPathException("The file or path is not found.");
			}
			
				
			reader = new BufferedReader(new FileReader("C:\\Javabuffered\\charity.txt"));
						
			String line = null;
	
			while((line = reader.readLine())!= null) {
		
				 String arr[] = line.split(" ");
		
				 
				 
				 if(Integer.parseInt(arr[2])  < 200 ) {
					throw new InvalidAmountException("Amount is less than 200.");
				 }
				 
			
				 if(arr[3].equals("APC")) totalAPC += Integer.parseInt(arr[2]);
				else if(arr[3].equals("CSB")) totalCSB += Integer.parseInt(arr[2]);
				else if(arr[3].equals("Mapua")) totalMapua += Integer.parseInt(arr[2]);
				else if(arr[3].equals("STI")) totalSTI += Integer.parseInt(arr[2]);
				 
				 total += Integer.parseInt(arr[2]);
			
			}
			
			System.out.print("\n Total From APC: " + totalAPC);
			System.out.print("\n Total From CSB: " + totalCSB);
			System.out.print("\n Total From Mapua: " + totalMapua);
			System.out.print("\n Total From STI: " + totalSTI);	
			System.out.print("\n\n Total Contribution: " + total);
			
			
			
			}catch(InvalidPathException e){
				System.out.println("Invalid Path: " + e.getMessage());
			}catch(InvalidAmountException e){
				System.out.println("Invalid age: " + e.getMessage());
			}catch(FileNotFoundException e) {
				 System.out.println("File Not Found Exception " + e.getMessage());
			}catch(IOException e) {
				 System.out.println("I/O Exception " + e.getMessage());
			}catch(NumberFormatException e) {
				 System.out.println("Invalid Number Format " + e.getMessage());
			}catch(Exception e) {
				 System.out.println("Invalid: " + e.getMessage());
			}
			
	}


}
