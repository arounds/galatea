package controller;

import model.document.Document;
import model.recruitingEvent.RecruitingEvent;
import database.DatabaseManager;
import view.ViewController;

public class ApplicationController {
	
	protected ViewController viewController;
	protected FactoryManager factoryManager;
	protected DatabaseManager databaseManager;

	
	public ApplicationController(){
		this.viewController = null;
		this.factoryManager = null;
		this.databaseManager = null;

	}
	
	public void start(){
		//register driver
		//assign viewcontroller and factory manager etc to everyone
		//start command line view
	}
	
	public Response handleRequest(Request request){
		//look at request's message and call the appropriate method
	}
	
	public ViewController getViewController(){
		return viewController;
	}
	public void setViewController(ViewController viewController){
		this.viewController = viewController;
	}
	public FactoryManager getFactoryManager(){
		return factoryManager;
	}
	public void setFactoryManager(FactoryManager factoryManager){
		this.factoryManager = factoryManager;
	}
	public DatabaseManager getDatabaseManager(){
		return databaseManager;
	}
	public void setDatabaseManager(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}
	
	public void newCandidate(/* some input */){
		RecruitingEvent recruitingEvent = getRecruitingEvent();
		Document resume = getDocument();
		PersonResponse candidateResponse = factoryManager.manageCreateNewCandidate(false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		if (candidateResponse.getMessage().equals(null)){
			//do something
		}
	
	}

	private Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	private RecruitingEvent getRecruitingEvent() {
		// TODO Auto-generated method stub
		return null;
	}

}
