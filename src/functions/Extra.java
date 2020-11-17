package functions;
/**
 *Class representing extra ingredients
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Extra {
    private final String name;

    /**
     * Getter method for ingredient name
     * @return ingredient name
     */
    public String getName() {
        return name;
    }

    /**
     * Parametrized constructor for ingredient
     * @param name of extra ingredient
     */
    public Extra(String name){
        this.name = name;
    }

    /**
     * Equals method to compare two ingredients
     * @param obj ingredient instance
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Extra) {
            return ((Extra) obj).getName().equals(name);
        }
        return false;
    }

    /**
     * Returns string representation of Extra
     * @return Extra ingredient's name
     */
    @Override
    public String toString(){
        return getName();
    }
}
