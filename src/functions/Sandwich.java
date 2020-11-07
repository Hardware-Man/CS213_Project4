package functions;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    public abstract double price();

    @Override
    public String toString() {
        StringBuilder extrasString = new StringBuilder("");
        for (int i = 0; i < extras.size(); i++) {
            if (i == extras.size()-1) {
                extrasString.append(extras.get(i).getName());
            }
            else {
                extrasString.append(extras.get(i).getName()).append(",");
            }
        }
        return extrasString.toString();
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Extra) {
            if (extras.size() < MAX_EXTRAS) {
                if (!extras.contains(obj)) {
                    return extras.add((Extra) obj);
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Extra) {
            return extras.remove(obj);
        }
        return false;
    }
}
