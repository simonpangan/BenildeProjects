package classdesign2;

public class GradeDefinition implements InterfaceGrade{

	
	private int Attendance;
	private int Exercise;
	private int Quizzes;
	private int SpecialProj;
	private int MidtermExamination;
	
	
	@Override
	public double TotalMidterm() {
		
		double average = (
				(Attendance  * .10)
				+ (Exercise * .20)
				+ (Quizzes * .25)
				+ (SpecialProj * .20)
				+ (MidtermExamination * .25)
						);
		
		return average;
	}

	@Override
	public double GradeEquivalent(double equi) {
		double temp =0;
	
		if(equi >= 70 && equi <= 74) temp = 1.0;
		else if(equi >= 75 && equi <= 79) temp = 1.5;
		else if(equi >= 80 && equi <= 84) temp = 2.0;
		else if(equi >= 85 && equi <= 88) temp = 2.5;
		else if(equi >= 89 && equi <= 92) temp = 3.0;
		else if(equi >= 93 && equi <= 96) temp = 3.5;
		else if(equi >= 97 && equi <= 100) temp = 4.0;
		return temp;
	}

	public int getAttendance() {
		return Attendance;
	}

	public void setAttendance(int attendance) {
		Attendance = attendance;
	}

	public int getExercise() {
		return Exercise;
	}

	public void setExercise(int exercise) {
		Exercise = exercise;
	}

	public int getQuizzes() {
		return Quizzes;
	}

	public void setQuizzes(int quizzes) {
		Quizzes = quizzes;
	}

	public int getSpecialProj() {
		return SpecialProj;
	}

	public void setSpecialProj(int specialProj) {
		SpecialProj = specialProj;
	}

	public int getMidtermExamination() {
		return MidtermExamination;
	}

	public void setMidtermExamination(int midtermExamination) {
		MidtermExamination = midtermExamination;
	}
	
	

}
