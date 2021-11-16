package application;


public class Hawaiian extends Pizza{
	
    public static final double smallSize = 10.99;
    public static final double mediumSize = 12.99;
    public static final double largeSize = 14.99;
    public static final double toppingIncrease = 1.49;
    public static final int initial = 2;
    

    public Hawaiian() {
    	
    	toppings.add(Topping.Pineapple);
    	toppings.add(Topping.Ham);
    }
    
	@Override
	public double price() {
		
		if(size == Size.Small)
			return ((smallSize + (toppingIncrease * (toppings.size() - initial))));
		else if(size == Size.Medium)
			return ((mediumSize + (toppingIncrease * (toppings.size() - initial))));
		else
			return ((largeSize + (toppingIncrease * (toppings.size() - initial))));
	}

	@Override
	public String toString() {
		String pizza = "Hawaiian Pizza:: ( Toppings:  ";
		for(int x = 0; x < toppings.size(); x++) {
			if(x == toppings.size() -1 )
				pizza += getTopping(toppings.get(x))+") ";
			else
				pizza += getTopping(toppings.get(x))+", ";
		
		}
		pizza = pizza + getSize(size)+ " Subtotal:  " + this.price();
		return pizza;
	}
	
	private String getSize(Size sze) {
		if(sze == Size.Small )
			return "Small";
		else if(sze == Size.Medium)
			return "Medium";
		else
			return "Large";
	}

	public String getTopping(Topping topping) {
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

	@Override
	public int getIndex() {
		return initial;
	}
    
	
	
}
