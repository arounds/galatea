import java.util.Calendar;
import java.util.List;



public class Employee extends Person{
	//Attributes
	protected List<RecruitingEvent> listOfRecruitingEvents;
	protected List<InterviewingEvent> listOfInterviewingEvents;
	protected Document contract;
		
	//Constructors
	Employee(String inputFirst, String inputMiddle, String inputLast, 
			String inputMaiden, String inputPreferred, String inputEmail,
			String inputPhone, String inputStreetAddress, String inputCity,
			String inputState, String inputZipCode, String inputCountry, 
			String inputStatus, Calendar inputUpdateTime){
		super(inputFirst, inputMiddle, inputLast, inputMaiden, inputPreferred,
				inputEmail, inputPhone, inputStreetAddress, inputCity,
				inputState, inputZipCode, inputCountry, inputStatus, 
				inputUpdateTime);
		this.listOfRecruitingEvents = null;
		this.listOfInterviewingEvents = null;
		this.contract = null;
	}
	//Methods
	public List<RecruitingEvent> getlistOfRecruitingEvents(){
		return listOfRecruitingEvents;
	}
	
	public void addRecruitingEvent(RecruitingEvent event){
		listOfRecruitingEvents.add(event);
	}
	
	public List<InterviewingEvent> getlistOfInterviewingEvents(){
		return listOfInterviewingEvents;
	}
	
	public void addInterviewingEvent(InterviewingEvent event){
		listOfInterviewingEvents.add(event);
	}
	
	public Document getContract(){
		return contract;
	}
	
	public void setContract(Document contract){
		this.contract = contract;
	}

}
