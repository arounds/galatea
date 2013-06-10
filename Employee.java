import java.util.GregorianCalendar;


public class Employee extends Person{
	//Attributes
		protected String contractFileId;
		
	//Constructors
	Employee(String first, String last, GregorianCalendar update){
		super(first, last, update);
	}
	
	Employee(String inputFirst, String inputMiddle, String inputLast, 
			String inputMaiden, String inputPreferred, String inputEmail,
			String inputPhone, String inputStreetAddress, String inputCity,
			String inputState, String inputZipCode, String inputCountry, 
			String inputStatus, GregorianCalendar inputUpdateTime){
		super(inputFirst, inputMiddle, inputLast, inputMaiden, inputPreferred,
				inputEmail, inputPhone, inputStreetAddress, inputCity,
				inputState, inputZipCode, inputCountry, inputStatus, 
				inputUpdateTime);
	}
	//Methods
	

}
