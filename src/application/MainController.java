package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Creates GUI functionality for operating the main page
 * @author Jeevan Vasanthan, Noah Young
 *
 */
public class MainController {
	
	private String f;
	private ArrayList<Order> tracking = new ArrayList<>();
	private ArrayList<Order> allOrders = new ArrayList<>();
	public static final int NOT_FOUND = -1;

    @FXML
    private TextField number;
    
    public MainController() {
 
    }
   
    /**
     * handles event when user wants to create a pizza
     * @param event  event occurrence
     */
    @FXML
    void newStage(ActionEvent event) {
    	
    	MenuItem menuitem = (MenuItem) event.getSource();
    	f = menuitem.getText();
    	
    	if(isValid(number.getText()) && findInFinal(number.getText()) != NOT_FOUND) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("User Already Ordered");
    		alert.show();
    	}
    	else if(isValid(number.getText())) {
    	
    		try {
    			Stage stage = new Stage();
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaView.fxml"));
    			BorderPane root = loader.load();
    	    	PizzaController pizzaController = loader.getController();
    	    	pizzaController.setMainController(this);
    			Scene scene = new Scene(root,700,400);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			stage.setScene(scene);
    			stage.show();
    		} 
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Phone Number");
    		alert.show();
    	}
    		
    }

    /**
     * handles event where user wants to see their current order
     * @param event event occurrence
     */
    @FXML
    void newStage2(ActionEvent event) {
    	
    	if(isValid(number.getText()) && find(number.getText()) == NOT_FOUND) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("No Order Currently Available");
    		alert.show();
    	}
    	else if (findInFinal(number.getText()) != NOT_FOUND) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Order Already Made");
    		alert.show();
    	}
    	else if(isValid(number.getText())) {
        	
    		try {
    			Stage stage = new Stage();
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentView.fxml"));
    			BorderPane root = loader.load();
    	    	CurrentOrderController orderController = loader.getController();
    	    	orderController.setMainController(this);
    			Scene scene = new Scene(root,700,400);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			stage.setScene(scene);
    			stage.show();
    		} 
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Phone Number");
    		alert.show();
    	}
    }

    /**
     * handles event where user want to see store orders
     * @param event event occurrence
     */
    @FXML
    void newStage3(ActionEvent event) {
    	 
    	if(allOrders.size() == 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("No Store Orders");
    		alert.show();
    	}
    	else {
    	try {
    		Stage stage = new Stage();
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrderView.fxml"));
			BorderPane root = loader.load();
	    	StoreOrderController oController = loader.getController();
	    	oController.setMainController(this);
    		Scene scene = new Scene(root,700,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		stage.setScene(scene);
    		stage.show();
    	} 
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	}
    }
 
    /**
     * checks validity of phone number
     * @param num phone number that user inputs
     * @return true if phone number is valid, false if otherwise
     */
  public boolean isValid(String num){
    	
    	if(num.length() != 10)
    		return false;
    	
    	for(int x = 0; x < num.length(); x++) {
    		if( Character.isDigit(num.charAt(x)) == false)
    			return false;
    	}
    	
    	return true;
    }
  
  /**
   * getter method for pizza flavor
   * @return the flavor of the pizza that the user wants to create
   */
  public String getFlavor() {
	  return f;
  }
  
  /**
   * getter method for tracker array list
   * @return arraylist that tracks if an order has been started or not
   */
 public ArrayList<Order> getTracker(){
	 return tracking;
 }
 
 /**
  * getter method for allOrders array list
  * @return arraylist that stores started orders
  */
 public ArrayList<Order> getOrders(){
	 return allOrders;
 }
 
 /**
  * updates tracking arraylist
  * @param order order that is being made
  */
 public void addOrder(Order order) {
	 tracking.add(order);
 }
 

 /**
  * determines if an order has already started
  * @param number number that is being searched
  * @return the index of the order if it exists, -1 if it doesn't
  */
 public int find(String number) {
	 for(int x = 0; x < tracking.size(); x++) {
 		if(number.equals(tracking.get(x).getNumber()))
 			return x;
 	}
 	return -1;
 }
 
 /**
  * determines if an order has already been made
  * @param number number that is being searched
  * @return the index of the order if it exists, -1 if it doesn't
  */
 public int findInFinal(String number) {
	 for(int x = 0; x < allOrders.size(); x++) {
 		if(number.equals(allOrders.get(x).getNumber()))
 			return x;
 	}
 	return -1;
 }
 
 /**
  * updates allOrder arraylist
  * @param order order that is being made
  */
 public void addOrderFinal(Order order) {
	 allOrders.add(order);
 }
 
 /**
  * updates allOrder arraylist
  * @param order order that is being removed
  */
 public void removeOrderFinal(Order order) {
	 allOrders.remove(order);
 }
 
 /**
  * updates tracking arraylist
  * @param order order that is being removed
  */
 public void removeOrder(Order order) {
	 tracking.remove(order);
 }
 
 
 /**
  * getter method for phone number
  * @return the phone number as a string
  */
 public String getNum() {
	 return number.getText();
 }

}

