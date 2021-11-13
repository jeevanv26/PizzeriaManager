package application;

public class Deluxe extends Pizza{
    public static final double smallSize = 12.99;
    public static final double mediumSize = 14.99;
    public static final double largeSize = 16.99;
    public static final double toppingIncrease = 1.49;
    public static final double taxRate = 1.06625;
    public static final int toppingCap = 7;
    public static final int initial = 5;
    private int numOfToppings;

    public Deluxe() {
        numOfToppings = initial;
        toppings.add(Topping.Sausage);
        toppings.add(Topping.Bacon);
        toppings.add(Topping.Pepperoni);
        toppings.add(Topping.Ham);
        toppings.add(Topping.Mushroom);
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
