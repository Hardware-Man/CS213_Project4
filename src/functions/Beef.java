package functions;

public class Beef extends Sandwich {
    @Override
    public double price() {
        return 10.99 + extras.size()*PER_EXTRA;
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Beef";
        }
        return "Beef," + super.toString();
    }
}
