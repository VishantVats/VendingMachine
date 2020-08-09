package vendingmachine;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


/**
 * @author Vishant
 */
public class VendingMachineUnitTest {
    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void instantiate() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void selectNothing() {
        vendingMachine.addToOrder(Product.CHOCOLATE, 0);
        vendingMachine.addToOrder(Product.COLDDRINK, 0);
        vendingMachine.addToOrder(Product.CANDY, 0);

        //total products selected
        assertEquals(0, vendingMachine.getTotalOrderCost());
    }

   @Test
    public void selectProducts() {
        vendingMachine.addToOrder(Product.CHOCOLATE, 6);
        vendingMachine.addToOrder(Product.COLDDRINK, 5);
        vendingMachine.addToOrder(Product.CANDY, 10);

        //total product cost
        assertEquals(2100, vendingMachine.getTotalOrderCost());
       //total product selected
       assertEquals(21, vendingMachine.getTotalOrderQuantity());
    }

    @Test
    public void validateProductCostAndQuantity() {

        Map<Product, Integer> orderedProduct = vendingMachine.getOrderedProduct();

        assertEquals(21, orderedProduct.values().stream().mapToInt(Integer::intValue).sum());

        orderedProduct.keySet().forEach(Product -> {
            if ("Chocholate".equals(Product.label())) {
                assertEquals(100, Product.cost());
            }

            if ("Candy".equals(Product.label())) {
                assertEquals(50, Product.cost());
            }

            if ("ColdDrink".equals(Product.label())) {
                assertEquals(200, Product.cost());
            }
        });

        //total chocolates selected
        assertEquals(6, vendingMachine.getTypeCount(Product.CHOCOLATE));
        //amount of chocolates
        assertEquals(600, vendingMachine.getTypeCost(Product.CHOCOLATE));

        //total candies selected
        assertEquals(10, vendingMachine.getTypeCount(Product.CANDY));
        //amount of candies
        assertEquals(500, vendingMachine.getTypeCost(Product.CANDY));

        //total colddrinks selected
        assertEquals(5, vendingMachine.getTypeCount(Product.COLDDRINK));

        //amount of colddrinnks
        assertEquals(1000, vendingMachine.getTypeCost(Product.COLDDRINK));

        // Validates order size
        assertEquals(21, vendingMachine.getTotalOrderQuantity());
    }

    @Test
    public void validateProduct() {
    	for (Product p : Product.values()) {
    		switch(p.label()) {
    		case("Chocolate"):
    			assertEquals(100, p.cost());
    			break;
    		case("Candy"):
    			assertEquals(50, p.cost());
    			break;
    		case("ColdDrink"):
    			assertEquals(200, p.cost());
    			break;
    		}
    	}
    }


    @Test
    public void validateCoin() {
        for (Coin c : Coin.values()) {
            switch(c.label()) {
                case("nickel"):
                    assertEquals(10, c.cost());
                    break;
                case("dime"):
                    assertEquals(25, c.cost());
                    break;
                case("quarter"):
                    assertEquals(50, c.cost());
                    break;
                case("cent"):
                    assertEquals(100, c.cost());
                    break;
            }
        }
    }

    @Test
    public void validateCoinsCountAndValue() {
        vendingMachine.insertCoin(Coin.CENT, 20);
        vendingMachine.insertCoin(Coin.NICKEL, 5);
        vendingMachine.insertCoin(Coin.DIME, 2);
        vendingMachine.insertCoin(Coin.QUARTER, 1);

        //total coins
        assertEquals(28, vendingMachine.getCoinsCount());
        //total amount
        assertEquals(2150, vendingMachine.getTotalCoinsCost());
    }

    @Test
    public void collectBalanceAmountFromMachine() {

        vendingMachine.insertCoin(Coin.CENT, 20);
        vendingMachine.insertCoin(Coin.NICKEL, 5);
        vendingMachine.insertCoin(Coin.DIME, 2);
        vendingMachine.insertCoin(Coin.QUARTER, 1);

        //total balance amount to be collected
        assertEquals(vendingMachine.getTotalCoinsCost() - vendingMachine.getTotalOrderCost(), vendingMachine.collectChange());
    }

    @Test
    public void insertBalanceAmountInMachine() {

        vendingMachine.insertCoin(Coin.CENT, 10);
        vendingMachine.insertCoin(Coin.NICKEL, 5);
        vendingMachine.insertCoin(Coin.DIME, 2);
        vendingMachine.insertCoin(Coin.QUARTER, 1);

        //total balance amount to be inserted
        assertEquals(vendingMachine.getTotalCoinsCost() - vendingMachine.getTotalOrderCost(), vendingMachine.collectChange());
    }

    @Test
    public void dispenseProductsFromMachine() {


        //total products dispensed
        assertEquals(21, vendingMachine.dispenseProducts().size());
    }






}
