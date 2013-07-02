package controller;

import java.util.List;

import model.person.Person;

public class PersonResponse extends Response{
	protected List<? extends Person> people;
	
	public PersonResponse(){
		super();
		this.people = null;
	}
	
	public PersonResponse(List<? extends Person> people){
		super();
		this.people = people;
	}
	
	public PersonResponse(MessageType message){
		super(message);
	}
	
	public PersonResponse(List<? extends Person> people, MessageType message){
		super(message);
		this.people = people;
	}
	

}
