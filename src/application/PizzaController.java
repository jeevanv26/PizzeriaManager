package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Creates GUI functionality for creating a pizza
 * @author Jeevan Vasanthan, Noah Young
 *
 */
public class PizzaController {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Topping> list;

    @FXML
    private Label p;

    @FXML
    private ToggleGroup s;

    @FXML
    private ComboBox<Topping> t;

    @FXML
    private Label type;
    
    private MainController mainController;
    
    private Pizza pizza;
    
    public static final int maxToppings = 7;
    
    /**
     * constructor of class
     */
    public PizzaController() {
  
    }
    
    /**
     * initializes the stage and sets default values
     */
    @FXML
    public void initialize() {
    	
    	 Platform.runLater(() -> {
    		 
    	    	Image image;
    	    	pizza = PizzaMaker.createPizza(mainController.getFlavor());
    	        for(Topping tp : pizza.toppings) {
    	        	list.getItems().add(tp);
    	        }
    	        
    	        ObservableList<Topping> ol = FXCollections.observableArrayList(Topping.Bacon,Topping.Cheese,Topping.Chicken,Topping.Garlic,Topping.Ham,Topping.Mushroom,Topping.Onion,Topping.Pepperoni,Topping.Pineapple,Topping.Sausage,Topping.Tomato);
    	        t.setItems(ol);
    	        
    	    	if(mainController.getFlavor().equals("Hawaiian")){
    	    		 image = new Image("hawaiian.jpg");
    	    		 type.setText("Hawaiian Pizza");
    	    	}
    	    	else if(mainController.getFlavor().equals("Deluxe")){
    	    		 image = new Image("deluxe.jpg");
    	    		 type.setText("Deluxe Pizza");
    	    	}
    	    	else {
    	    		 image = new Image("pepperoni.jpg");
    	    		 type.setText("Pepperoni Pizza");
    	    	}
    	    	imageView.setImage(image);
    	    });

    }
    
    /**
     * handles event where user wants to add a pizza
     * @param event event occurrence
     */
    @FXML
    void addPizza(ActionEvent event) {
    	
    	if(s.getSelectedToggle() == null) {
    		
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText(" Please input pizza size");
    		alert.show();
    	}
    	else {
    		if(orderStarted(mainController.getNum()) == false)
    		{
    			Order o = new Order(mainController.getNum());
    			o.addP(pizza);
    			mainController.addOrder(o);
    		}
    		
    		else {
    			Order o = mainController.getTracker().get(mainController.find(mainController.getNum()));
    			o.addP(pizza);
    			mainController.addOrder(o);
    		}
    		Stage stage = (Stage)p.getScene().getWindow();
    		stage.close();
    	}
    }
    
    /**
     * handles event where user wants to add topping
     * @param event event occurrence
     */
    @FXML
    void addT(ActionEvent event) {
    	ObservableList<Topping> tp= list.getItems();
    	if(pizza.toppings.size() == 7)
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Maximum toppings reached");
    		alert.show();
    	}
    	else if(!tp.contains(t.getValue())) {
    		pizza.toppings.add(t.getValue());
    		list.getItems().add(t.getValue());
    		if(s.getSelectedToggle() !=null ) {
    			DecimalFormat df = new DecimalFormat(".00");
    			p.setText(df.format(pizza.price()));
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Topping already added");
    		alert.show();
    	}
    }
    
    /**
     * handles event where user wants to remove topping
     * @param event event occurrence
     */
    @FXML
    void removeT(ActionEvent event) {
    	if(pizza.toppings.size() == 0)
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("No toppings left");
    		alert.show();
    	}
    	else {
    		if(list.getSelectionModel().getSelectedIndex() == -1) {
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setContentText("Nothing Selected");
        		alert.show();
    		}
    		else {
    			pizza.toppings.remove(list.getSelectionModel().getSelectedIndex());
    			list.getItems().remove(list.getSelectionModel().getSelectedIndex());
    		
    			if(s.getSelectedToggle() != null) {
    				DecimalFormat df = new DecimalFormat(".00");
    				p.setText(df.format(pizza.price()));
    			}
    		}
	        
    	}
    }
    
    /**
     * handles event where user clicks on radio buttons
     * @param event event occurrence
     */
    @FXML
    void updatePrice(ActionEvent event) {
    	RadioButton button = (RadioButton)s.getSelectedToggle();
    	if(button.getText().equals("Small"))
    		pizza.size = Size.Small;
    	else if(button.getText().equals("Medium"))
    		pizza.size = Size.Medium;
    	else
    		pizza.size = Size.Large;
    	DecimalFormat df = new DecimalFormat(".00");
		p.setText(df.format(pizza.price()));
    }
    

    /**
     * setter method for controller
     * @param controller main controller
     */
    public void setMainController(MainController controller) {
    	mainController = controller;
    }
    
    /**
     * checks if a specific order has been started
     * @param number phone number of user
     * @return true if order has aleady started, false otherwise
     */
    public boolean orderStarted(String number) {
    	for(int x = 0; x < mainController.getTracker().size(); x++) {
    		if(number.equals(mainController.getTracker().get(x).getNumber()))
    			return true;
    	}
    	return false;
    }

}