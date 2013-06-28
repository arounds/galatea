package view;

import controller.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ViewController {
	
	//Declarations
	protected ApplicationController applicationController;
	protected View view;
	
	public ViewController(ApplicationController applicationController){
		this.applicationController = applicationController;
	}
	
	public void printGreeting(){
		System.out.printf("Welcome to My Application %n");
	}

	public Boolean doesUserWantToCreateNewPerson() {
		Scanner in = new Scanner(System.in);
		System.out.println("This person already exists. Would you like to create them anyway? (Y/N)");
		String input = null;
	
		input = in.nextLine();
		
		in.close();
		
		Boolean action = null;
		if (input == null){
			System.out.println("Please enter 'Y' or 'N'");
		}
		else if (input.equals("Y")){
			action = true;
		}
		else if (input.equals("N")) {
			action = false;
		}
		else {
			System.out.println("Please enter 'Y' or 'N'");
		}
		
		return action;
		
		
	}
	
	

	
	
}
