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
     * add or select Item in vending machine
     * @param type The type of Item being added to the order.
     * @param count The number of units of Item type 'type' to add to the order.
     */
    public void addToOrder(final Item type, final int count);

    /**
     *
     * @return All the ordered Item as a mapping of Item types to Integer quantities.
     */
    public Map<Item, Integer> getOrderedItem();

    /**
     * get total amount of selected Items
     * @return The total cost of the order.
     */
    public int getTotalOrderCost();

    /**
     * get count of specific Item
     * @param type The type of Item
     * @return The total number of units of Item 'type' in the order.
     */
    public int getTypeCount(Item type);

    /**
     * get cost of specific Item
     * @param type The type of Item being ordered
     * @return The total cost of just the Item units of 'type' in the order.
     */
    public int getTypeCost(Item type);

    /**
     * get count of Items selected
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
     * dispense Items from machine
     * @return
     */
    public List<Item> dispenseItems();



}
