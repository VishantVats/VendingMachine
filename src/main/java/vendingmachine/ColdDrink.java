package vendingmachine;

/**
 * @author Vishant
 */
public class ColdDrink implements Item {

    @Override
    public String getName() {
        return "ColdDrink";
    }

    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public int hashCode() {
        return 247*(getName().hashCode()+getCost());
    }

    @Override
    public boolean equals(Object obj) {
        Item ob = (Item)obj;
        if(ob.getCost()==this.getCost() && ob.getName().equals(this.getName())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getName();
    }
}
