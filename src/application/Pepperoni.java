package application;
/**
 * Subclass of abstract Pizza class and represents a type of pizza
 * @author Jeevan Vasanthan, Noah Young
 *
 */

public class Pepperoni extends Pizza {
    public static final double smallSize = 8.99;
    public static final double mediumSize = 10.99;
    public static final double largeSize = 12.99;
    public static final double toppingIncrease = 1.49;
    public static final int initial = 1;
 
    /**
     * constructor which sets up default Pepperoni pizza
     */
    public Pepperoni() {
       
        toppings.add(Topping.Pepperoni);
    }
    
    /**
     * calculates price of a pizza
     */
    @Override
	public double price() {
    	 if(size == Size.Small) {
         	if(toppings.size() <= initial)
         		return smallSize;
         	else
         		return ((smallSize + (toppingIncrease * (toppings.size() - initial))));
         }
         else if(size == Size.Medium) {
         	if(toppings.size() <= initial)
         		return mediumSize;
         	else
         		return ((mediumSize + (toppingIncrease * (toppings.size() - initial))));
         }
         else {
           	if(toppings.size() <= initial)
         		return largeSize;
           	else
           		return ((largeSize + (toppingIncrease * (toppings.size() - initial))));
         }
	}
    
    /**
	 * creates a String
	 * @return a String representation of a Pepperoni Pizza
	 */
	@Override
	public String toString() {
		String pizza = "Pepperoni Pizza:: ( Toppings: ";
		for(int x = 0; x < toppings.size(); x++) {
			if(x == toppings.size() -1 )
				pizza += getTopping(toppings.get(x))+") ";
			else
				pizza += getTopping(toppings.get(x))+", ";
		
		}
		pizza = pizza + getSize(size)+ ", Subtotal: " + this.price();
		return pizza;
	}
	
	/**
	 *  reduces complexity of working with pizza sizes
	 * @param sze size of pizza as an enum
	 * @return a String representation of the size of the pizza
	 */
	private String getSize(Size sze) {
		if(sze == Size.Small )
			return "Small";
		else if(sze == Size.Medium)
			return "Medium";
		else
			return "Large";
	}

	/**
	 * reduces complexity of working with pizza toppings
	 * @param topping topping of pizza as an enum
	 * @return a String representation of a topping
	 */
	private String getTopping(Topping topping) {
		if(topping == Topping.Bacon)
			return "Bacon";
		else if(topping == Topping.Cheese)
			return "Cheese";
		else if(topping == Topping.Chicken)
			return "Chicken";
		else if(topping == Topping.Garlic)
			return "Garlic";
		else if(topping == Topping.Ham)
			return "Ham";
		else if(topping == Topping.Mushroom)
			return "Mushroom";
		else if(topping == Topping.Onion)
			return "Onion";
		else if(topping == Topping.Pepperoni)
			return "Pepperoni";
		else if(topping == Topping.Pineapple)
			return "Pineapple";
		else if(topping == Topping.Sausage)
			return "Sausage";
		else 
			return "Tomato";
	}

	
    
 
}
