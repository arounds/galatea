

import controller.ApplicationController;

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
	

	}
	

}
