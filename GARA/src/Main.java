

import java.util.Calendar;

import controller.ApplicationController;

import model.document.Document;
import model.person.Candidate;
import model.person.Person.PersonType;
import model.recruitingEvent.RecruitingEvent;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import view.ViewController;

/**
 * Initializes the application controller and starts the application.
 * 
 * @author 	rounds
 * @updated	2013-06-19 12:20 PM		
 */
public class Main {
	
	public static void main(String[] args) {
		ApplicationController applicationController = new ApplicationController();
		ViewController viewController = new ViewController(applicationController);
		applicationController.setViewController(viewController);
		
		applicationController.start();
		
		viewController.printGreeting();
		
		
		
		
		
				

	}
	

}
