import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;



public class View{
	public static void main(String[] args) throws SQLException, IOException, ParseException{
		//Declarations
		Database.registerDriver(); //Must happen, but only happens once per application.
		String action = "0";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Greetings
		printGreeting();
		printMenu(); //There are currently options 1-6
		
		//Call proper program
		action = in.readLine();
		
		switch (action){
			case "exit":
				System.out.printf("%nThanks!");
				System.exit(0);
				break;
			case "menu":
				printMenu();
				break;
			case "1":
				System.out.printf("%nView Scheduling Entry"); //for debugging
				getSchedulingEntries(in);
				printMenu();
				break;
			case "2":
				System.out.printf("%nView Candidate"); //for debugging
				//getCandidate(in);
				printMenu();
				break;
			case "3":
				System.out.printf("%nEnter Candidate");  //for debugging
				//enterCandidate(in);
				printMenu();
				break;
			case "4":
				System.out.printf("%nAdd Recruiting Event"); //for debugging
				//enterRecruitingEvent(in);
				printMenu();
				break;
			case "5":
				System.out.printf("%nAdd Interviewing Event"); //for debugging
				//enterInterviewingEvent(in);
				printMenu();
				break;
			case "6":
				System.out.printf("%nAdd Employee"); //for debugging
				//enterEmployee(in);
				printMenu();
				break;
			default: //In case the user enters something invalid
				System.out.printf("%nSorry, I didn't catch that...Try again."); 
				printMenu();
		}
		
		
	}
	
	//Methods
	
	protected static void printGreeting(){
		System.out.printf("Welcome to My Application %n");
	}
	
	protected static void printMenu(){
		System.out.printf("%n" +
				"+----------------------------------+ %n" +
				"|              Menu                | %n" +
				"+----------------------------------+ %n" +
				"| Here are some of your options:   | %n" +
				"|    1: View Pipeline Candidates   | %n" +
				"|    2: View Single Candidate      | %n" +
				"|    3: Add New Candidate          | %n" +
				"|    4: Add New Recruiting Event   | %n" +
				"|    5: Add New Interviewing Event | %n" +
				"|    6: Add New Employee           | %n" +
				"| Other options are:               | %n" +
				"|    -- exit                       | %n" +
				"|    -- menu                       | %n" +
				"+----------------------------------+ %n" +
				"Please enter what you would like to do: %n");
	}
	
    protected static void getSchedulingEntries(BufferedReader in) throws ParseException, SQLException, IOException{
    	LinkedList<SchedulingEntry> schedulingEntries = Database.callSelectSchedulingEntry();
    	String action;
    	
    	System.out.printf(
    			"%nYou can organize the Pipeline candidates on:" +
    			"     * candidateFirstName %n" +
    			"     * candidateLastName %n" +
    			"     * currentInterviewType %n" +
    			"     * currentInterviewStatus %n" +
    			"     * currentInterviewDateTime %n" +
    			"     * currentInterviewUpdateTime %n" +
    			"     * currentInterviewerFirstName %n" +
    			"     * currentInterviewerLastName %n");
    	System.out.printf("%nOrganize entries on: ");
    	action = in.readLine();
    	//Print this list to the screen, and organize it(?)
    }
	
	
}
