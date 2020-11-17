package functions;

import java.text.DecimalFormat;

/**
 *Class representing chicken sandwiches
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Chicken extends Sandwich{

    /**
     * Calculates and returns price
     * @return price
     */
    @Override
    public double price() {
        DecimalFormat moneyFormat = new DecimalFormat("0.00");
        if (extras == null) return 8.99;
        return Double.parseDouble(moneyFormat.format(8.99 + extras.size()*PER_EXTRA));
    }

    @Override
    public String[] basicIng() {
        return new String[]{"Fried Chicken", "Spicy Sauce", "Pickles"};
    }

    /**
     * Returns string representation of sandwich and ingredients
     * @return String
     */
    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Chicken:" + getBasicIngredientsOrderDetails();
        }
        return "Chicken:" + getBasicIngredientsOrderDetails() + super.toString();
    }
}
