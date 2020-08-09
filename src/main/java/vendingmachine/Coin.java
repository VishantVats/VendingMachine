package vendingmachine;

/**
 * @author Vishant
 * COIN_TYPE("Coin Name", int cost)
 */
public enum Coin {
    NICKEL("nickel", 10),
    DIME("dime", 25),
    QUARTER("quarter", 50),
    CENT("cent", 100);

    private final String label;
    private final int cost;

    /**
     * @param label The plain text name of the Coin
     * @param cost The Coin's cost
     */
    Coin(String label, int value) {
        this.label = label;
        this.cost = value;
    }

    /**
     * @return The plain text name of the Coin
     */
    public String label() {
        return this.label;
    }

    /**
     * @return The Coin's cost
     */
    public int cost() {

        return this.cost;
    }
}
