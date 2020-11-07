package functions;

public class Fish extends Sandwich {
    @Override
    public double price() {
        return 12.99 + extras.size()*PER_EXTRA;
    }

    @Override
    public String toString() {
        if (super.toString().isBlank()) {
            return "Fish";
        }
        return "Fish," + super.toString();
    }
}
