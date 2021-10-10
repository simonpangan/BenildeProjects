
public class Teacher {
	
	
	private String specialization;
	
	public Teacher() {
		
	}
	
	//custom constructor
	public Teacher (String specialization) {
		
		this.specialization = specialization;
	}
	
	
	
	public void field() {
		System.out.print("I am a Teacher");
	}
	
	// method overloading
	public void field(String specialization) {
		System.out.println("I am a " + this.specialization + " Teacher");
		 
	}
	
	public void love() {
		System.out.print("I love teaching");
	}

	public String getSpecialization() {
		return specialization;
	};

}
