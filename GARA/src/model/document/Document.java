package model.document;

import model.*;
import model.entity.*;
import model.person.*;
import model.interviewingEvent.*;
import model.recruitingEvent.*;
import model.schedulingEntry.*;

import java.util.Calendar;


public class Document {
	//Attributes
	protected Integer id;
	protected Calendar updateTime;
	protected Calendar insertTime;
	protected String type;
	protected Calendar submitDate;
	protected String title;
	protected String fileLocation;
	
	//Constructors
	public Document (Integer id, Calendar updateTime, Calendar insertTime,  String type, Calendar submitDate, String title, String fileLocation){
		this.id = id;
		this.updateTime = updateTime;
		this.insertTime = insertTime;
		this.type = type;
		this.submitDate = submitDate;
		this.title = title;
		this.fileLocation = fileLocation;
	}
	
	//Methods
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public Calendar getSubmitDate(){
		return submitDate;
	}
	
	public void setSubmitDate(Calendar submitDate){
		this.submitDate = submitDate;
	}
	
	public Calendar getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Calendar updateTime){
		this.updateTime = updateTime;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getFileLocation(){
		return fileLocation;
	}
	
	public void setFileLocation(String fileLocation){
		this.fileLocation = fileLocation;
	}

}
