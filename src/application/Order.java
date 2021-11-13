package application;

import java.util.ArrayList;

public class Order {
    
	private ArrayList<Pizza> pizzas;
	public String phoneNumber;
	
	public Order(String phoneNumber) {
		pizzas = new ArrayList<>();
		this.phoneNumber = phoneNumber;
	}
	
    public void addPizza(String flavor){
    	 pizzas.add(PizzaMaker.createPizza(flavor));
    }
    
    public void removePizza(Pizza pizza){
        pizzas.remove(pizza);
    }
    
    public boolean isValid(){
    	
    	if(phoneNumber.length() != 10)
    		return false;
    	try {
    		Integer.parseInt(phoneNumber);
    	}
    	catch(NumberFormatException e) {
    		return false;
    	}
    	
    	return true;
    }
    
   
}