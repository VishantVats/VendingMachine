package vendingmachine;

/**
 * @author Vishant
 */
public class Candy implements Item {

    @Override
    public String getName() {
        return "Candy";
    }

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public int hashCode() {
        return 247*(getName().hashCode()+getCost());
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        Item ob = (Item)obj;
        if(ob.getCost()==this.getCost() && ob.getName().equals(this.getName())){
            return true;
        }
        return false;
    }

}
