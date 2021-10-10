
public class MathematicsTeacher extends Teacher{
	
	
	
	MathematicsTeacher(String specialization){
		super(specialization);
	}
	
	public static void main(String[] args) {
		
		MathematicsTeacher PT = new MathematicsTeacher("Mathematics");	
		PT.MathTeach();
		PT.love();
		PT.topic();
		
		
	}
	
	//inherit all parent method
	public void MathTeach() {
		field(getSpecialization());
	}
	
	
	@Override
	public void love() {
		System.out.println("I love solving");
	};
	
	//mathematics techer own methods
	public void topic() {
		System.out.println("I teach calculus, statistics, physics and algebra");
	};

}
