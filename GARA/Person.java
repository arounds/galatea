import java.util.GregorianCalendar;

public abstract class Person{
	//Attributes
		//Names
	    protected String id;
		protected String firstName;
		protected String middleName;
		protected String lastName;
		protected String maidenName;
		protected String preferredName;
		//Information
		protected String email;
		protected String phone;
		protected String streetAddress;
		protected String city;
		protected String state;
		protected String zipCode;
		protected String country;
		protected String status;
		protected GregorianCalendar updateTime;
		
	//Constructors
		public Person(String first, String last, GregorianCalendar inputUpdateTime){
			firstName = first;
			lastName = last;
			updateTime = inputUpdateTime;
		}
		
		public Person(String inputFirst, String inputMiddle, String inputLast, 
				String inputMaiden, String inputPreferred, String inputEmail,
				String inputPhone, String inputStreetAddress, String inputCity,
				String inputState, String inputZipCode, String inputCountry, 
				String inputStatus, GregorianCalendar inputUpdateTime){
			firstName = inputFirst;
			middleName = inputMiddle;
			lastName = inputLast;
			maidenName = inputMaiden;
			preferredName = inputPreferred;
			email = inputEmail;
			phone = inputPhone;
			streetAddress = inputStreetAddress;
			city = inputCity;
			state = inputState;
			zipCode = inputZipCode;
			country = inputCountry;
			status = inputStatus;
			updateTime = inputUpdateTime;
		}
		
	//Methods
		public String getFirstName(){
			return firstName;
		}
		
		public void setFirstName(String input){
			firstName = input;
		}
		
		public String getMiddleName(){
			return middleName;
		}
		
		public void setMiddleName(String input){
			middleName = input;
		}
		
		public String getLastName(){
			return lastName;
		}
		
		public void setLastName(String input){
			lastName = input;
		}
		
		public String getMaidenName(){
			return maidenName;
		}
		
		public void setMaidenName(String input){
			maidenName = input;
		}
		
		public String getPreferredName(){
			return preferredName;
		}
		
		public void setPreferredName(String input){
			preferredName = input;
		}
		
			//Information
		public String getEmail(){
			return email;
		}
		
		public void setEmail(String input){
			email = input;
		}
		
		public String getPhone(){
			return phone;
		}
		
		public void setPhone(String input){
			phone = input;
		}
		
		public String getStreetAddress(){
			return streetAddress;
		}
		
		public void setStreetAddress(String input){
			streetAddress = input;
		}
		
		public String getCity(){
			return city;
		}
		
		public void setCity(String input){
			city = input;
		}
		
		public String getState(){
			return state;
		}
		
		public void setState(String input){
			state = input;
		}
	 
		public String getZipCode(){
			return zipCode;
		}
		
		public void setZipCode(String input){
			zipCode = input;
		}
		
		public String getCountry(){
			return country;
		}
		
		public void setCountry(String input){
			country = input;
		}
		
		public String getStatus(){
			return status;
		}
		
		public void setStatus(String input){
			status = input;
		}
		
		public GregorianCalendar getUpdateTime(){
			return updateTime;
		}
}
