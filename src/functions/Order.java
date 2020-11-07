package functions;

import java.util.ArrayList;

public class Order implements Customizable {
    public static int lineNumber;
    private final ArrayList<OrderLine> orderLines = new ArrayList<>();

    public void resetLineNumber() {
        lineNumber = 0;
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof OrderLine) {
            lineNumber++;
            ((OrderLine) obj).setLineNumber(lineNumber);
            return orderLines.add((OrderLine) obj);
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof OrderLine) {
            if (orderLines.contains(obj)) {
                lineNumber--;
                orderLines.subList(orderLines.indexOf(obj), orderLines.size()).
                        forEach(orderLine -> orderLine.setLineNumber(orderLine.getLineNumber()-1));
                return orderLines.remove(obj);
            }
        }
        return false;
    }
}
