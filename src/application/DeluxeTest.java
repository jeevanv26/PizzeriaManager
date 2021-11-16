package application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeluxeTest {
	
	// some error checking is handled by the GUI
	private Pizza pizza1;
	private Pizza pizza2;
	private Pizza pizza3;
	private Pizza pizza4;
	private Pizza pizza5;
	private Pizza pizza6;
	public static final double expectedPrice1 = 19.97; 
	public static final double expectedPrice2 = 17.97;
	public static final double expectedPrice3 = 15.97;
	public static final double expectedPrice4 = 16.48;
	public static final double expectedPrice5 = 14.99;
	public static final double expectedPrice6 = 12.99 ;


	@Before
	public void setUp() throws Exception {
		pizza1 = PizzaMaker.createPizza("Deluxe");
		pizza2 = PizzaMaker.createPizza("Deluxe");
		pizza3 = PizzaMaker.createPizza("Deluxe");
		pizza4 = PizzaMaker.createPizza("Deluxe");
		pizza5 = PizzaMaker.createPizza("Deluxe");
		pizza6 = PizzaMaker.createPizza("Deluxe");
		pizza1.toppings.add(Topping.Garlic);
		pizza1.toppings.add(Topping.Onion); // will check 7 toppings
		pizza1.size = Size.Large;
		pizza2.toppings.add(Topping.Garlic); // will check medium size (toppings remain the same)
		pizza2.toppings.add(Topping.Onion);
		pizza2.size = Size.Medium;
		pizza3.toppings.add(Topping.Garlic);  // will check small size(toppings remain the same)
		pizza3.toppings.add(Topping.Onion);
		pizza3.size = Size.Small;
		pizza4.toppings.add(Topping.Pineapple); // will check 6 toppings
		pizza4.size = Size.Medium;
		pizza5.size = Size.Medium; // will check 5 toppings
		pizza6.toppings.remove(Topping.Sausage); // will check under the default number of toppings
		pizza6.size = Size.Small;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Assert.assertEquals(expectedPrice1, pizza1.price(),0.01);
		Assert.assertEquals(expectedPrice2, pizza2.price(),0.01);
		Assert.assertEquals(expectedPrice3, pizza3.price(),0.01);
		Assert.assertEquals(expectedPrice4, pizza4.price(),0.01);
		Assert.assertEquals(expectedPrice5, pizza5.price(),0.01);
		Assert.assertEquals(expectedPrice6, pizza6.price(),0.01);
		
	}

}
