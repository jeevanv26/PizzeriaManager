package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class StoreOrderController {

    private static final int NOT_FOUND = -1;

	@FXML
    private ListView<String> listView;
    
    private MainController mainController;
    
    
    public void initialize() {
 
    	Platform.runLater(() -> {
    	for(int x = 0; x < mainController.getOrders().size(); x++) {
    		String order = mainController.getOrders().get(x).toString();
    		listView.getItems().add(order);
    	}
    });
    }

    @FXML
    void cancelOrder(ActionEvent event) {
    	if(mainController.getOrders().size() == 0) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("No more orders remaining");
    		alert.show();
    	}
    	else {
    		if( listView.getSelectionModel().getSelectedIndex() == NOT_FOUND) {
				Alert alert = new Alert(AlertType.ERROR);
        		alert.setContentText("Nothing Chosen");
        		alert.show();
			}
    		else {
    		Order order= mainController.getOrders().get(listView.getSelectionModel().getSelectedIndex());
    		mainController.removeOrderFinal(order);
    		mainController.removeOrder(order);
    		listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
    		}
    	}
    }

    @FXML
    void exportOrder(ActionEvent event) {
    	StoreOrders storeOrders = new StoreOrders(mainController.getOrders());
    	storeOrders.export();
    }
    
    public void setMainController(MainController controller) {
    	mainController = controller;
    }

}
