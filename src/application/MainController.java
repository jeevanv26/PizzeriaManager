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

public class MainController {
	
	private String f;
	private ArrayList<Order> tracking = new ArrayList<>();
	private ArrayList<Order> allOrders = new ArrayList<>();
	public static final int NOT_FOUND = -1;

    @FXML
    private TextField number;
    
    public MainController() {
 
    }
   
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
 
    
  public boolean isValid(String num){
    	
    	if(num.length() != 10)
    		return false;
    	
    	for(int x = 0; x < num.length(); x++) {
    		if( Character.isDigit(num.charAt(x)) == false)
    			return false;
    	}
    	
    	return true;
    }
  
  public String getFlavor() {
	  return f;
  }
  
 public ArrayList<Order> getTracker(){
	 return tracking;
 }
 
 public ArrayList<Order> getOrders(){
	 return allOrders;
 }
 
 public void addOrder(Order order) {
	 tracking.add(order);
 }
 

 
 public int find(String number) {
	 for(int x = 0; x < tracking.size(); x++) {
 		if(number.equals(tracking.get(x).getNumber()))
 			return x;
 	}
 	return -1;
 }
 
 public int findInFinal(String number) {
	 for(int x = 0; x < allOrders.size(); x++) {
 		if(number.equals(allOrders.get(x).getNumber()))
 			return x;
 	}
 	return -1;
 }
 
 public void addOrderFinal(Order order) {
	 allOrders.add(order);
 }
 
 public void removeOrderFinal(Order order) {
	 allOrders.remove(order);
 }
 
 public void removeOrder(Order order) {
	 tracking.remove(order);
 }
 
 
 
 public String getNum() {
	 return number.getText();
 }

}

