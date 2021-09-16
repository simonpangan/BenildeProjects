package Helper;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Helper {

	public static String firstChoiceToText(int inputNumber) {

		if (inputNumber == 1)
			return "Login";
		else if (inputNumber == 2)
			return "Create";
		else if (inputNumber == 0)
			return "Quit";

		return null;

	}

	public static String secondChoiceToText(int inputNumber) {

		if (inputNumber == 1)
			return "Balance Inquiry";
		else if (inputNumber == 2)
			return "Cash Deposit";
		else if (inputNumber == 3)
			return "Cash Withdrawal";
		else if (inputNumber == 4)
			return "View Transanction History";
		else if (inputNumber == 5)
			return "View Profile";
		else if (inputNumber == 0)
			return "Logout";

		return null; // return null if selecteed choice is out of range

	}

	public static int moneyEquivalent(int inputNumber) {
		
		
			if(inputNumber == 1) return 100;
		else if(inputNumber == 2) return 200;
		else if(inputNumber == 3) return 400;
		else if(inputNumber == 4) return 500;
		else if(inputNumber == 5) return 1000;
		else if(inputNumber == 6) return 2000;
		else if(inputNumber == 7) return 4000;
		else if(inputNumber == 8) return 8000;
		else if(inputNumber == 9) return 10000;
		else if(inputNumber == 10) return 20000;
		
		return 0; // return null if selecteed choice is out of range

	}

	public static String getDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();

		return df.format(calobj.getTime());
	}

}
