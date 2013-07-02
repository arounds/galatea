package controller;

public class Response {
	
	protected String message;
	
	public Response(){
		message = "default";
	}
	
	public Response(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
