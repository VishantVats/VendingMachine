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
        vendingMachine.addToOrder(new Chocolate(), 0);
        vendingMachine.addToOrder(new Candy(), 0);
        vendingMachine.addToOrder(new ColdDrink(), 0);

        //total products selected
        assertEquals(0, vendingMachine.getTotalOrderCost());
    }

    @Test
    public void selectProducts() {
        vendingMachine.addToOrder(new Chocolate(), 6);
        vendingMachine.addToOrder(new Candy(), 10);
        vendingMachine.addToOrder(new ColdDrink(), 5);

        //total product cost
        assertEquals(2100, vendingMachine.getTotalOrderCost());
        //total product selected
        assertEquals(21, vendingMachine.getTotalOrderQuantity());
    }

    @Test
    public void validateProductCostAndQuantity() {

        Map<Item, Integer> orderedProduct = vendingMachine.getOrderedItem();
        assertEquals(21, orderedProduct.values().stream().mapToInt(Integer::intValue).sum());

        orderedProduct.keySet().forEach(Product -> {
            if ("Chocolate".equals(Product.getName())) {
                assertEquals(100, Product.getCost());
            }

            if ("Candy".equals(Product.getName())) {
                assertEquals(50, Product.getCost());
            }

            if ("ColdDrink".equals(Product.getName())) {
                assertEquals(200, Product.getCost());
            }
        });

        //total chocolates selected
        assertEquals(6, vendingMachine.getTypeCount(new Chocolate()));
        //amount of chocolates
        assertEquals(600, vendingMachine.getTypeCost(new Chocolate()));

        //total candies selected
        assertEquals(10, vendingMachine.getTypeCount(new Candy()));
        //amount of candies
        assertEquals(500, vendingMachine.getTypeCost(new Candy()));

        //total colddrinks selected
        assertEquals(5, vendingMachine.getTypeCount(new ColdDrink()));

        //amount of colddrinnks
        assertEquals(1000, vendingMachine.getTypeCost(new ColdDrink()));

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
        assertEquals(21, vendingMachine.dispenseItems().size());
    }






}
