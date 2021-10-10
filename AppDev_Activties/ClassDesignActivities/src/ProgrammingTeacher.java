		
public class ProgrammingTeacher extends Teacher{

	ProgrammingTeacher(){
		
	}
	
	ProgrammingTeacher(String specialization){
		super(specialization);
	}
	
	public static void main(String[] args) {
		
		ProgrammingTeacher PT = new ProgrammingTeacher("Programming");	
		PT.ProgTeach();
		PT.love();
		PT.knowlanguage();
		
	}
	
	//inherit all parent method
	public void ProgTeach() {
		field(getSpecialization());
	}
	
	//overide love parent method by adding own love 
	
	@Override
	public void love() {
		System.out.println("I love coding");
	};
	
	//programmign teach own method
	public void knowlanguage() {
		System.out.println("I know c#, Java and PHP");
	};
	
	
	
}
