package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Vending Machine
 * @author Vishant
 */
public class VendingMachine implements VendingMachineInterface {

    /**
     * Item items to order quantities
     */
    Map<Item, Integer> prodMap;

    /**
     *  Coins with quantities
     */
    Map<Coin, Integer> coinMap ;

    /**
     * Constructor
     */
    VendingMachine() {
        this.prodMap = new HashMap<>();
        this.coinMap = new HashMap<>();

    }

    /**
     * add or select Item to order
     * @param type
     * @param ItemCount
     */
    public void addToOrder(final Item type, final int ItemCount) {
        System.out.println("Item Type: "+ type+" Count: "+ItemCount);
        prodMap.put(type, ItemCount);

    }

    /**
     *
     * @return prodMap
     */
    public Map<Item, Integer> getOrderedItem() {
        System.out.println("Total Items selected..");
        for(Item prod: prodMap.keySet()){
            System.out.println("Name: "+prod.getName()+" quantity: "+prodMap.get(prod));
        }

        return prodMap;
    }

    /**
     *
     * @return total cost of selected Items
     */
    public int getTotalOrderCost() {


        int total =0;
        for(Item prod: prodMap.keySet()){
            total = total+ prod.getCost()*prodMap.get(prod);
        }
        System.out.println("Total amount to be paid: "+total);

        return total;
    }

    /**
     * insert coin in machine
     * @param type
     * @param coinCount
     */
    public void insertCoin(final Coin type, final int coinCount){
        System.out.println("Coin inserted : "+type+" || Number of coins: "+coinCount );
        coinMap.put(type, coinCount);
    }

    /**
     * total money inserted in machine
     * @return total amount inserted
     */
    public int getTotalCoinsCost(){
        int totalCost =0;
        for(Coin coin: coinMap.keySet()){
            totalCost = totalCost+ coin.cost()*coinMap.get(coin);
        }
        System.out.println("Total amount of coins inserted: "+totalCost);

        return totalCost;

    }

    /**
     * amount to be collected or inserted
     * @return
     */
    public int collectChange(){


        int change = getTotalCoinsCost() - getTotalOrderCost();
        if(change > 0) {
            System.out.println("Please collect change... Amount: " + change);
        }else if(change <0){
            System.out.println("Please insert more coins.. Amount: "+(-change));
        }else{
            System.out.println("No balance remaining.. Thank you!");
        }

        return change;
    }

    /**
     * dispense Items from vending machine
     * @return
     */
    public List<Item> dispenseItems() {
        List<Item> prodList = new ArrayList<>();
        System.out.println("Total Items to be dispensed...");
        for(Item prod: prodMap.keySet()){

            System.out.println("Item Name :"+prod.getName() +" Quantity: "+prodMap.get(prod));
            for(int i =0;i<prodMap.get(prod);i++){
                prodList.add(prod);
            }

        }
        return prodList;
    }


    /**
     *  get count of specific Item
     * @param type
     * @return
     */
    public int getTypeCount(Item type) {

        int count = 0;
        if(prodMap.get(type)!=null){
            count = prodMap.get(type);
        }
        return count;
    }

    /**
     * get cost of specific Item
     * @param type
     * @return
     */
    public int getTypeCost(Item type) {

        int cost = 0;
        if(prodMap.get(type) != null)
            cost = type.getCost()*prodMap.get(type);

        return cost;
    }

    /**
     * get count of total items selected
     * @return
     */
    public int getTotalOrderQuantity() {
        int total =0;
        for(Item prod: prodMap.keySet()){
            total = total+ prodMap.get(prod);
        }
        System.out.println("Total Number of Items: "+total);

        return total;
    }

    /**
     *  get number of coins inserted
     * @return
     */
    public int getCoinsCount(){

        int totalCoins =0;
        for(Coin coin: coinMap.keySet()){
            totalCoins = totalCoins+ coinMap.get(coin);
        }

        System.out.println("Total coins inserted: "+totalCoins);
        return totalCoins;

    }


}