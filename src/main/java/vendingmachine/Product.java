package vendingmachine;

/**
 * @author Vishant
 * PRODUCTS_TYPE("Product Name", int cost)
*/
public enum Product {
	CHOCOLATE("Chocolate", 100),
	CANDY("Candy", 50),
	COLDDRINK("ColdDrink", 200);

	private final String label;
	private final int cost;

	/**
	 * @param label The plain text name of the Product
	 * @param cost The Product's cost
	 */
	Product(String label, int cost) {
		this.label = label;
		this.cost = cost;
	}

	/**
	 * @return The plain text name of the Product
	 */
	public String label() {
		return this.label;
	}

	/**
	 * @return The Product's cost
	 */
	public int cost() {
		
		return this.cost;
	}
}
