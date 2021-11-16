package application;

import java.util.ArrayList;

public class Order {
    
	private ArrayList<Pizza> pizzas;
	private String phoneNumber;
	public static final double taxRate = 1.06625;
	
	public Order(String phoneNumber) {
		pizzas = new ArrayList<>();
		this.phoneNumber = phoneNumber;
	}
	
    public void addP(Pizza pizza){
    	 pizzas.add(pizza);
    }
    
    public void removePizza(Pizza pizza){
        pizzas.remove(pizza);
    }
    
    public String getNumber() {
    	return phoneNumber;
    }
    
    public double getTotalPrice() {
    	double total =0 ;
    	for (int x =0; x < pizzas.size(); x++) {
    		total += pizzas.get(x).price();
    	}
    	
    	return total * taxRate;
    }
    
    public String toString() {
    	
    	String order = phoneNumber +" :: ";
    	for (int x =0; x < pizzas.size(); x++) {
    		int y = x+1;
	    	order += "Pizza " + y + ": ";
	    	order += pizzas.get(x).toString();
	    	order += "\n";
	    }
    	
    	return order;
    }
    
    public ArrayList<Pizza> getO(){
    	return pizzas;
    }
  
    
   
}