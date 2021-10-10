import java.util.Scanner;

public class Employee extends Payroll{

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.displayEmpSalary();
	}
	
	public void displayEmpSalary() {
		float salary = 0;
		float netSalary =0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter salart:  ");
		salary = input.nextFloat();
		// netSalary = computeTaxPay(salary,1); or this.computeTaxPay
		
		netSalary = super.computeTaxPay(salary,1);
		
		System.out.println("Total is :  " + netSalary);
		
		
	}
	
	@Override
	
	public float computeTaxPay(float salary, int taxCode) {
		
		float salaryLessTax = 0;
		
		if(taxCode == 1) {
			salaryLessTax = salary * 0.3f;
		}else if(taxCode == 3) {
			salaryLessTax = salary * 0.15f;
		}
		
		return salaryLessTax;
	}
	
	

}
