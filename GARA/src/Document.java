import java.util.Calendar;


public class Document {
	//Attributes
	protected String title;
	protected Calendar submitDate;
	protected Calendar updateTime;
	protected String type;
	protected String fileId;
	
	//Constructors
	public Document (String title, Calendar submitDate, Calendar updateTime, String type, String fileId){
		this.title = title;
		this.submitDate = submitDate;
		this.updateTime = updateTime;
		this.type = type;
		this.fileId = fileId;
	}
	
	//Methods
	
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
	
	public String getFileId(){
		return fileId;
	}
	
	public void setFileId(String fileId){
		this.fileId = fileId;
	}

}
