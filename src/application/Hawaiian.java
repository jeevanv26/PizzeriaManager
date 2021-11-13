package application;

public class Hawaiian extends Pizza{
	
    public static final double smallSize = 10.99;
    public static final double mediumSize = 12.99;
    public static final double largeSize = 14.99;
    public static final double toppingIncrease = 1.49;
    public static final double taxRate = 1.06625;
    public static final int toppingCap = 7;
    public static final int initial = 2;
    private int numOfToppings;
    

    public Hawaiian() {
    	
    	numOfToppings = initial;
    	toppings.add(Topping.Pineapple);
    	toppings.add(Topping.Ham);
    }
    
	@Override
	public double price() {
		
		if(size == Size.Small)
			return ((smallSize + (toppingIncrease * (numOfToppings - initial)))) * taxRate;
		else if(size == Size.Medium)
			return ((mediumSize + (toppingIncrease * (numOfToppings - initial)))) * taxRate;
		else
			return ((largeSize + (toppingIncrease * (numOfToppings - initial)))) * taxRate;
	}
	
	public void addTopping(Topping topping) {  //might need error checking , but probably can be done directly in GUIController 
		
		toppings.add(topping);
		numOfToppings++;
	}
	
	public void removeTopping(Topping topping) { // might need error checking, but probably can be done directly in GUIController
		
		toppings.remove(topping);
		numOfToppings--;
	}
}
