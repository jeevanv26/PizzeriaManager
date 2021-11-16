package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * creates the Order object
 * @author Jeevan Vasanthan, Noah Young
 *
 */
public class Order {
    
	private ArrayList<Pizza> pizzas;
	private String phoneNumber;
	public static final double taxRate = 1.06625;
	
	/**
	 * constructor that initializes an arraylist of pizzas and the user id (phone number)
	 * @param phoneNumber phone number of user
	 */
	public Order(String phoneNumber) {
		pizzas = new ArrayList<>();
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * adds pizza to arraylist
	 * @param pizza pizza that is being added
	 */
    public void addP(Pizza pizza){
    	 pizzas.add(pizza);
    }
    
    /**
     * removes pizza from arraylist
     * @param pizza pizza that is being removed
     */
    public void removePizza(Pizza pizza){
        pizzas.remove(pizza);
    }
    
    /**
     * getter method for phone number
     * @return phone number
     */
    public String getNumber() {
    	return phoneNumber;
    }
    
    /**
     * gets total price of an order
     * @return price of order
     */
    public double getTotalPrice() {
    	double total =0 ;
    	for (int x =0; x < pizzas.size(); x++) {
    		total += pizzas.get(x).price();
    	}
    	
    	return total * taxRate;
    }
    
    /**
     * @return string representation of an order
     */
    public String toString() {
    	
    	String order = phoneNumber +" :: ";
    	for (int x =0; x < pizzas.size(); x++) {
    		int y = x+1;
	    	order += "Pizza " + y + ": ";
	    	order += pizzas.get(x).toString();
	    	order += "\n";
	    }
    	DecimalFormat df = new DecimalFormat(".00");
    	return order + "Total: " +df.format(getTotalPrice());
    }
    
    /**
     * getter method for an order
     * @return arraylist of pizzas
     */
    public ArrayList<Pizza> getO(){
    	return pizzas;
    }
  
    
   
}