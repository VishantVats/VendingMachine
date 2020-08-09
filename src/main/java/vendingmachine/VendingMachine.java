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
     * Product items to order quantities
     */
     Map<Product, Integer> prodMap;

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
     * add or select product to order
     * @param type
     * @param productCount
     */
    public void addToOrder(final Product type, final int productCount) {
        System.out.println("Product Type: "+ type+" Count: "+productCount);
        prodMap.put(type, productCount);

    }

    /**
     *
     * @return prodMap
     */
    public Map<Product, Integer> getOrderedProduct() {
        System.out.println("Total Products selected..");
        for(Product prod: prodMap.keySet()){
            System.out.println("Name: "+prod.label()+" quantity: "+prodMap.get(prod));
        }
        
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
     * dispense products from vending machine
     * @return
     */
    public List<Product> dispenseProducts() {
        List<Product> prodList = new ArrayList<>();
        System.out.println("Total products to be dispensed...");
        for(Product prod: prodMap.keySet()){

            System.out.println("Product Name :"+prod.label() +" Quantity: "+prodMap.get(prod));
            for(int i =0;i<prodMap.get(prod);i++){
                prodList.add(prod);
            }

        }
        return prodList;
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
        System.out.println("Total Number of Products: "+total);

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