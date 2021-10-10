package csb.appdevt.midtermexam;

public class EmployeeNetPay {
	
	private String firstname;
	private String lastname;
	private String department;
	private String employeestatus;
	private int taxcode;
	private int basicsalary;
	
	public EmployeeNetPay() {
		
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmployeestatus() {
		return employeestatus;
	}
	public void setEmployeestatus(String employeestatus) {
		this.employeestatus = employeestatus;
	}
	public int getTaxcode() {
		return taxcode;
	}
	public void setTaxcode(int taxcode) {
		this.taxcode = taxcode;
	}
	public int getBasicsalary() {
		return basicsalary;
	}
	public void setBasicsalary(int basicsalary) {
		this.basicsalary = basicsalary;
	}
	
	
	
	public double netpay() {
		
		double tax =0;
		if(taxcode == 1) {
			 tax = basicsalary/2 * .15;
		}else if (taxcode == 3)  tax = basicsalary/2 * .30;
	
	
		double temp = (basicsalary/2 - tax) - (500+ 400+100) + ( 750 + 3000 + 750);
		return temp;
		
	}

}
