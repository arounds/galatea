package view;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineInterface implements View{
	
	public Options createOptions(){
		Options options = new Options();
		options.addOption("h", "help", false, "print help");
		options.addOption("cc","createCandidate", false, "create new candidate");
		
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
