package vendingmachine;

import java.util.HashMap;

/**
 * Vending Machine
 * @author Vishant
 */
public class VendingMachine implements VendingMachineInterface {
    /**
     * Product items to order quantities
     */
     HashMap<Product, Integer> prodMap = new HashMap<>();

    /**
     *  Coins with quantities
     */
    HashMap<Coin, Integer> coinMap = new HashMap<>();

    /**
     * Constructor
     */
    VendingMachine() {

    }

    /**
     * add or select product to order
     * @param type
     * @param ProductCount
     */
    public void addToOrder(final Product type, final int productCount) {
        
        prodMap.put(type, productCount);

    }

    /**
     *
     * @return prodMap
     */
    public HashMap<Product, Integer> getOrderedProduct() {
        
        return prodMap;
    }

    /**
     *
     * @return total cost of selected products
     */
    public int getTotalOrderCost() {
        

        int total =0;
        for(Product prod: prodMap.keySet()){
            total = total+ prod.cost()*prodMap.get(prod);
        }

        return total;
    }

    /**
     * insert coin in machine
     * @param type
     * @param coinCount
     */
    public void insertCoin(final Coin type, final int coinCount){

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
     *  get count of specific product
     * @param type
     * @return
     */
    public int getTypeCount(Product type) {

        int count = 0;
        if(prodMap.get(type)!=null){
            count = prodMap.get(type);
        }
        return count;
    }

    /**
     * get cost of specific product
     * @param type
     * @return
     */
    public int getTypeCost(Product type) {

        int cost = 0;
        if(prodMap.get(type) != null)
            cost = type.cost()*prodMap.get(type);

        return cost;
    }

    /**
     * get count of total items selected
     * @return
     */
    public int getTotalOrderQuantity() {
        int total =0;
        for(Product prod: prodMap.keySet()){
            total = total+ prodMap.get(prod);
        }
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

        return totalCoins;

    }


}