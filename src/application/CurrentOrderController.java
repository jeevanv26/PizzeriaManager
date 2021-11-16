package application;

import java.text.DecimalFormat;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Creates GUI functionality for when user wants to place an order
 * @author Jeevan Vasanthan, Noah Young
 * 
 */
public class CurrentOrderController {
	
	
	  private static final int NOT_FOUND = -1;


	@FXML
	private Label id;


    @FXML
    private ListView<String> listV;

    @FXML
    private Label total;
    
    private MainController mainController;
    
    /**
     * initializes GUI stage for Current Orders
     */
    public void initialize () {
    	 Platform.runLater(() -> {
    		Order o = mainController.getTracker().get(mainController.find(mainController.getNum()));
    		 id.setText("Current Order : " +mainController.getNum());
    		 DecimalFormat df = new DecimalFormat(".00");
 	    	total.setText("Total: "+df.format(o.getTotalPrice()));
 	    	for (int x =0; x < o.getO().size(); x++) {
 	    		String order = "";
 	    		int y = x+1;
 	    		order += "Pizza " + y + ": ";
 	    		order += o.getO().get(x).toString();
 	    		order += "\n";
 	    		listV.getItems().add(order);
 	    	}
 	    });
    	 
    }

    /**
     * handles event where user clicks on place order button
     * @param event event occurrence
     */
    @FXML
    void placeOrder(ActionEvent event) {
    	Order o = mainController.getTracker().get(mainController.find(mainController.getNum()));
    	if(o.getO().size() == 0) {
    		
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Nothing to order");
    		alert.show();
    		mainController.removeOrder(o);
		}
    	else {
    		mainController.addOrderFinal(o);
    	}
    	Stage stage = (Stage)id.getScene().getWindow();
		stage.close();
    }

    /**
     * handles event where user clicks on remove pizza button
     * @param event event occurrence
     */
    @FXML
    void removePizza(ActionEvent event) {
    		Order o = mainController.getTracker().get(mainController.find(mainController.getNum()));
    		if(o.getO().size() == 0) {
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setContentText("No More Pizzas Remaining");
        		alert.show();
    			
    		}
    		else {
    			if( listV.getSelectionModel().getSelectedIndex() == NOT_FOUND) {
    				Alert alert = new Alert(AlertType.ERROR);
            		alert.setContentText("Nothing Chosen");
            		alert.show();
    			}
    			else {
    				Pizza pizza = o.getO().get(listV.getSelectionModel().getSelectedIndex());
    				o.removePizza(pizza);
    				DecimalFormat df = new DecimalFormat(".00");
    				total.setText(df.format(o.getTotalPrice()));
    				listV.getItems().remove(listV.getSelectionModel().getSelectedIndex());
    			}
    		}
 
    }
    
    /**
     * setter method for main controller
     * @param controller MainController
     */
    public void setMainController(MainController controller) {
    	mainController = controller;
    }
    

}
