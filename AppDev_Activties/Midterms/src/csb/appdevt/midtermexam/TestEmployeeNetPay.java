package csb.appdevt.midtermexam;

import java.util.Scanner;

public class TestEmployeeNetPay {

	public static void main(String[] args) {
		 Scanner reader = new Scanner(System.in);
	
		
			 EmployeeNetPay employee = new EmployeeNetPay();
			 
			   System.out.print("Enter Employee First Name: ");
			   
			   employee.setFirstname(reader.nextLine());	 
			   
			   System.out.print("Enter Employee Last Name: ");
			   employee.setLastname(reader.nextLine());
			   
			   System.out.print("Enter Employee Department: ");
			   employee.setDepartment(reader.nextLine());
			   
			   System.out.print("Enter Employee Status: ");
			   employee.setEmployeestatus(reader.nextLine());
			   
			   
			   System.out.print("Enter Employee Tax Code (1 or 3) : ");
			   employee.setTaxcode(Integer.parseInt(reader.nextLine()));
			   
			   System.out.print("Enter Employee Monthly Basic Salary: ");
			   employee.setBasicsalary(Integer.parseInt(reader.nextLine()));
			   
			   System.out.println("");
			   System.out.println("---Employee Bi-monthly Net Pay---");
			   System.out.println("");
			   System.out.println("First Name: " + employee.getFirstname());
			   System.out.println("Last Name: " + employee.getLastname());
			   System.out.println("Department: " + employee.getDepartment());
			   System.out.println("Status : " + employee.getEmployeestatus());
			   System.out.println("Basic Salary Per payout: " + employee.getBasicsalary() / 2);
			   
			   System.out.println("Total Bi-monthly Net Pay: " + employee.netpay());
			   
		
		 }
		
	}

	

