import java.util.GregorianCalendar;

public class Entity {
	//Attributes
		protected String name;
		protected String type;
		protected String website;
		protected String contactPersonFirstName;
		protected String contactPersonLastName;
		protected String contactPersonEmail;
		protected String contactPersonPhone;
		protected String streetAddress;
		protected String city;
		protected String state;
		protected String zipCode;
		protected String country;
		protected String status;
		protected GregorianCalendar updateTime;
	
	//Constructors
		public Entity(String inputName, String inputType, String inputWebsite, 
				String inputContactPersonFirstName, 
				String inputContactPersonLastName,
				String inputContactPersonEmail, 
				String inputContactPersonPhone, 
				String inputStreetAddress, String inputCity, 
				String inputState, String inputZipCode, String inputCountry,
				String inputStatus, GregorianCalendar inputUpdateTime){
			name = inputName;
			type = inputType;
			website = inputWebsite;
			contactPersonFirstName = inputContactPersonFirstName;
			contactPersonLastName = inputContactPersonLastName;
			contactPersonEmail = inputContactPersonEmail;
			contactPersonPhone = inputContactPersonPhone;
			streetAddress = inputStreetAddress;
			city = inputCity;
			state = inputState;
			zipCode = inputZipCode;
			country = inputCountry;
			status = inputStatus;
			updateTime = inputUpdateTime;
		}
		
	//Methods
		public String getName(){
			return name;
		}
		
		public void setName(String x){
			name = x;
		}
		
		public String getType(){
			return type;
		}
		
		public void setType(String x){
			type = x;
		}
		
		public String getWebsite(){
			return website;
		}
		
		public void setWebsite(String x){
			website = x;
		}
		
		public String getContactPersonFirstName(){
			return contactPersonFirstName;
		}
		
		public void setContactPersonFirstName(String x){
			contactPersonFirstName = x;
		}
		
		public String getContactPersonLastName(){
			return contactPersonLastName;
		}
		
		public void setContactPersonLastName(String x){
			contactPersonLastName = x;
		}
		
		public String getContactPersonEmail(){
			return contactPersonEmail;
		}
		
		public void setContactPersonEmail(String x){
			contactPersonEmail = x;
		}
		
		public String getContactPersonPhone(){
			return contactPersonPhone;
		}
		
		public void setContactPersonPhone(String x){
			contactPersonPhone = x;
		}
		
		public String getStreetAddress(){
			return streetAddress;
		}
		
		public void setStreetAddress(String x){
			streetAddress = x;
		}
		
		public String getCity(){
			return city;
		}
		
		public void setCity(String x){
			city = x;
		}
		
		public String getState(){
			return state;
		}
		
		public void setState(String x){
			state = x;
		}
	 
		public String getZipCode(){
			return zipCode;
		}
		
		public void setZipCode(String x){
			zipCode = x;
		}
		
		public String getCountry(){
			return country;
		}
		
		public void setCountry(String x){
			country = x;
		}
		
		public String getStatus(){
			return status;
		}
		
		public void setStatus(String x){
			status = x;
		}
		
		public GregorianCalendar getUpdateTime(){
			return updateTime;
		}

}
