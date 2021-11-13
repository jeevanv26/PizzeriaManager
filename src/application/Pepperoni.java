package application;

public class Pepperoni extends Pizza {
    public static final double smallSize = 8.99;
    public static final double mediumSize = 10.99;
    public static final double largeSize = 12.99;
    public static final double toppingIncrease = 1.49;
    public static final double taxRate = 1.06625;
    public static final int toppingCap = 7;
    public static final int initial = 1;
    private int numOfToppings;
	
    public Pepperoni() {
        numOfToppings = initial;
        toppings.add(Topping.Pepperoni);
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
    
    public void addTopping(Topping topping) {
        toppings.add(topping);
        numOfToppings++;
    }
    
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
        numOfToppings--;
    }
}
