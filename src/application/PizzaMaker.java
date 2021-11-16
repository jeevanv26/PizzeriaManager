package application;

/**
 * class that instantiates Pizzas
 * @author Jeevan Vasanthan, Noah Young
 *
 */
public class PizzaMaker {
	
	/**
	 * creates a new pizza of specified flavor
	 * @param flavor flavor of pizza
	 * @return a new pizza instance
	 */
    public static Pizza createPizza(String flavor){
    	
        if(flavor.equals("Hawaiian"))
        	return new Hawaiian();
        else if(flavor.equals("Deluxe"))
        	return new Deluxe();
        else
        	return new Pepperoni();
    }
}