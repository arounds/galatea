package controller;

public class Response {
	
	enum MessageType{
		SUCCESS, 
		ALREADY_EXISTS, 
		FOREIGN_KEY_ERROR, 
		TOO_MANY_RETURNED_ROWS, 
		DOES_NOT_EXIST, 
		CONNECTION_ERROR
	}
	
	protected MessageType message;
	
	public Response(){
		message = MessageType.SUCCESS;
	}
	
	public Response(MessageType message){
		this.message = message;
	}

	public String getMessage() {
		return message.toString();
	}
	public void setMessage(MessageType message) {
		this.message = message;
	}

}
