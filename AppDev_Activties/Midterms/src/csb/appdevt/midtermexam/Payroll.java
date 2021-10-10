package csb.appdevt.midtermexam;

public class Payroll {
	
	
	public float computeTaxPay(float salary, int TaxCode) {
		
		float salaryLessTax = 0;
		if(TaxCode == 1) {
			salaryLessTax = salary - (salary * 0.3f);
		}else if(TaxCode == 3) {
			salaryLessTax = salary - (salary * 0.15f);
		}
		
		return salaryLessTax;
	}
	
	
}

