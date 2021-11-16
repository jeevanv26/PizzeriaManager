package application;

import java.util.ArrayList;

/**
 * abstract pizza super class
 * @author Jeevan Vasanthan, Noah Young
 *
 */
public abstract class Pizza{
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;
    public abstract double price();
    public abstract String toString();
}