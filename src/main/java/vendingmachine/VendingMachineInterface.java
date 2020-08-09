package vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Vending Machine interface - operations to be exposed
 * @author Vishant
 */
public interface VendingMachineInterface {

    /**
     * add or select product in vending machine
     * @param type The type of Product being added to the order.
     * @param count The number of units of Product type 'type' to add to the order.
     */
    public void addToOrder(final Product type, final int count);

    /**
     *
     * @return All the ordered Product as a mapping of Product types to Integer quantities.
     */
    public Map<Product, Integer> getOrderedProduct();

    /**
     * get total amount of selected products
     * @return The total cost of the order.
     */
    public int getTotalOrderCost();

    /**
     * get count of specific product
     * @param type The type of Product
     * @return The total number of units of Product 'type' in the order.
     */
    public int getTypeCount(Product type);

    /**
     * get cost of specific product
     * @param type The type of Product being ordered
     * @return The total cost of just the Product units of 'type' in the order.
     */
    public int getTypeCost(Product type);

    /**
     * get count of products selected
     * @return
     */
    public int getTotalOrderQuantity();

    /**
     * insert or add coins to machine
     * @param type
     * @param count
     */
    public void insertCoin(final Coin type, final int count);

    /**
     * total amount of coins inserted
     * @return
     */
    public int getTotalCoinsCost();

    /**
     *  count of coins inserted
     * @return
     */
    public int getCoinsCount();

    /**
     *  amount remaining to insert or collect
     * @return
     */
    public int collectChange();

    /**
     * dispense products from machine
     * @return
     */
    public List<Product> dispenseProducts();



}
