package view;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineControls {
	
	protected OptionGroup options_createPerson;
	
	public Options createOptions(){
		Options options = new Options();
		options.addOption("h", "help", false, "print help")
		.addOption("cc","createCandidate", false, "create new candidate");
		
		return options;
	}
	
	public Options createOptions_createPerson(){
		Options options = new Options();
		options.addOption("fn", "firstName", true, "person first name")
		.addOption("midn", "middleName", false, "person middle name")
		.addOption("ln", "lastName", true, "person last name")
		.addOption("maidn", "maidenName", false, "person maiden name")
		.addOption("pn", "preferredName", false, "person preferred name")
		.addOption("e", "email", true, "person email")
		.addOption("ph", "phone", false, "person phone number")
		.addOption("st", "streetAddress", false, "person's street address")
		.addOption("c", "city", false, "person's city")
		.addOption("state", false, "person's state")
		.addOption("z", "zipCode", false, "person's zip code")
		.addOption("cou", "country", false, "person's country")
		.addOption("status", false, "person's status")
		;
		
		return options;
	}
	
	private static void usage(Options options){
		// Use the inbuilt formatter class
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "Main", options );
	}
	
	public void getUserInput(Options options, String[] args){
		
		CommandLineParser parser = new BasicParser();
		CommandLine cmd;
		try{
			cmd = parser.parse(options, args);
		}catch (ParseException pe){ 
			usage(options); 
			return; 
		}
		
		if (cmd.hasOption("h")){
			System.out.println("Success");
		}
	}


}
