package view;

import java.util.Scanner;

public class ScannerInterface implements View{
	
	Scanner scanner = new Scanner(System.in);
	protected enum Action{
		CREATE_CANDIDATE, MENU, EXIT
	}
	
	public ScannerInterface(){}
	
	public void displayMenu(){
		System.out.printf(
				"%n" +
				"+---------------------------------------------------------+%n" +
				"|                          Menu                           |%n" +
				"+---------------------------------------------------------+%n" +
				"| Short Code  | Long Code       | Action                  |%n" +
				"+---------------------------------------------------------+%n" +
				"| cc          | createCandidate | Create a new Candidate  |%n" +
				"| menu        |                 | View Menu               |%n" +
				"| exit        |                 | Exit                    |%n" +
				"+---------------------------------------------------------+%n");
	}
	
	public String getMenuAction(){
		System.out.println("Enter the action you would like to perform: ");
		String action = scanner.nextLine();
		return action;
	}
	
	public Action getActionFromInput(String action){
		if (action.equals("cc") || action.equals("createCandidate")){
			return Action.CREATE_CANDIDATE;
		}
		else if (action.equals("menu")){
			return Action.MENU;
		}
		else if (action.equals("exit")){
			return Action.EXIT;
		}
		else {
			return null;
		}
	}
	
	

}
