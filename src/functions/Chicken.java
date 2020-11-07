package functions;

public class Chicken extends Sandwich{
    @Override
    public double price() {
        return 8.99 + extras.size()*PER_EXTRA;
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Chicken";
        }
        return "Chicken," + super.toString();
    }
}
